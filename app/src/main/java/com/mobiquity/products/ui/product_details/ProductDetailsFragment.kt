package com.mobiquity.products.ui.product_details

import com.mobiquity.products.R
import com.mobiquity.products.base.BaseFragment
import com.mobiquity.products.data.model.ProductModel
import com.mobiquity.products.databinding.FragmentProductDetailsBinding

class ProductDetailsFragment : BaseFragment<FragmentProductDetailsBinding>() {

    override fun getViewBinding(): FragmentProductDetailsBinding {
        return FragmentProductDetailsBinding.inflate(layoutInflater)
    }

    override fun onFragmentCreated() {

        val product = arguments?.getParcelable<ProductModel>("model")
        print("")
    }

}
