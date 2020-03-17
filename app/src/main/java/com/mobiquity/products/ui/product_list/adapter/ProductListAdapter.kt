package com.mobiquity.products.ui.product_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobiquity.products.R
import com.mobiquity.products.data.model.ProductModel
import com.mobiquity.products.databinding.ItemProductBinding
import com.squareup.picasso.Picasso

class ProductListAdapter (
    private val list: List<ProductModel>,
    private val onItemClick: ((ProductModel) -> Unit)
): RecyclerView.Adapter<ProductListAdapter.ProductItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductItemHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ProductItemHolder, position: Int) {
        val product = list[position]

        holder.binding.tvName.text = product.name
        holder.binding.tvPrice.text = product.salePrice.amount
        holder.binding.tvCurrency.text = product.salePrice.currency

        holder.binding.root.setOnClickListener {
            onItemClick(product)
        }

        if(!product.url.isNullOrEmpty()) {

            Picasso.get()
                .load("http://mobcategories.s3-website-eu-west-1.amazonaws.com${product.url}" )
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.not_found)
                .into(holder.binding.ivProduct)
        }

    }

    class ProductItemHolder(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}
