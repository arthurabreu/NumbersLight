package com.arthur.android.numberslight.network.model

import com.google.gson.annotations.SerializedName

data class NumberDetailsEntity (
        @SerializedName("name") val name : Int,
        @SerializedName("text") val text : String,
        @SerializedName("image") val image : String
)