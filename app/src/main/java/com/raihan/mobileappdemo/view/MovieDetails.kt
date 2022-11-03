package com.raihan.mobileappdemo.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.raihan.mobileappdemo.R

class MovieDetails : AppCompatActivity() {
    private lateinit var image_icon: ImageView
    private lateinit var movie_name: TextView
    var title = ""
    var imageId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        image_icon = findViewById(R.id.image_icon)
        movie_name = findViewById(R.id.movie_name)

        title = intent.getStringExtra("title").toString()
      //  imageId = intent.getStringExtra("imageId")!!.toInt()
        movie_name.text = title
       //git movie_name.text = imageId.toString()

      //  imageId.let { image_icon.setImageResource(it) }

        image_icon.setImageResource(R.drawable.tenet)


    }
}