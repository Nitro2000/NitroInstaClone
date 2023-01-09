package com.example.libimgur

import com.example.libimgur.apis.ImgurApiService
import junit.framework.Assert.assertNotNull
//import junit.framework.TestCase.assertNotNull
import okhttp3.OkHttpClient
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class ImgurApiTest {

    private val client = OkHttpClient.Builder().addInterceptor{
        val req = it.request().newBuilder().addHeader("Authorization", "Client-ID daa9b863a109e98").build()
        it.proceed(req)
    }.build()

    private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .baseUrl("https://api.imgur.com/").build()

    private val api = retrofit.create(ImgurApiService::class.java)

    @Test
    fun get_tag_api_working() {
//        assertNotNull(4)
        val responce = api.getTag().execute()
        println(responce.raw().toString())
        assertNotNull(responce.body())
    }

    @Test
    fun get_gallery_working() {
        val responce = api.getGallery().execute()
        println(responce.raw().toString())
        assertNotNull(responce.body())
    }
}