package com.example.esculturatrackerapp.ui.sculture.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.esculturatrackerapp.R
import com.example.esculturatrackerapp.data.viewModel.ScultureModel
import com.example.esculturatrackerapp.databinding.FragmentEsculturaBinding
import com.example.esculturatrackerapp.databinding.FragmentHomeBinding
import com.example.esculturatrackerapp.ui.sculture.home.recyclerView.ScultureRecyclerViewAdapter
import com.example.esculturatrackerapp.ui.sculture.viewModel.ScultureViewModel

class HomeFragment : Fragment() {

    /**
     * Initializing viewModel.factory
     * */
    private val viewModel: ScultureViewModel by activityViewModels{
        ScultureViewModel.Factory
    }

    /**
     * Binding for fragment_home
     * */
    private lateinit var binding: FragmentHomeBinding

    /**
     * RecyclerViewAdapter initilized
     * */
    private lateinit var adapter: ScultureRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)

        binding.actionAddSculture.setOnClickListener{
            viewModel.clearData()
            it.findNavController().navigate(R.id.action_homeFragment_to_createEsculturaFragment)
        }
    }

    private fun setRecyclerView(view:View){
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = ScultureRecyclerViewAdapter { selectedSculture ->
            showSelectedItem(selectedSculture)
        }

        binding.recyclerView.adapter = adapter
        displaySculture()
    }

    private fun showSelectedItem(movie: ScultureModel){
        viewModel.setSelectedSculture(movie)
        findNavController().navigate(R.id.action_homeFragment_to_esculturaFragment)
    }

    private fun displaySculture(){
        adapter.setData(viewModel.getScultures())
        adapter.notifyDataSetChanged()
    }
}