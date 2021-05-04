package com.modcom.tabbed_app_dbase

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
//check if password are same

            //capture  inputs from editexts as strings
            val str_username = edit_reg_username.text.toString()
            val str_email = edit_reg_email.text.toString()
            val str_password = edit_reg_password.text.toString()
            val str_password_confirm = edit_reg_password_confirm.text.toString()



            val regex1 = ".*[A-Z].*".toRegex()
            val regex2 = ".*[0-9].*".toRegex()
            val regex3 = ".*[a-z].*".toRegex()
            if (!str_password.matches(regex1)) {
                edit_reg_password.setError("Password does not contain a Capital Letter")
            }

            else if (!str_password.matches(regex2)) {
                edit_reg_password.setError("Password does not contain a number")
            }

            else if (!str_password.matches(regex3)) {
                edit_reg_password.setError("Password does not contain a small letter")
            }

            else if (str_password.length < 8){
                edit_reg_password.setError("Password Must be more than 8-ters")
            }

            else if (str_password != str_password_confirm){
                edit_reg_password.setError("Password do not match")
            }

            else if(str_username.length < 1){
                edit_reg_username.setError("Username is Empty")
            }


            else if(str_email.length < 1){
                edit_reg_email.setError("Email is Empty")
            }

            else if(!str_email.contains("@")){
                edit_reg_email.setError("Invalid Email")
            }

            else{
                //post data to php api
               val client = AsyncHttpClient(true, 80,443)
                val parameter = RequestParams()
                parameter.add("username", str_username)
                parameter.add("email", str_email)
                parameter.add("password", str_password)

                val url = "http://10.0.2.2/api/register.php";

                client.post(url, parameter, object: AsyncHttpResponseHandler()
                {
                    override fun onSuccess(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray?) {
                        Toast.makeText(applicationContext, "Thank you for joining", Toast.LENGTH_LONG).show()

                    }

                    override fun onFailure(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray?, error: Throwable?) {
                        Toast.makeText(applicationContext, "Failed , Network connections problem", Toast.LENGTH_LONG).show()
                    }
                })

            }

        }//end button click

    }
}