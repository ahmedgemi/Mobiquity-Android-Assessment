package com.mobiquity.products.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import dagger.android.AndroidInjection

/**
 * All activities should extend this class and providing the ViewBinding generic type
 */
abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {

    /**
     * viewBinding instance of activity layout
     */
    protected lateinit var binding: T

    /**
     * @return ViewBinding instance of the activity
     */
    protected abstract fun getViewBinding() : T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
    }

    private fun setupDependencyInjection() {
        AndroidInjection.inject(this)
    }

    protected fun showErrorMessage(msg: String){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    protected fun showSuccessMessage(msg: String){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }
}