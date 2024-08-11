package com.example.myapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.assigment.R
import com.example.myapp.model.ObjectModel

class DetailActivity : AppCompatActivity() {

    private lateinit var nameTextView: TextView
    private lateinit var priceTextView: TextView
    private lateinit var colorTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Show back arrow
        supportActionBar?.setDisplayShowTitleEnabled(true) // Show title

        nameTextView = findViewById(R.id.nameTextView)
        priceTextView = findViewById(R.id.priceTextView)
        colorTextView = findViewById(R.id.colorTextView)

        val selectedObject = intent.getParcelableExtra<ObjectModel>("object")

        selectedObject?.let {
            nameTextView.text = it.name
            priceTextView.text = "Price: $${it.data?.price}"
            colorTextView.text = if (it.data?.color.isNullOrEmpty()) {
                "No color available"
            } else {
                "Color: ${it.data?.color}"
            }

            // Set the toolbar title to the name of the product
            supportActionBar?.title = it.name
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
