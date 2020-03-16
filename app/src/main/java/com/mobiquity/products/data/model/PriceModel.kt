package com.mobiquity.products.data.model

import com.google.gson.annotations.SerializedName

data class PriceModel (

    @SerializedName("amount") val amount : Double,
    @SerializedName("currency") val currency : String
)