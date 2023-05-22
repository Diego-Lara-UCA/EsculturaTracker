package com.example.esculturatrackerapp.ui.sculture

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.esculturatrackerapp.R
import com.example.esculturatrackerapp.databinding.FragmentEsculturaBinding
import com.example.esculturatrackerapp.ui.sculture.viewModel.ScultureViewModel

class EsculturaFragment : Fragment() {

    /**
     * Initializing viewModel.factory
     * */

    private val viewModel: ScultureViewModel by activityViewModels{
        ScultureViewModel.Factory
    }

    /**
     * Binding for fragment_escultura
     * */

    private lateinit var binding: FragmentEsculturaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEsculturaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
    }
    private fun setViewModel(){
        binding.scultureviewmodel = viewModel
    }
}