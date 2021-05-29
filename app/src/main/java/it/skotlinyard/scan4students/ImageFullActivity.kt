package it.skotlinyard.scan4students

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import it.skotlinyard.scan4students.databinding.ActivityImageFullBinding

class ImageFullActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImageFullBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageFullBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imagePath= intent.getStringExtra("path")
        val imageName= intent.getStringExtra("name")
        supportActionBar?.title = imagePath


        Glide.with(this)
            .load(imagePath)
            .into(binding.imageView)
    }
}