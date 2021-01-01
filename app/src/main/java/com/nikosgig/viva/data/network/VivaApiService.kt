package com.nikosgig.viva.data.network

import com.nikosgig.viva.data.model.ProductModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://vivawallet.free.beeceptor.com/v1/api/"
const val PRODUCTS = "products"

private val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
private val okHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface VivaApiService {

    @GET(PRODUCTS)
    suspend fun getProducts(): List<ProductModel>
}

object VivaApi {
    val retrofitService: VivaApiService = retrofit.create(VivaApiService::class.java)
}