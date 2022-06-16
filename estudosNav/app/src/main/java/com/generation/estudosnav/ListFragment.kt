package com.generation.estudosnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.MainViewModel
import com.generation.estudosnav.adapter.TarefaAdapter
import com.generation.estudosnav.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private val mainViewModel: MainViewModel by activityViewModels()

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mainViewModel.listTarefas()
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        val tarefaAdapter = TarefaAdapter()
        binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)
        binding.recyclerTarefa.adapter = tarefaAdapter
        binding.recyclerTarefa.setHasFixedSize(true)

        binding.floatingAdd.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_formFragment)
        }
        mainViewModel.myTarefaResponse.observe(viewLifecycleOwner, {
            response -> if(response != null){
                tarefaAdapter.setLista(response.body()!!)
            }
        })

        return binding.root
    }
}