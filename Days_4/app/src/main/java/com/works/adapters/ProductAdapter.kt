package com.works.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.works.R
import com.works.models.Product

class ProductAdapter(
    private val activity: Activity,
    private val list: List<Product>
    ) : ArrayAdapter<Product>(activity, R.layout.product_item, list){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = activity.layoutInflater.inflate(R.layout.product_item, null, true)
        val item = list.get(position)

        val r_title = rootView.findViewById<TextView>(R.id.pi_title)
        val r_category = rootView.findViewById<TextView>(R.id.pi_category)
        val r_price = rootView.findViewById<TextView>(R.id.pi_price)
        val image = rootView.findViewById<ImageView>(R.id.pi_image)

        r_title.setText(item.title)
        r_category.setText(item.category)
        r_price.setText("${item.price}₺")

        Glide.with(rootView).load(item.images[0]).into(image)

        return rootView
    }
}