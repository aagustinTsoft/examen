package com.example.nueva

expect class Platform() {
    val platform: String
}

expect fun initLogger()