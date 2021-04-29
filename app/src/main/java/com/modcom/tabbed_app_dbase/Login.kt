package com.modcom.tabbed_app_dbase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        btn_login.setOnClickListener{

            val client = AsyncHttpClient(true, 80,443)
            val parameter = RequestParams()
            parameter.add("username", edit_username.text.toString())
            parameter.add("password", edit_password.text.toString())

            val url = "http://10.0.2.2/api/login.php";

            client.post(url, parameter, object: AsyncHttpResponseHandler()
            {
                override fun onSuccess(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray?) {
                    TODO("Not yet implemented")
                }

                override fun onFailure(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray?, error: Throwable?) {
                    TODO("Not yet implemented")
                }


            }
            )//end post

        }//end listner
    }//end oncreate
}//end class