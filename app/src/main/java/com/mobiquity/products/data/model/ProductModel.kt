package com.mobiquity.products.data.model

import com.google.gson.annotations.SerializedName

class ProductModel (
    @SerializedName("id") val id : Int,
    @SerializedName("categoryId") val categoryId : Int,
    @SerializedName("name") val name : String,
    @SerializedName("url") val url : String,
    @SerializedName("description") val description : String,
    @SerializedName("salePrice") val salePrice : PriceModel
)