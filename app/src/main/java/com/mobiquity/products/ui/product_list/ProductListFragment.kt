package com.mobiquity.products.ui.product_list

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.mobiquity.products.base.BaseFragment
import com.mobiquity.products.databinding.FragmentProductListBinding
import com.mobiquity.products.ui.ViewModelFactory
import javax.inject.Inject


class ProductListFragment : BaseFragment<FragmentProductListBinding>() {

    @Inject
    protected lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: ProductListViewModel
    private lateinit var adapter: ProductListAdapter

    override fun getViewBinding(): FragmentProductListBinding {
        return FragmentProductListBinding.inflate(layoutInflater)
    }

    override fun onFragmentCreated() {
        viewModel = ViewModelProvider(this,viewModelFactory).get(ProductListViewModel::class.java)


        viewModel.productsLiveData.observe(this, Observer {
            adapter = ProductListAdapter(it)
            binding.rvProducts.layoutManager = GridLayoutManager(context,2)
            binding.rvProducts.adapter = adapter
        })
    }

}
