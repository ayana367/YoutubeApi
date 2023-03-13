package com.example.youtubeapi.iu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeapi.BuildConfig
import com.example.youtubeapi.base.BaseViewModel
import com.example.youtubeapi.model.Playlists
import com.example.youtubeapi.remote.ApiService
import com.example.youtubeapi.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PlaylistsViewModel: BaseViewModel() {
    val data = MutableLiveData<Playlists>()
    private val apiService:ApiService by lazy {
        RetrofitClient.create()
    }
    fun playlist(): LiveData<Playlists>{
        return getPlaylist()
    }

    private fun getPlaylist(): LiveData<Playlists> {

        apiService.getPlaylists(BuildConfig.API_KEY,"UC3IZsePLgOfAxUN","snippet,contentDetails")
            .enqueue(object:Callback<Playlists>{
                override fun onResponse(call: Call<Playlists>, response: Response<Playlists>) {
                    if (response.isSuccessful)
                        data.value = response.body()
                }

                override fun onFailure(call: Call<Playlists>, t: Throwable) {
                   println(t.message)
                }
            })
        return data
    }
}