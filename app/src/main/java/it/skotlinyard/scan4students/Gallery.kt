package it.skotlinyard.scan4students

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import it.skotlinyard.scan4students.databinding.ActivityImmageFullBinding
import it.skotlinyard.scan4students.databinding.ActivityMainBinding
import java.io.File
import java.lang.Exception
import java.util.jar.Manifest

class Gallery : AppCompatActivity() {
    private var imageRecycler:RecyclerView?=null
    private var progressBar:ProgressBar?=null
    private var allPictures:ArrayList<Image>?=null

    private lateinit var binding: ActivityImmageFullBinding

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


        val gestore = FolderWorker()
        val listOfFiles = gestore.getListFileFromDirectory("")
        if (listOfFiles == null) {
        }
        if (listOfFiles != null) {
            listOfFiles.forEach { i ->
                val image=Image()
                image.imagePath=i.path
                image.imageName=i.name
                images.add(image)}
        }

        return images

        /*val allImageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI

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
        }*/


    }
}