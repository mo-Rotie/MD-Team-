package com.dicoding.picodiploma.mycamera.data.api

import com.google.gson.annotations.SerializedName

data class FileUploadResponse(

    @field:SerializedName("status")
    val status: Status
)

data class Data(

    @field:SerializedName("percentage")
    val percentage: Int,

    @field:SerializedName("classType")
    val classType: String
)

data class Status(

    @field:SerializedName("code")
    val code: Int,

    @field:SerializedName("data")
    val data: Data,

    @field:SerializedName("message")
    val message: String
)
