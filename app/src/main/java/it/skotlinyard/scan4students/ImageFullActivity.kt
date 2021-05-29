package it.skotlinyard.scan4students

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide

class ImageFullActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_full)

        val imagePath= intent.getStringExtra("path")
        val imageName= intent.getStringExtra("name")
        supportActionBar?.setTitle(imagePath)


        Glide.with(this)
            .load(imagePath)
            .into(findViewById(R.id.imageView))
    }
}