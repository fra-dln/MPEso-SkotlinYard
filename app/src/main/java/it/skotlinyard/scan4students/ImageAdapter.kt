package it.skotlinyard.scan4students

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.camera.camera2.interop.CaptureRequestOptions
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ImageAdapter(private var context: Context, private var imagesList: ArrayList<Image>) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {


    class ImageViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var image:ImageView?=null
        init {
            image=itemView.findViewById(R.id.row_image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.row_custom_recycler_item,parent,false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val currentImage=imagesList[position]

        Glide.with(context)
            .load(currentImage.imagePath)
            .apply(RequestOptions().centerCrop())
            .into(holder.image!!)

        holder.image?.setOnClickListener {
            val intent= Intent(context, ImmageFullActivity::class.java)
            intent.putExtra("path",currentImage.imagePath)
            intent.putExtra("name",currentImage.imageName)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return imagesList.size
    }
}