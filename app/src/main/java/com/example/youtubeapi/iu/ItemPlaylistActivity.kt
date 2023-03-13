package com.example.youtubeapi.iu


import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi.base.BaseActivity
import com.example.youtubeapi.databinding.ActivityItemPlaylistBinding

class ItemPlaylistActivity : BaseActivity<PlaylistsViewModel, ActivityItemPlaylistBinding>() {

    override val viewModel: PlaylistsViewModel by lazy {
        ViewModelProvider(this)[PlaylistsViewModel::class.java]
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityItemPlaylistBinding{
        return ActivityItemPlaylistBinding.inflate(layoutInflater)
    }

    override fun initView() {
        val data = intent.getStringExtra(PlaylistsActivity.KEY)
        Toast.makeText(this, "$data", Toast.LENGTH_SHORT).show()
    }
}