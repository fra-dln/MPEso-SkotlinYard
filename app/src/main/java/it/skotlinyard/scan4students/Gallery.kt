package it.skotlinyard.scan4students

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ProgressBar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception
import java.util.jar.Manifest

class Gallery : AppCompatActivity() {
    private var imageRecycler:RecyclerView?=null
    private var progressBar:ProgressBar?=null
    private var allPictures:ArrayList<Image>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        imageRecycler=findViewById(R.id.image_recycler)
        progressBar=findViewById(R.id.reycler_progressBar)

        imageRecycler?.layoutManager=GridLayoutManager(this,3)
        imageRecycler?.setHasFixedSize(true)

        //Storage Permissions
        if(ContextCompat.checkSelfPermission(this@Gallery, android.Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this@Gallery, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),101)
        }
        allPictures= ArrayList()
        if(allPictures!!.isEmpty())
        {
            progressBar?.visibility=View.VISIBLE
            //get all Images from storage
            allPictures=getAllImages()
            //set adapter to recycler
            imageRecycler?.adapter=ImageAdapter(this, allPictures!!)
            progressBar?.visibility=View.GONE
        }
    }

    private fun getAllImages(): ArrayList<Image>? {
        val images=ArrayList<Image>()

        val allImageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI

        val projection = arrayOf(MediaStore.Images.ImageColumns.DATA,MediaStore.Images.Media.DISPLAY_NAME)

        var cursor=this@Gallery.contentResolver.query(allImageUri,projection,null,null,null)

        try{
            cursor!!.moveToFirst()
            do {
                val image=Image()
                image.imagePath=cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA))
                image.imageName=cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME))
                images.add(image)
            }while(cursor.moveToNext())
            cursor.close()
        }catch (e:Exception)
        {
            e.printStackTrace()
        }

        return images
    }
}