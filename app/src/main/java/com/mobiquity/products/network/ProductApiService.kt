package com.mobiquity.products.network

import com.mobiquity.products.data.model.CategoryListResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductApiService {
    @GET("/")
    suspend fun fetchProducts(): Response<CategoryListResponse>
}