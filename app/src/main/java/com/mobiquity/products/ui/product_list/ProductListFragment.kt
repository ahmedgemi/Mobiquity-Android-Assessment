package com.mobiquity.products.ui.product_list

import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobiquity.products.base.BaseFragment
import com.mobiquity.products.data.Result
import com.mobiquity.products.data.model.CategoryModel
import com.mobiquity.products.databinding.FragmentProductListBinding
import com.mobiquity.products.ui.ViewModelFactory
import com.mobiquity.products.ui.product_list.adapter.CategoryListAdapter
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


        viewModel.getCategoryLiveData().observe(this, Observer { it ->
            when(it){
                is Result.Success-> {
                    setCategoryList(it.data)
                }
                is Result.Loading-> {
                    showProgress()
                }
                is Result.Error-> {
                    showNetworkError()
                }
            }
        })
    }

    private fun showNetworkError(){
        binding.layoutProgress.root.visibility = View.GONE
        binding.layoutNetwordError.root.visibility = View.VISIBLE
        binding.layoutNetwordError.btnTryAgain.setOnClickListener {
            viewModel.getProducts()
        }
    }

    private fun showProgress() {
        binding.rvProducts.visibility = View.GONE
        binding.layoutNetwordError.root.visibility = View.GONE
        binding.layoutProgress.root.visibility = View.VISIBLE
    }

    private fun setCategoryList(list: List<CategoryModel>){
        binding.layoutProgress.root.visibility = View.GONE
        binding.layoutNetwordError.root.visibility = View.GONE
        binding.rvProducts.visibility = View.VISIBLE
        adapter = CategoryListAdapter(context,list)
        binding.rvProducts.layoutManager = LinearLayoutManager(context)
        binding.rvProducts.adapter = adapter
    }

}
