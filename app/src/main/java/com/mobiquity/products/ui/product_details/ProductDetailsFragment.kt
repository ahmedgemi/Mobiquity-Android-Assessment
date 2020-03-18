package com.mobiquity.products.ui.product_details

import android.os.Bundle
import androidx.transition.TransitionInflater
import com.mobiquity.products.R
import com.mobiquity.products.base.BaseFragment
import com.mobiquity.products.data.model.ProductModel
import com.mobiquity.products.databinding.FragmentProductDetailsBinding
import com.squareup.picasso.Picasso

class ProductDetailsFragment : BaseFragment<FragmentProductDetailsBinding>() {

    override fun getViewBinding(): FragmentProductDetailsBinding {
        return FragmentProductDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }
    override fun onFragmentCreated() {

        val product = arguments?.getParcelable<ProductModel>("model")

        binding.tvName.text = product?.name
        binding.tvPrice.text = product?.salePrice?.amount
        binding.tvCurrency.text = product?.salePrice?.currency

        if(!product?.url.isNullOrEmpty()) {
            Picasso.get()
                .load("http://mobcategories.s3-website-eu-west-1.amazonaws.com${product?.url}" )
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(binding.ivProduct)
        }
    }

}
