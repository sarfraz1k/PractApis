package com.example.practexmsapi


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adopter (val context: Context, val userInfo: userInfo):RecyclerView.Adapter<Adopter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.single_row,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        Glide.with(context).load(userInfo.get(position).avatar_url).into(holder.userImage)
        holder.userName.text=userInfo.get(position).login
    }

    override fun getItemCount(): Int {
        return userInfo.size
    }
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        var userImage: ImageView= itemView.findViewById(R.id.imageView)
        var userName: TextView= itemView.findViewById(R.id.textView)

    }

}