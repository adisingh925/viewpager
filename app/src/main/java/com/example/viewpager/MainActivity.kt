package com.example.viewpager

import android.os.Bundle
import android.os.Handler
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

        val url = "https://images.unsplash.com/photo-1552519507-da3b142c6e3d?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Y2Fyc3xlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&w=1000&q=80"

        Glide
            .with(this)
            .load(url)
            .circleCrop()
            .into(img12)

/////////////////////////////////////////////////////////////////////////////////////////////////////
        songobjects.add(dataclass("aditya",img12))
        songobjects.add(dataclass("yuvraj",img12))
        songobjects.add(dataclass("rudra",img12))
/////////////////////////////////////////////////////////////////////////////////////////////////////

        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(rcv)

        rcv.adapter = rcv1
        rcv.layoutManager = LinearLayoutManager(this,HORIZONTAL,false)

///////////////////////////////////////////////////////////////////////////////////////////////////////
        imageview.setOnClickListener()
        {
            rcv.setVisibility(View.VISIBLE)
            (rcv.layoutManager as LinearLayoutManager).scrollToPosition(0)

            val speedScroll = 3000
            val handler: Handler = Handler()

            val runnable: Runnable = object : Runnable {
                var count = 0
                override fun run() {
                    if (count < 3) {
                        rcv.smoothScrollToPosition(count++)
                        handler.postDelayed(this, speedScroll.toLong())
                    }
                }
            }
            handler.postDelayed(runnable, speedScroll.toLong())
        }
        ////////////////////////////////////////////////////////////////////////////////////////////



        ////////////////////////////////////////////////////////////////////////////////////////////
        val speedScroll = 3000
        val handler: Handler = Handler()

        val runnable: Runnable = object : Runnable {
            var count = 0
            override fun run() {
                if (count < 3) {
                    rcv.smoothScrollToPosition(count++)
                    handler.postDelayed(this, speedScroll.toLong())
                }
            }
        }
        handler.postDelayed(runnable, speedScroll.toLong())
        ////////////////////////////////////////////////////////////////////////////////////////////
    }
}