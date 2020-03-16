package com.mobiquity.products.data.model

import com.google.gson.annotations.SerializedName

data class CategoryModel(
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("description") val description : String,
    @SerializedName("products") val products : List<ProductModel>
)