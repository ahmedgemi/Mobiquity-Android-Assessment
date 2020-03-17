package com.mobiquity.products.ui.product_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobiquity.products.data.ProductRepository
import com.mobiquity.products.data.Result
import com.mobiquity.products.data.model.CategoryModel
import com.mobiquity.products.data.remote.ProductRemoteDataSource
import com.mobiquity.products.network.NetworkDispatcher
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class ProductListViewModel @Inject constructor() : ViewModel(){

    val categoriesLiveData = MutableLiveData<List<CategoryModel>>()

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
                        categoriesLiveData.value = response.data
                    }
                }


            }
            catch (err: Exception){
                print(err)
            }
        }
    }

}