package com.mobiquity.products.ui.product_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobiquity.products.data.model.ProductModel
import com.mobiquity.products.databinding.ItemProductBinding

class ProductListAdapter (
    private val list: List<ProductModel>
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
        holder.binding.tvPrice.text = product.salePrice.amount.toString()
    }

    class ProductItemHolder(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}
