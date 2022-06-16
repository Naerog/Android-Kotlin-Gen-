package com.generation.estudosnav

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TimePicker
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.MainViewModel
import com.fragment.DatePickerFragment
import com.fragment.TimePickerListener
import com.generation.estudosnav.databinding.FragmentFormBinding
import com.generation.estudosnav.databinding.FragmentFormBinding.*
import com.generation.estudosnav.model.Categoria
import java.time.LocalDate


class FormFragment : Fragment(), TimePickerListener {
    private lateinit var binding: FragmentFormBinding
    private val mainViewModel: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflate(layoutInflater,container,false)
        mainViewModel.myCategoriaResponse.observe(viewLifecycleOwner, {
            response -> Log.d("Requisição", response.body().toString())
            spinnerCategoria(response.body())
        })
        mainViewModel.dataSelecionada.observe(viewLifecycleOwner, {
            selectDate -> binding.editData.setText(selectDate.toString())
        })

        binding.buttonSalvar.setOnClickListener{
            findNavController().navigate(R.id.action_formFragment_to_listFragment)
        }

        binding.editData.setOnClickListener {
            DatePickerFragment(this).show(parentFragmentManager,"DatePicker")
        }
        return binding.root

    }
    fun spinnerCategoria(categorias: List<Categoria>?){
        if (categorias != null){
            binding.spinnerCategoria.adapter = ArrayAdapter(
                requireContext(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                categorias
            )
        }
    }

    override fun onTimeSelected(date: LocalDate) {
        mainViewModel.dataSelecionada.value = date
    }
}
