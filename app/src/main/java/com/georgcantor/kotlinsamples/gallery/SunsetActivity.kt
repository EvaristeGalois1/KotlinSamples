package com.georgcantor.kotlinsamples.gallery

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.georgcantor.kotlinsamples.R
import com.squareup.picasso.Picasso

class SunsetActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var imageGalleryAdapter: ImageGalleryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sunset)

        val layoutManager = GridLayoutManager(this, 2)
        recyclerView = findViewById(R.id.rv_images)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager
        imageGalleryAdapter = ImageGalleryAdapter(this, SunsetPhoto.getSunsetPhotos())
    }

    override fun onStart() {
        super.onStart()
        recyclerView.adapter = imageGalleryAdapter
    }

    private inner class ImageGalleryAdapter(val context: Context,
                                            val sunsetPhotos: Array<SunsetPhoto>)
        : RecyclerView.Adapter<ImageGalleryAdapter.MyViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
                : ImageGalleryAdapter.MyViewHolder {
            val context = parent.context
            val inflater = LayoutInflater.from(context)
            val photoView = inflater.inflate(R.layout.item_image, parent, false)
            return MyViewHolder(photoView)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val sunsetPhoto = sunsetPhotos[position]
            val imageView = holder.photoImageView

            Picasso.get()
                    .load(sunsetPhoto.url)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .fit()
                    .tag(context)
                    .into(imageView)
        }

        override fun getItemCount(): Int {
            return sunsetPhotos.size
        }

        inner class MyViewHolder(itemView: View)
            : RecyclerView.ViewHolder(itemView), View.OnClickListener {

            var photoImageView: ImageView = itemView.findViewById(R.id.iv_photo)

            init {
                itemView.setOnClickListener(this)
            }

            override fun onClick(v: View) {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {

                }
            }
        }
    }
}
