package com.example.postapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import okhttp3.Response
import retrofit2.Call
import retrofit2.Callback


class MainActivity : AppCompatActivity() {
   private var  users:String=""
    lateinit var usersView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        usersView=findViewById(R.id.viewUsers)
        var addusersBtn=findViewById<Button>(R.id.addUsersbtn)
        addusersBtn.setOnClickListener {
            val intent = Intent(this, AddUsers::class.java)
            startActivity(intent)
        }
        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)

        apiInterface!!.getUsers().enqueue(object : Callback<List<UserDetailsItem>> {


            override fun onFailure(call: Call<List<UserDetailsItem>>, t: Throwable) {
                call.cancel()
            }

            override fun onResponse(
                call: Call<List<UserDetailsItem>>,
                response: retrofit2.Response<List<UserDetailsItem>>
            ) {
                val list=response.body()!!
                //usersView.text= list().toString()
                for(user in list){
                    users+="${user.name}\n${user.location}\n"
                }
                usersView.text= users
            }
        })
    }
}