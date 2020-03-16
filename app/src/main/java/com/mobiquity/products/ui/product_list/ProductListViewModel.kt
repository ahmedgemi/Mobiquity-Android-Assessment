package com.mobiquity.products.ui.product_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobiquity.products.data.ProductRepository
import com.mobiquity.products.data.Result
import com.mobiquity.products.data.model.ProductListResponse
import com.mobiquity.products.data.model.ProductModel
import com.mobiquity.products.data.remote.ProductRemoteDataSource
import com.mobiquity.products.network.NetworkDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ProductListViewModel @Inject constructor() : ViewModel(){

    val productsLiveData = MutableLiveData<List<ProductModel>>()

    init {
        getProducts()
    }

    fun getProducts(){
        val repo = ProductRepository(ProductRemoteDataSource(NetworkDispatcher()))


        viewModelScope.launch{
            try {
                val response = repo.getProducts()

                when(response){
                    is Result.Success ->{
                        val list = ArrayList<ProductModel>()
                        for(category in response.data){
                            list.addAll(category.products)
                        }

                        productsLiveData.value = list
                    }
                }


            }
            catch (err: Exception){
                print(err)
            }
        }
    }

}