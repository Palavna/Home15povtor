package com.example.yana.home15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yana.home15.databinding.ActivityDetailsBinding
import java.net.IDN

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val userID = intent.getIntExtra(TV_ID, -1)
        val user = RoomApp.DB?.getUserDao()?.getUser(userID)

        binding.tvId.text = user?.id.toString()
        binding.tvTitle.text = user?.title.toString()
        binding.tvContent.text = user?.content.toString()
        binding.textData.text = user?.dataTv.toString()
    }

    companion object{
        const val TV_ID = "TV_ID"
        const val TV_TITLE = "TV_TITLE"
        const val TV_CONTENT = "TV_CONTENT"
        const val TEXT_DATA = "TEXT_DATA"

    }
}