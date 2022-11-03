package com.raihan.mobileappdemo.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.raihan.mobileappdemo.R

class MovieDetails : AppCompatActivity() {
    private lateinit var image_icon: ImageView
    private lateinit var movie_name: TextView
    private lateinit var movie_rating: TextView
    private lateinit var description_value: TextView
    var title = ""
    var rating = ""
    var trailerLink = ""
    var description = ""
    var genre = ""
    var releasedDate = ""
    var imageId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        image_icon = findViewById(R.id.image_icon)
        movie_name = findViewById(R.id.movie_name)
        movie_rating = findViewById(R.id.movie_rating)
        description_value = findViewById(R.id.description_value)

        title = intent.getStringExtra("title").toString()
        //imageId = intent.getIntExtra("imageId")
        rating = intent.getStringExtra("rating").toString()
        trailerLink = intent.getStringExtra("trailerLink").toString()
        description = intent.getStringExtra("description").toString()
        genre = intent.getStringExtra("genre").toString()
        releasedDate = intent.getStringExtra("releasedDate").toString()

        movie_name.text = title
        movie_rating.text = rating
        description_value.text = description

        //  imageId.let { image_icon.setImageResource(it) }

        image_icon.setImageResource(R.drawable.tenet)


    }
}