package com.works.activities

import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.works.R
import com.works.adapters.ProductAdapter
import com.works.configs.ApiClient
import com.works.models.Product
import com.works.models.ProductsModel
import com.works.services.JsonBulut
import com.works.utils.Util
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Products : AppCompatActivity() {

    lateinit var p_txtName: TextView
    lateinit var jsonBulut: JsonBulut
    var arr = listOf<Product>()
    lateinit var p_listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_products)
        jsonBulut = ApiClient().getClient().create(JsonBulut::class.java)

        p_txtName = findViewById(R.id.p_txtName)
        "Sn. ${Util.user!!.data.user.name}".also { p_txtName.text = it }
        p_listView = findViewById(R.id.p_listView)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        fncProductList()
    }

    private fun fncProductList() {
        jsonBulut.allProducts(1,10).enqueue(object : Callback<ProductsModel> {
            override fun onResponse(call: Call<ProductsModel>, response: Response<ProductsModel>) {
                if(response.isSuccessful) {
                    val dt = response.body()
                    dt?.let {
                        this@Products.arr = it.data
                        val adapter = ProductAdapter(this@Products, it.data)
                        p_listView.adapter = adapter
                    }
                }
            }
            override fun onFailure(call: Call<ProductsModel>, t: Throwable) {
                Toast.makeText(this@Products, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

}