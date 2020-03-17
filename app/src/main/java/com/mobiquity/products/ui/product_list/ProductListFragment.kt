package com.mobiquity.products.ui.product_list

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobiquity.products.R
import com.mobiquity.products.base.BaseFragment
import com.mobiquity.products.databinding.FragmentProductListBinding
import com.mobiquity.products.ui.ViewModelFactory
import com.mobiquity.products.ui.product_details.ProductDetailsFragment
import com.mobiquity.products.ui.product_list.adapter.CategoryListAdapter
import com.mobiquity.products.ui.product_list.adapter.ProductListAdapter
import javax.inject.Inject


class ProductListFragment : BaseFragment<FragmentProductListBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: ProductListViewModel
    private lateinit var adapter:  CategoryListAdapter

    override fun getViewBinding(): FragmentProductListBinding {
        return FragmentProductListBinding.inflate(layoutInflater)
    }

    override fun onFragmentCreated() {
        viewModel = ViewModelProvider(this,viewModelFactory).get(ProductListViewModel::class.java)


        viewModel.categoriesLiveData.observe(this, Observer { it ->
            adapter = CategoryListAdapter(context,it,onItemClick = { product->

                val bundle = Bundle()
                bundle.putParcelable("model",product)
                val action = ProductListFragmentDirections.openDetails(product)
                //action.arguments.putParcelable("model",product)
                findNavController().navigate(action)
            })
            binding.rvProducts.layoutManager = LinearLayoutManager(context)
            binding.rvProducts.adapter = adapter
        })
    }

}
