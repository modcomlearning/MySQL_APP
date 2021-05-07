package com.modcom.tabbed_app_dbase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.loopj.android.http.RequestParams
import cz.msebera.android.httpclient.Header
import kotlinx.android.synthetic.main.activity_login.*


class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //this an activity
        //link to register
        btn_register.setOnClickListener{
            val x = Intent(applicationContext, Register::class.java)
            startActivity(x)
        }



        btn_login.setOnClickListener{

            val client = AsyncHttpClient(true, 80,443)
            val parameter = RequestParams()
            parameter.add("username", edit_username.text.toString())
            parameter.add("password", edit_password.text.toString())

            val url = "http://10.0.2.2/api/login.php";

            client.post(url, parameter, object: AsyncHttpResponseHandler()
            {
                override fun onSuccess(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray) {
                    val response = String(responseBody)

                    if (response.startsWith("1")){
                        //successful - php responds with a 1
                        val array = response.split("#")
                        //Toast.makeText(applicationContext, "resp"+array[1], Toast.LENGTH_LONG).show()

                        if(array[1]=="user"){
                            val x = Intent(applicationContext, MainActivity::class.java)
                            startActivity(x)
                            finish() //kill login as you move to main
                        }


                        else if(array[1]=="admin"){
                            val x = Intent(applicationContext, AdminMain::class.java)
                            startActivity(x)
                            finish() //kill login as you move to main
                        }


                        else{
                            val x = Intent(applicationContext, Login::class.java)
                            startActivity(x)
                            finish() //kill login as you move to main
                        }


                    }

                    else if(response.startsWith("2")){
                        Toast.makeText(applicationContext, "User Does not exist", Toast.LENGTH_LONG).show()
                    }

                    else{
                        Toast.makeText(applicationContext, "Login Failed", Toast.LENGTH_LONG).show()
                        //code

                    }

                }//end on success

                override fun onFailure(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray?, error: Throwable?) {
                    Toast.makeText(applicationContext, "Failed. Network Error", Toast.LENGTH_LONG).show()
                }//end on failure
            }
            )//end post

        }//end listner
    }//end oncreate
}//end class

//8.30am - 10.30am - mon - fri