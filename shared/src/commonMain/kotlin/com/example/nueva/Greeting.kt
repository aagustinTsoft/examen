package com.example.nueva

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}