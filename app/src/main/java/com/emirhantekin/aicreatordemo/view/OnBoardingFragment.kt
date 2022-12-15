package com.emirhantekin.aicreatordemo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.emirhantekin.aicreatordemo.R
import com.emirhantekin.aicreatordemo.databinding.FragmentOnBoardingBinding


class OnBoardingFragment : Fragment() {

private lateinit var binding : FragmentOnBoardingBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button2.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingFragment_to_inappFragment)
        }


    }




}