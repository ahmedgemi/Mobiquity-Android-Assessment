package com.mobiquity.products.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PriceModel (

    @SerializedName("amount") val amount : String,
    @SerializedName("currency") val currency : String
) : Parcelable