package com.ethanchae.template.ui.activity

import com.ethanchae.template.R
import com.ethanchae.template.base.BaseActivity
import com.ethanchae.template.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>() {
    override val layoutRes = R.layout.activity_main
    override val viewModelClass = MainActivityViewModel::class

    override fun subscribeState() {}
}
