package com.arthur.android.numberslight.network.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class NLEntity (
    @SerializedName("name") var name: String,
    @SerializedName("image") var image: String
)