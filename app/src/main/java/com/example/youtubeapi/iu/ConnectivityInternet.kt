package com.example.youtubeapi.iu
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

class ConnectivityInternet {
    fun isInternetAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network =  connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
        return activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                || activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                || activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
    }

}