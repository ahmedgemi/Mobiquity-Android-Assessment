package com.mobiquity.products.ui.product_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobiquity.products.data.ProductRepository
import com.mobiquity.products.data.Result
import com.mobiquity.products.data.model.CategoryModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductListViewModel @Inject constructor(
    private val productRepository: ProductRepository) : ViewModel(){

    private val categoriesLiveData = MutableLiveData<Result<List<CategoryModel>>>()

    fun getCategoryLiveData(): LiveData<Result<List<CategoryModel>>>
            = categoriesLiveData

    init {
        getProducts()
    }

    fun getProducts(){
        categoriesLiveData.value = Result.Loading
        viewModelScope.launch{
            try {
                categoriesLiveData.value = productRepository.getProducts()
            }
            catch (err: Exception){
                print(err)
            }
        }
    }

}