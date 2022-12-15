package com.emirhantekin.aicreatordemo.view

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.emirhantekin.aicreatordemo.ApiState
import com.emirhantekin.aicreatordemo.R
import com.emirhantekin.aicreatordemo.databinding.FragmentHomeBinding




class HomeFragment : Fragment() {
    private lateinit var  binding  : FragmentHomeBinding
    var currentId: String? = null
    var tempHeadline : String = ""
    var tempCategory : String = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater , container , false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.historyimage.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_historyFragment)

        }
        binding.settingsbuton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_settingsFragment)
        }

        binding.editTextTextPersonName.addTextChangedListener {
            tempHeadline = it.toString()
        }


        binding.let {
            binding.surrealist.setOnClickListener {
                currentId?.let {
                    checkOuter(it)
                }

                binding.surrealist.isSelected = true
                currentId = "surrealist"
                if (binding.surrealist.isSelected) {
                    binding.surrealist.setTextColor(Color.WHITE)
                } else {
                    binding.surrealist.setTextColor(Color.BLACK)
                }


            }
            binding.steampunk.setOnClickListener {
                currentId?.let {
                    checkOuter(it)
                }
                binding.steampunk.isSelected = true
                currentId = "steampunk"
                if (binding.steampunk.isSelected) {
                    binding.steampunk.setTextColor(Color.WHITE)
                }



            }
            binding.rickmorty.setOnClickListener {
                currentId?.let {
                    checkOuter(it)
                }
                binding.rickmorty.isSelected = true
                currentId = "rickmorty"
                if (binding.rickmorty.isSelected) {
                    binding.rickmorty.setTextColor(Color.WHITE)
                }

            }
        }

        binding.painting.setOnClickListener {
            currentId?.let {
                checkOuter(it)
            }
            binding.painting.isSelected = true
            currentId = "painting"
            if (binding.painting.isSelected) {
                binding.painting.setTextColor(Color.WHITE)
            }

        }

        binding.PortraitPhoto.setOnClickListener {
            currentId?.let {
                checkOuter(it)
            }
            binding.PortraitPhoto.isSelected = true
            currentId = "portrait"
            if (binding.PortraitPhoto.isSelected) {
                binding.PortraitPhoto.setTextColor(Color.WHITE)
            }

        }





        binding.button5.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_imageFragment)
            when (currentId) {
                "surrealist" -> {
                    tempCategory = "Surrealist"
                }
                "steampunk" -> {
                    tempCategory = "Steampunk"
                }
                "rickmorty" -> {
                    tempCategory = "Rick and Morty"
                }
                "painting" -> {
                    tempCategory = "Renaissance Painting"
                }
                "portrait" -> {
                    tempCategory = "Portrait Photo"
                }
            }
            ApiState.tempCategory = tempCategory
            ApiState.tempHead = tempHeadline
            binding.editTextTextPersonName.text


        }



            ApiState.tempCategory = tempCategory
            ApiState.tempHead = tempHeadline
            binding.editTextTextPersonName.text



        }

    fun checkOuter(string: String){
        when(string){
            "surrealist" ->{
                binding.surrealist.isSelected = false
                binding.surrealist.setTextColor(Color.BLACK)

            }
            "steampunk" ->{
                binding.steampunk.isSelected = false
                binding.steampunk.setTextColor(Color.BLACK)
            }
            "rickmorty" ->{
                binding.rickmorty.isSelected = false
                binding.rickmorty.setTextColor(Color.BLACK)
            }
            "painting"-> {
                binding.painting.isSelected = false
                binding.painting.setTextColor(Color.BLACK)
            }
            "portrait" -> {
                binding.PortraitPhoto.isSelected = false
                binding.PortraitPhoto.setTextColor(Color.BLACK)
            }



        }
    }

        }
















