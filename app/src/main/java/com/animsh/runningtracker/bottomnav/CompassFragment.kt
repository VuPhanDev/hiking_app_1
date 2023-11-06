package com.animsh.runningtracker.bottomnav

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.animsh.runningtracker.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_compass.*



@AndroidEntryPoint
class CompassFragment : Fragment(R.layout.fragment_compass) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_view_1.setOnClickListener {
            findNavController().navigate(R.id.hikingDetailFragment);
        }
        btn_view_2.setOnClickListener {
            findNavController().navigate(R.id.hikingDetailFragment);
        }
        btn_view_3.setOnClickListener {
            findNavController().navigate(R.id.hikingDetailFragment);
        }
    }

}