package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.assigment.R
import com.example.myapp.api.ApiService
import com.example.myapp.model.ObjectModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var objectAdapter: ObjectAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        listView = findViewById(R.id.listView)

        fetchData()
    }

    private fun fetchData() {
        val apiService = ApiService.create().getObjects()
        apiService.enqueue(object : Callback<List<ObjectModel>> {
            override fun onResponse(call: Call<List<ObjectModel>>, response: Response<List<ObjectModel>>) {
                if (response.isSuccessful) {
                    val objects = response.body() ?: emptyList()
                    objectAdapter = ObjectAdapter(this@MainActivity, objects)
                    listView.adapter = objectAdapter

                    listView.setOnItemClickListener { _, _, position, _ ->
                        val selectedObject = objects[position]
                        val intent = Intent(this@MainActivity, DetailActivity::class.java)
                        intent.putExtra("object", selectedObject)
                        startActivity(intent)
                    }
                }
            }

            override fun onFailure(call: Call<List<ObjectModel>>, t: Throwable) {
                // Handle API failure
            }
        })
    }
}
