package com.modcom.tabbed_app_dbase.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.modcom.tabbed_app_dbase.R

class AddFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //logic database
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

}//end fragment