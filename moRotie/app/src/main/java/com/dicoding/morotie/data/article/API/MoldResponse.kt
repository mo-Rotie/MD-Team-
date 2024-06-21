package com.dicoding.morotie.api

import com.dicoding.morotie.model.MoldItem

data class MoldResponse(
    val status: String,
    val data: MoldData
)

data class MoldData(
    val mold_table: List<MoldItem>
)
