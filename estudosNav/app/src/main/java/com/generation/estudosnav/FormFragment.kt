package com.generation.estudosnav

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.MainViewModel
import com.generation.estudosnav.databinding.FragmentFormBinding
import com.generation.estudosnav.databinding.FragmentFormBinding.*


class FormFragment : Fragment() {
    private lateinit var binding: FragmentFormBinding
    private val mainViewModel: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflate(layoutInflater,container,false)
        mainViewModel.myCategoriaResponse.observe(viewLifecycleOwner, {
            Log.d("Requisição", it.body().toString())
        })
        binding.buttonSalvar.setOnClickListener{
            findNavController().navigate(R.id.action_formFragment_to_listFragment)
        }
        return binding.root

    }
}