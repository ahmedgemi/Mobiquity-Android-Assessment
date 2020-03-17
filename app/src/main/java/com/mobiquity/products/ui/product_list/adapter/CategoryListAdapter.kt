package com.mobiquity.products.ui.product_list.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobiquity.products.data.model.CategoryModel
import com.mobiquity.products.data.model.ProductModel
import com.mobiquity.products.databinding.ItemCategoryBinding


class CategoryListAdapter (
    private val context: Context?,
    private val list: List<CategoryModel>,
    private val onItemClick: ((ProductModel) -> Unit)
): RecyclerView.Adapter<CategoryListAdapter.CategoryItemHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryItemHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CategoryItemHolder, position: Int) {
        val category = list[position]

        val productAdapter = ProductListAdapter(category.products,onItemClick)
        holder.binding.rvProducts.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        holder.binding.rvProducts.adapter = productAdapter
        holder.binding.tvCategory.text = category.name
    }

    class CategoryItemHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}