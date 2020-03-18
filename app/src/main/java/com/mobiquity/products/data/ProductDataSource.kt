package com.mobiquity.products.data

import com.mobiquity.products.data.model.CategoryModel

interface ProductDataSource {

    suspend fun fetchCategories(): Result<List<CategoryModel>>
}