package com.example.lab2.api

import com.example.lab2.model.Historical
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface HistoricalService {
    @Headers("X-api-key:VELGUaJE9vvJKog0XnNa8ZGn9TJW3VzaFj7pYolr")
    @GET("historicalfigures")
    fun fetchHistoricalLIst(@Query("name") name: String) : Call<List<Historical>>
}