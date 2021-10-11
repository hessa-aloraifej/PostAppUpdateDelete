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

class UpdateDeleteUsers : AppCompatActivity() {

private var userPk:Int=0
    private var username:String=""
    private var userlocation:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_delete_users)
        val deletbtn=findViewById<Button>(R.id.deletebtn)
        val updatebtn=findViewById<Button>(R.id.updateBtn)
        val changebtn=findViewById<Button>(R.id.changesbtn)
        val editTextName=findViewById<EditText>(R.id.tvName)
        val editTextPk=findViewById<EditText>(R.id.tvId)
        val editTextLocation=findViewById<EditText>(R.id.tvLocation)

        changebtn.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)

        }
        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
        deletbtn.setOnClickListener {

            val userPk=editTextPk.text.toString().toInt()
            val username=editTextName.text.toString()
            val userlocation=editTextLocation.text.toString()


            apiInterface!!.deleteUser(userPk).enqueue(object: Callback<Void>
            {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Toast.makeText(applicationContext, "The User Has Been Deleted Successfully!!", Toast.LENGTH_SHORT).show()

                move()
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext, "Sorry,The User Has Not Been Deleted Successfully!!", Toast.LENGTH_SHORT).show()
                }

            })

        }

       updatebtn.setOnClickListener {

            userPk=editTextPk.text.toString().toInt()
            username=editTextName.text.toString()
           userlocation=editTextLocation.text.toString()
           apiInterface!!.updateUser(userPk,UserDetailsItem(userPk,username,userlocation)).enqueue(object: Callback<UserDetailsItem>
           {
               override fun onResponse(call: Call<UserDetailsItem>, response: Response<UserDetailsItem>) {
                   Toast.makeText(applicationContext, "The User Has Been pdated Successfully!!", Toast.LENGTH_SHORT).show()
                 move()


               }

               override fun onFailure(call: Call<UserDetailsItem>, t: Throwable) {
                   Toast.makeText(applicationContext, "Sorry,The User Has Not Been Updated Successfully!!", Toast.LENGTH_SHORT).show()
               }

           })


       }





    }

fun move(){
    val intent=Intent(this,MainActivity::class.java)
    startActivity(intent)
}

}




