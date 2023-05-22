package com.example.esculturatrackerapp.ui.sculture.home.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.esculturatrackerapp.data.viewModel.ScultureModel
import com.example.esculturatrackerapp.databinding.EsculturaItemBinding

/**
 * Recycler view adapter
 * */

class ScultureRecyclerViewAdapter (private val clickListener: (ScultureModel) -> Unit)
    : RecyclerView.Adapter<ScultureRecyclerViewHolder>() {
    private val scultures = ArrayList<ScultureModel>()

    fun setData(scultureList: List<ScultureModel>){
        scultures.clear()
        scultures.addAll(scultureList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScultureRecyclerViewHolder {
        val binding = EsculturaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ScultureRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return scultures.size
    }

    override fun onBindViewHolder(holder: ScultureRecyclerViewHolder, position: Int) {
        val sculture = scultures[position]
        holder.bind(sculture, clickListener)
    }
}