package com.example.domain.models.properties

data class Data(
    val description: String,
    val id: Int,
    val list: Boolean,
    val name: String,
    val options: ArrayList<Option>,
    val other_value: Any,
    val parent: Any,
    val slug: String,
    val type: String,
    val value: String
)