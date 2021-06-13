package com.example.viewpager

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class myadapter(val songs: List<dataclass>): RecyclerView.Adapter<myadapter.myviewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        val inflator = LayoutInflater.from(parent.context)

        val view = inflator.inflate(R.layout.cardview, parent, false)

        return myviewholder(view)
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        holder.textview1.text = songs[position].string1
        Glide.with(holder.image1.context).load("https://firebasestorage.googleapis.com/v0/b/viewpager-4b2b6.appspot.com/o/images%2Fbackground.png?alt=media&token=73f0695b-9278-4d9f-b5b2-6a4cfb5c38ad").into(holder.image1)
        holder.button.setVisibility(View.GONE)

        if(position == 2) {

            holder.button.setVisibility(View.VISIBLE)

            holder.button.setOnClickListener()
            {
                rcv.setVisibility(View.GONE)
            }
        }

    }

    override fun getItemCount(): Int {
        return songs.size
    }


    class myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image1 = itemView.findViewById<ImageView>(R.id.imageview)
        val textview1 = itemView.findViewById<TextView>(R.id.textview1)
        val button = itemView.findViewById<Button>(R.id.button)
        val container = itemView.findViewById<RelativeLayout>(R.id.container)

        init {
            itemView.setOnClickListener()
            {
                Toast.makeText(itemView.context,
                    "you clicked item ${adapterPosition + 1}",
                    Toast.LENGTH_SHORT).show()
            }

        }
    }
}