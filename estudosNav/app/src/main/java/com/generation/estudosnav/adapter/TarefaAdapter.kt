package com.generation.estudosnav.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.MainViewModel
import com.generation.estudosnav.databinding.CardLayoutBinding
import com.generation.estudosnav.model.Tarefa

class TarefaAdapter(
    private val taskItemClickListener: TaskItemClickListener,
    private val mainViewModel: MainViewModel
    ) : RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {
    //clica botao direito no nome e importa os componentes

    class TarefaViewHolder (val binding: CardLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    private var listTarefas = emptyList<Tarefa>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        return TarefaViewHolder(CardLayoutBinding.inflate(LayoutInflater.from(parent.context),
        parent, false))
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        val tarefa = listTarefas[position]

        holder.binding.textNome.text = tarefa.nome
        holder.binding.textDescricao.text = tarefa.descricao
        holder.binding.textResponsavel.text = tarefa.responsavel
        holder.binding.textData.text = tarefa.data
        holder.binding.switchAtivo.isChecked = tarefa.status
        holder.binding.textCategoria.text = tarefa.categoria.descricao

        holder.itemView.setOnClickListener{
            taskItemClickListener.onTaskClicked(tarefa)
        }
        holder.binding.switchAtivo.setOnCheckedChangeListener{
            compoundButton, ativo -> tarefa.status = ativo
            mainViewModel.updateTarefa(tarefa)
        }
        holder.binding.buttonDeletar.setOnClickListener {
            //implementar a lógica para deletar a tarefa
            mainViewModel.deleteTarefa(tarefa.id)
        }
    }

    override fun getItemCount(): Int {
        return listTarefas.size
    }
    fun setLista(List: List<Tarefa>){
        listTarefas = List
        notifyDataSetChanged()
    }
}
