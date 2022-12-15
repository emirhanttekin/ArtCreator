package com.emirhantekin.aicreatordemo.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.emirhantekin.aicreatordemo.R
import com.emirhantekin.aicreatordemo.databinding.FragmentHomeBinding
import com.emirhantekin.aicreatordemo.databinding.FragmentInappBinding
import com.emirhantekin.aicreatordemo.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {
    private lateinit var binding : FragmentSettingsBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSettingsBinding.inflate(inflater , container , false)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageView8.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.textView25.setOnClickListener {
            val url = "https://www.neonapps.co/"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }



    }






}