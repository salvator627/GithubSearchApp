package com.example.github.API

import com.example.github.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface  API {
    @GET("search/users")
    @Headers("Autorization: token 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")
    fun getSearch(
        @Query("q") query : String
    ):Call<UserResponse>
}