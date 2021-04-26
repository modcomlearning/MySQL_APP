package com.modcom.tabbed_app_dbase.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
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

        










        return root
    }

}//end fragment