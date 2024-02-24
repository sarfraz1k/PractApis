package com.example.practexmsapi

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder

class MainActivity : AppCompatActivity() {
    var apiUrl="https://api.github.com/users"
    var userInfoItem = arrayOf<userInfoItem>()
    var userInfo = userInfo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView= findViewById<RecyclerView>(R.id.recyclerdata)

        val stringRequest = StringRequest(apiUrl, Response.Listener {
             val gsonB= GsonBuilder()
            val gson= gsonB.create()
            userInfoItem= gson.fromJson(it, Array<userInfoItem>::class.java)
            userInfoItem.forEach{
                userInfo.add(it)
            }
          val adopter= Adopter(this,userInfo)
            recyclerView.layoutManager=LinearLayoutManager(this)
            recyclerView.adapter=adopter

        },Response.ErrorListener {
            Toast.makeText(this@MainActivity, "Something went wrong"+it.toString(),Toast.LENGTH_LONG).show()
        })
        val volleyQueue= Volley.newRequestQueue(this)
        volleyQueue.add(stringRequest)

    }

}