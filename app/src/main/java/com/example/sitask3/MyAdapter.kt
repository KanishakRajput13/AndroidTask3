package com.example.sitask3

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater


class MyAdapter ( var heroArrayList: ArrayList<Hero>, var context : Activity) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

        //to hold the views and preventing them from loading multiple times (to save memory)
        class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
            val hName = itemView.findViewById<TextView>(R.id.headingTitle)
            val hImage = itemView.findViewById<ImageView>(R.id.headingImage)
    }


    //to create new views, if layout manager fails
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_row, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem = heroArrayList[position]
        holder.hName.text = currentItem.heroName
        holder.hImage.setImageResource(currentItem.heroImage)
    }

    //to get no. of items in the array
    override fun getItemCount(): Int {
        return heroArrayList.size
    }


}