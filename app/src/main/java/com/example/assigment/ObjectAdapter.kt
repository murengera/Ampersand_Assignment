package com.example.myapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.assigment.R
import com.example.myapp.model.ObjectModel

class ObjectAdapter(private val context: Context, private val dataList: List<ObjectModel>) : BaseAdapter() {

    override fun getCount(): Int = dataList.size

    override fun getItem(position: Int): Any = dataList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_object, parent, false)

        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        val priceTextView: TextView = view.findViewById(R.id.priceTextView)
        val colorTextView: TextView = view.findViewById(R.id.colorTextView)

        val currentItem = getItem(position) as ObjectModel
        nameTextView.text = currentItem.name
        priceTextView.text = "Price: $${currentItem.data?.price}"
        colorTextView.text = if (currentItem.data?.color.isNullOrEmpty()) {
            "No color available"
        } else {
            "Color: ${currentItem.data?.color}"
        }

        return view
    }
}
