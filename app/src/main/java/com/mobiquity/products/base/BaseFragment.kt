package com.mobiquity.products.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import dagger.android.support.AndroidSupportInjection

/**
 * All fragments should extend this class and providing the ViewBinding generic type of the layout
 */
abstract class BaseFragment<T : ViewBinding> : Fragment() {

    /**
     * viewBinding instance of activity layout
     */
    protected lateinit var binding: T

    /**
     * @return ViewBinding instance of the activity
     */
    protected abstract fun getViewBinding() : T

    /**
     * this method is called after initializing the fragment as a callback function for sub-classes
     */
    protected abstract fun onFragmentCreated()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setupDependencyInjection()
        binding = getViewBinding()
        return binding.root
    }

    private fun setupDependencyInjection() {
        AndroidSupportInjection.inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        onFragmentCreated()
    }

    protected fun showErrorMessage(msg: String){
        Toast.makeText(context,msg, Toast.LENGTH_SHORT).show()
    }

    protected fun showSuccessMessage(msg: String){
        Toast.makeText(context,msg, Toast.LENGTH_SHORT).show()
    }
}