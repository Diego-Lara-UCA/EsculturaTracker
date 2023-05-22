package com.example.esculturatrackerapp.ui.sculture.home.recyclerView

import androidx.recyclerview.widget.RecyclerView
import com.example.esculturatrackerapp.data.viewModel.ScultureModel
import com.example.esculturatrackerapp.databinding.EsculturaItemBinding

class ScultureRecyclerViewHolder (private val binding: EsculturaItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(sculture: ScultureModel, clickListener: (ScultureModel) -> Unit) {
        binding.nombreTextviewCard.text = sculture.Nombre
        binding.materialTextviewCard.text = sculture.Material

        binding.scultureCard.setOnClickListener {
            clickListener(sculture)
        }
    }
}