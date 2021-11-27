package com.example.nueva

import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.get
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json

//import kotlinx.serialization.json


class RepositorioDelClima {

    private val httpCLient = HttpClient(){
        install(Logging){
            level = LogLevel.ALL
            logger = object : Logger{
                override fun log(message: String){
                    Napier.v(tag = "HttpClient", message = message)
                }
            }
        }
        install(JsonFeature){
            val json = Json{ ignoreUnknownKeys = true}
            serializer = KotlinxSerializer(json)
        }
            .also{
            initLogger()
        }
    }

    suspend fun obtenerClima(): Clima{
        return httpCLient.get("https://api.jsonbin.io/b/614defac4a82881d6c54cbe9")
    }
}