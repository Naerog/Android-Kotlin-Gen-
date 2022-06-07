package com.generation.estudosnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.generation.estudosnav.adapter.TarefaAdapter
import com.generation.estudosnav.databinding.FragmentListBinding
import com.generation.estudosnav.model.Tarefa

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        val adapter = TarefaAdapter()
        binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)
        binding.recyclerTarefa.adapter = adapter
        binding.recyclerTarefa.setHasFixedSize(true)

        binding.floatingAdd.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_formFragment)
        }
        val listTarefas = listOf(
            Tarefa (
                "Lavar a louça",
                "Lavar a louça o dia todo",
                "Natan",
                "2022-06-15",
                false,
                "Dia a dia"
            ),
            Tarefa (
                "Lavar a louça",
                "Lavar a louça o dia todo",
                "Eliane",
                "2022-06-1r",
                false,
                "Dia a dia"
            ),
            Tarefa (
                "Lavar a louça",
                "Lavar a louça o dia todo",
                "Igor",
                "2022-06-13",
                false,
                "Dia a dia"
            )
        )
        adapter.setLista(listTarefas)
        return binding.root
    }
}