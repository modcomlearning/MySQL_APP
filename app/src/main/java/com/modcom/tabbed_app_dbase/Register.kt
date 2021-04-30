package com.modcom.tabbed_app_dbase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.loopj.android.http.RequestParams
import cz.msebera.android.httpclient.Header
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        //find the button
        btn_reg_user.setOnClickListener{

            if (edit_reg_password.text.toString() != edit_reg_password_confirm.toString()){
                edit_reg_password.setError("Password do not match")
            }


            else{
               val client = AsyncHttpClient(true, 80,443)
                val parameter = RequestParams()
                parameter.add("username", edit_reg_username.text.toString())
                parameter.add("email", edit_reg_email.text.toString())
                parameter.add("password", edit_reg_password.text.toString())

                val url = "http://10.0.2.2/api/register.php";

                client.post(url, parameter, object: AsyncHttpResponseHandler()
                {
                    override fun onSuccess(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray?) {
                        Toast.makeText(applicationContext, "Thank you for joining", Toast.LENGTH_LONG).show()
                    }

                    override fun onFailure(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray?, error: Throwable?) {
                        Toast.makeText(applicationContext, "Failed , Network connections problem", Toast.LENGTH_LONG).show()
                    }
                }
                )

            }

        }//end button click

    }
}