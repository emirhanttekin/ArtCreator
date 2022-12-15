package com.emirhantekin.aicreatordemo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.emirhantekin.aicreatordemo.R
import com.emirhantekin.aicreatordemo.databinding.FragmentInappBinding


class InappFragment : Fragment() {
    private lateinit var binding: FragmentInappBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInappBinding.inflate(layoutInflater)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.firstButton.setOnClickListener {
            if (binding.secondButton.isSelected) {
                binding.secondButton.isSelected = false
                binding.firstButton.isSelected = true
            }
        }
        binding.secondButton.setOnClickListener {
            binding.secondButton.isSelected = true
            binding.firstButton.isSelected = false
        }

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_inappFragment_to_homeFragment)

        }
    }
}

