package com.example.esculturatrackerapp.ui.sculture.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.esculturatrackerapp.ScultureReviewerApplication
import com.example.esculturatrackerapp.data.viewModel.ScultureModel
import com.example.esculturatrackerapp.repository.ScultureRepository

/**
 * View model for Sculture
 * */
class ScultureViewModel(private val repository: ScultureRepository):ViewModel() {
    var name = MutableLiveData("")
    var material = MutableLiveData("")
    var status = MutableLiveData("")

    /**
     * Get Sculture function
     * Add Sculture function -> addSculture(ScultureModel)
     * */
    fun getScultures() = repository.getSculture()
    fun addScultures(sculture: ScultureModel) = repository.addSculture(sculture)

    /**
     * Validate data function
     * */
    private fun validateData(): Boolean{
        when{
            name.value.isNullOrEmpty() -> return false
            material.value.isNullOrEmpty() -> return false
        }
        return true
    }

    /**
     * Create Sculture function
     * */
    fun createSculture(){
        if (!validateData()){
            status.value = WRONG_DATA
            return
        }

        val newSculture = ScultureModel(
            name.value.toString(),
            material.value.toString(),
        )

        addScultures(newSculture)
        status.value = SCULTURE_CREATED
    }

    /**
     * Clear status function
     * */
    fun clearStatus(){
        status.value = INACTIVE
    }

    /**
     * Clear data function
     * */
    fun clearData(){
        name.value = ""
        material.value = ""
    }

    /**
     * Set selected sculture function
     * */
    fun setSelectedSculture(sculture: ScultureModel){
        name.value = sculture.Nombre
        material.value = sculture.Material
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as ScultureReviewerApplication
                ScultureViewModel(app.scultureRepository)
            }
        }

        const val SCULTURE_CREATED = "Sculture created"
        const val WRONG_DATA = "Wrong data"
        const val INACTIVE = ""
    }
}