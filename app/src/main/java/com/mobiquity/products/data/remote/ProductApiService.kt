package com.mobiquity.products.data.remote

import com.mobiquity.products.data.model.CategoryModel
import com.mobiquity.products.data.model.ProductListResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductApiService {
    @GET("/")
    suspend fun fetchProducts(): Response<ProductListResponse>
}