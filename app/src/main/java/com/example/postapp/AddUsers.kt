package com.example.postapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddUsers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_users)

        val viewuserBtn=findViewById<Button>(R.id.viewBtn)
        val addusersbtn=findViewById<Button>(R.id.addusserBtn)
        val editTextName=findViewById<EditText>(R.id.editTextName)
        val editTextPk=findViewById<EditText>(R.id.editTextPk)
        val editTextLocation=findViewById<EditText>(R.id.editTextLocation)
        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
        addusersbtn.setOnClickListener {
            val userPk=1
           val username=editTextName.text.toString()
            val userlocation=editTextLocation.text.toString()


            apiInterface!!.addUsers(UserDetailsItem(userPk,username,userlocation)).enqueue(object: Callback<UserDetailsItem>{
                override fun onResponse(
                    call: Call<UserDetailsItem>,
                    response: Response<UserDetailsItem>
                ) {
                    Toast.makeText(applicationContext, "The User Has Been Added Successfully!!", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<UserDetailsItem>, t: Throwable) {
                    Toast.makeText(applicationContext, "Sorry,The User Has Not Been Added Successfully!!", Toast.LENGTH_SHORT).show()
                }

            }
            )
        }
        viewuserBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}