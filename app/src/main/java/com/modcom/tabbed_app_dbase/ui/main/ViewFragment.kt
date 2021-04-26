package com.modcom.tabbed_app_dbase.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.loopj.android.http.RequestParams
import com.modcom.tabbed_app_dbase.R
import cz.msebera.android.httpclient.Header


class ViewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //front end  - what the users see
        //specify the url with the data
        //use 10.0.2.2 for emulator
        //using phone  :  http://modcom.co.ke/api/view.php
        val url = "http://10.0.2.2/api/view.php";
        //Front End side
        val root = inflater.inflate(R.layout.fragment_view, container, false)

        //client a client object
        val client = AsyncHttpClient(true,80,443)

        //below object to be used in case we want to submit something to the server
        val parameters =  RequestParams()

        //Now use AsyncHttpClient to connect to your APi - url
        client.post(url, parameters, object: AsyncHttpResponseHandler()
        {
            override fun onSuccess(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray) {
                //convert Byte array to string
                val response = String(responseBody)
                //find your textview
                val results = root.findViewById<TextView>(R.id.results)
                //Put the response to the textview
                results.text = response

            }

            override fun onFailure(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray?, error: Throwable?) {
                val results = root.findViewById<TextView>(R.id.results)
                results.text = "Server Error Encountered"
            }

        }
        )//post


        return root
    }

}//end fragment