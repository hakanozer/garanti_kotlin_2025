package com.works

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.works.activities.Products
import com.works.configs.ApiClient
import com.works.models.LoginModel
import com.works.models.UserModel
import com.works.services.JsonBulut
import com.works.utils.Util
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var jsonBulut: JsonBulut

    lateinit var l_txtEmail: EditText
    lateinit var l_txtPassword: EditText
    lateinit var l_btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        jsonBulut = ApiClient().getClient().create(JsonBulut::class.java)

        l_txtEmail = findViewById(R.id.l_txtEmail)
        l_txtPassword = findViewById(R.id.l_txtPassword)
        l_btnLogin = findViewById(R.id.l_btnLogin)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        l_btnLogin.setOnClickListener {
            fncLogin()
        }
    }

    private fun fncLogin() {
        val email = l_txtEmail.text.toString()
        val password = l_txtPassword.text.toString()
        val senObj = LoginModel(email, password)

        jsonBulut.userLogin(senObj).enqueue(object : Callback<UserModel> {
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                if (response.isSuccessful) {
                    val userModel = response.body()
                    userModel?.let {
                        Util.user = it
                        val i = Intent(this@MainActivity, Products::class.java)
                        startActivity(i)
                    }
                }else {
                    Toast.makeText(this@MainActivity, "Incorrect email or password.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }
        })

    }

}