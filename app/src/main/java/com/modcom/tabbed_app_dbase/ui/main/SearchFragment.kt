package com.modcom.tabbed_app_dbase.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.loopj.android.http.RequestParams
import com.modcom.tabbed_app_dbase.R
import cz.msebera.android.httpclient.Header


class SearchFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_search, container, false)
        val make = root.findViewById<EditText>(R.id.edit_search_make)
        val search = root.findViewById<Button>(R.id.btn_search)

        search.setOnClickListener{
            val client = AsyncHttpClient(true, 80, 443)
            val parameter = RequestParams()
            parameter.add("make", make.text.toString())
            val url = "http://10.0.2.2/api/search.php";

            client.post(url, parameter, object: AsyncHttpResponseHandler()
            {

                override fun onSuccess(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray) {
                    val results = root.findViewById<TextView>(R.id.search_results)
                    //convert byte array to String
                    val response = String(responseBody)
                    results.text = response
                }
                override fun onFailure(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray?, error: Throwable?) {
                    Toast.makeText(activity, "Failed, Network Error", Toast.LENGTH_SHORT).show()
                }
            }
            )//end post

        }//end listener

        return root
    }

}