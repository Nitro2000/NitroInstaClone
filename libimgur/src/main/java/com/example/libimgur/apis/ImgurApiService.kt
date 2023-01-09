package com.example.libimgur.apis

import com.example.libimgur.models.GalleryResponce
import com.example.libimgur.models.GalleryTagResponse
import retrofit2.Call
import retrofit2.http.GET

interface ImgurApiService {

    @GET("/3/gallery/hot/?album_previews=true")
    fun getGallery(): Call<GalleryResponce>

    @GET("/3/tags")
    fun getTag(): Call<GalleryTagResponse>
}