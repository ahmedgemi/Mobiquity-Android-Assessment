package com.mobiquity.products.data

import com.mobiquity.products.data.model.CategoryModel

/**
 * this interface representing abstract methods (functionality) for different data-source (remote or local)
 */
interface ProductDataSource {

    suspend fun fetchCategories(): Result<List<CategoryModel>>
}