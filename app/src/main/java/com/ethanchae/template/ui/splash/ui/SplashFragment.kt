package com.ethanchae.template.ui.splash.ui

import android.widget.Toast
import com.ethanchae.template.R
import com.ethanchae.template.base.BaseFragment
import com.ethanchae.template.databinding.FragmentSplashBinding
import com.example.base.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding, SplashViewModel>() {
    override val layoutRes = R.layout.fragment_splash
    override val viewModelClass = SplashViewModel::class

    override fun subscribeState() {
        observe(viewModel.navigateToMain) {
            Toast.makeText(activity, "hello", Toast.LENGTH_SHORT).show()
        }
    }
}
