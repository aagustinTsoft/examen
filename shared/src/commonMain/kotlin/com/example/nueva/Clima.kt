package com.example.nueva

import kotlinx.serialization.Serializable

@Serializable
data class Clima (
    val estado: String,
    val temperatura: String,
    val hora: String
)