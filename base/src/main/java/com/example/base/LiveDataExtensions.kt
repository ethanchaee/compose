package com.example.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, block: (T) -> Unit) = liveData.observe(
    this,
    {
        block(it)
    }
)

fun <T : Any, L : LiveData<T>> Fragment.observe(liveData: L, block: (T) -> Unit) = liveData.observe(
    viewLifecycleOwner,
    {
        block(it)
    }
)
