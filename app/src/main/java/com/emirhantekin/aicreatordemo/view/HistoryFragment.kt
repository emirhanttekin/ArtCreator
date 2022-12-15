package com.emirhantekin.aicreatordemo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.emirhantekin.aicreatordemo.R
import com.emirhantekin.aicreatordemo.data.User
import com.emirhantekin.aicreatordemo.databinding.FragmentHistoryBinding
import com.emirhantekin.aicreatordemo.model.HistoryAdapter
import com.emirhantekin.aicreatordemo.model.UserViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.scope.LifecycleScopeDelegate
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class HistoryFragment : Fragment() {
    private lateinit var adapter : HistoryAdapter
    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!
    private val mUserViewModel : UserViewModel by sharedViewModel()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)

        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        mUserViewModel.viewModelScope.launch {
            mUserViewModel.getAllData.collect{
                println("denemebir"+it) //kontrol
                adapter.setData(it)
            }
        }

        binding.imageView19.setOnClickListener {
            findNavController().navigateUp()


        }

    }

    private fun setAdapter() {
         adapter = HistoryAdapter()
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = GridLayoutManager(requireContext(),2,GridLayoutManager.VERTICAL,false)
    }




}