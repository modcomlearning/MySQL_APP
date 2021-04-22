package com.modcom.tabbed_app_dbase.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.modcom.tabbed_app_dbase.R


class ViewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //front end  - what the users see

        val url = "http://localhost/api/view.php";


        return inflater.inflate(R.layout.fragment_view, container, false)
    }

}//end fragment