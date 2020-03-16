package com.mobiquity.products.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: T
    protected abstract fun getViewBinding() : T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
    }

    protected fun showErrorMessage(msg: String){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    protected fun showSuccessMessage(msg: String){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }
}