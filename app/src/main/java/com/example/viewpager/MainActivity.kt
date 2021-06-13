package com.example.viewpager

import android.media.Image
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso

lateinit var rcv:RecyclerView

class MainActivity : AppCompatActivity() {

    val songobjects = mutableListOf<dataclass>()
    val rcv1 = myadapter(songobjects)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val storage = FirebaseStorage.getInstance()

        val storageref = storage.reference.child("images")

        rcv = findViewById<RecyclerView>(R.id.recyclerview)

        val imageview = findViewById<ImageView>(R.id.imageview)

        val img12 = findViewById<ImageView>(R.id.img12)

        val url = "https://firebasestorage.googleapis.com/v0/b/viewpager-4b2b6.appspot.com/o/images%2Fbackground.png?alt=media&token=73f0695b-9278-4d9f-b5b2-6a4cfb5c38ad"

        Picasso.with(this).load(url).into(
            img12)

        songobjects.add(dataclass("aditya",img12))
        songobjects.add(dataclass("yuvraj",img12))
        songobjects.add(dataclass("rudra",img12))

        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(rcv)

        rcv.adapter = rcv1
        rcv.layoutManager = LinearLayoutManager(this,HORIZONTAL,false)

        imageview.setOnClickListener()
        {
            rcv.setVisibility(View.VISIBLE)
            (rcv.layoutManager as LinearLayoutManager).scrollToPosition(0)
        }
    }
}