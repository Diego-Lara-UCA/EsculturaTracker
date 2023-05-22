package com.example.esculturatrackerapp.ui.sculture.createSculture

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.esculturatrackerapp.R
import com.example.esculturatrackerapp.databinding.FragmentCreateEsculturaBinding
import com.example.esculturatrackerapp.databinding.FragmentEsculturaBinding
import com.example.esculturatrackerapp.ui.sculture.viewModel.ScultureViewModel

class CreateEsculturaFragment : Fragment() {

    /**
     * Initializing viewModel.Factory
     * */

    private val viewModel: ScultureViewModel by activityViewModels{
        ScultureViewModel.Factory
    }

    /**
     * Binding for fragment_create_escultura
     * */

    private lateinit var binding: FragmentCreateEsculturaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateEsculturaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()
    }

    private fun setViewModel(){
        binding.scultureviewmodel = viewModel
    }

    private fun observeStatus(){
        viewModel.status.observe(viewLifecycleOwner) { status ->
            when{
                status.equals(ScultureViewModel.SCULTURE_CREATED) -> {
                    Log.d("APP_TAG", status)
                    Log.d("APP_TAG", viewModel.getScultures().toString())
                    viewModel.clearData()
                    viewModel.clearStatus()
                    findNavController().popBackStack()
                }
                status.equals(ScultureViewModel.WRONG_DATA) -> {
                    Log.d("APP_TAG", status)
                    viewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }
}