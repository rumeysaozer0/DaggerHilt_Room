package com.rumeysaozer.roomdaggerhilt.service


import com.rumeysaozer.roomdaggerhilt.model.Name
import retrofit2.http.GET

interface ImageApi {
    companion object{
        val BASE_URL = "https://random-data-api.com/api/"
    }
    @GET("name/random_name?size=20")
    suspend fun getImages(): Name
}