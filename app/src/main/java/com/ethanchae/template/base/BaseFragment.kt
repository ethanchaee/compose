package com.ethanchae.template.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.ethanchae.template.BR
import com.ethanchae.template.R
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlin.reflect.KClass

abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    lateinit var binding: VB

    val viewModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProvider(viewModelStore, defaultViewModelProviderFactory).get(viewModelClass.java)
    }

    private val navController: NavController
        get() = requireActivity().findNavController(R.id.navigation_fragment)

    protected abstract val layoutRes: Int

    protected abstract val viewModelClass: KClass<VM>

    abstract fun subscribeState()

    private val compositeDisposable by lazy(LazyThreadSafetyMode.NONE) { CompositeDisposable() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this.viewLifecycleOwner

        binding.setVariable(BR.viewModel, viewModel)
        viewModel.bindFragment(this)

        subscribeState()
    }

    protected open fun navigate(@IdRes id: Int) {
        navController.navigate(id)
    }
}
