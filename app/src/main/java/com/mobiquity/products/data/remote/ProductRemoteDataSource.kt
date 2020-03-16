package com.mobiquity.products.data.remote

import com.mobiquity.products.data.ProductDataSource
import com.mobiquity.products.data.Result
import com.mobiquity.products.data.model.CategoryModel
import com.mobiquity.products.data.model.ProductListResponse
import com.mobiquity.products.network.NetworkDispatcher
import retrofit2.Response
import java.io.IOException

class ProductRemoteDataSource
    constructor(private val networkDispatcher: NetworkDispatcher): ProductDataSource{

    override suspend fun getTasks(): Result<List<CategoryModel>> {

       val newsService = networkDispatcher.createService(ProductApiService::class.java,
           "http://mobcategories.s3-website-eu-west-1.amazonaws.com")

        val response = processCall(newsService::fetchProducts)
        return when (response) {
            is ProductListResponse -> {
                Result.Success(data = response)
            }
            else -> {
                Result.Error(response as Exception)
            }
        }
    }

    private suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {

        return try {
            val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful) {
                response.body()
            } else {
                responseCode
            }
        } catch (e: IOException) {
            e
        }
    }
}