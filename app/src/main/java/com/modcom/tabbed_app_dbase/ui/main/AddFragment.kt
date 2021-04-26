package com.modcom.tabbed_app_dbase.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.RequestParams
import com.modcom.tabbed_app_dbase.R

class AddFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //logic database

        val root = inflater.inflate(R.layout.fragment_add, container, false)
        //we have to find by id
        val car_reg = root.findViewById<EditText>(R.id.edit_car_reg)
        val make = root.findViewById<EditText>(R.id.edit_make)
        val model = root.findViewById<EditText>(R.id.edit_model)
        val mileage = root.findViewById<EditText>(R.id.edit_mileage)
        val cost = root.findViewById<EditText>(R.id.edit_cost)
        val capacity = root.findViewById<EditText>(R.id.edit_capacity)
        val upload = root.findViewById<Button>(R.id.btn_upload)



        //prepare variables(parameters) and url to post
        val client = AsyncHttpClient(true, 80,443)
        val parameter = RequestParams()
        parameter.add("car_reg", car_reg.text.toString())
        parameter.add("make", make.text.toString())
        parameter.add("model", model.text.toString())
        parameter.add("mileage", mileage.text.toString())
        parameter.add("cost", cost.text.toString())
        parameter.add("capacity", capacity.text.toString())
        val url = "http://10.0.2.2/api/add.php";












        return root
    }

}//end fragment