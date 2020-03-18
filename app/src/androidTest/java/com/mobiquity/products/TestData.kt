package com.mobiquity.products

import com.mobiquity.products.data.model.CategoryModel
import com.mobiquity.products.data.model.PriceModel
import com.mobiquity.products.data.model.ProductModel

object AndroidMockData{

    fun getPriceObj(amount: String = "13.5",currency: String = "EUR"): PriceModel{
        return PriceModel(amount,currency)
    }

    fun  getProductObj(
        id: String = "50",
        categoryId: String = "10",
        name: String = "Pizza",
        url: String = "",
        description: String = "/pizza.jpg",
        price: PriceModel = getPriceObj()
    ): ProductModel{
        return ProductModel(id,categoryId,name,url,description,price)
    }

    fun getCategoryObj(id: String = "10",
                         name: String = "Food",
                         description: String = "test description",
                         products: MutableList<ProductModel> = mutableListOf(getProductObj())): CategoryModel{
        return CategoryModel(id, name, description, products)
    }

    fun getCategoryList(): MutableList<CategoryModel>{
        return mutableListOf(getCategoryObj())
    }
}