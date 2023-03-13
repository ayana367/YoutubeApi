package com.example.youtubeapi.remote

import com.example.youtubeapi.iu.Playlists
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("playlists")
    fun getPlaylists(
        @Query("key") apiKey:String,
        @Query("channelId") channelId: String,
        @Query("part") part: String,
        @Query("maxResults") maxResults : Int = 20
    ):Call<Playlists>

}