package com.mobiquity.products.data

import com.mobiquity.products.data.ProductDataSource
import com.mobiquity.products.data.model.CategoryModel
import javax.inject.Inject

class ProductRepository constructor(private val dataSource: ProductDataSource) {

    suspend fun getProducts(): Result<List<CategoryModel>>{
        return dataSource.getTasks()
    }
}