package com.example.esculturatrackerapp.repository

import com.example.esculturatrackerapp.data.viewModel.ScultureModel

/**
 * Repository for ScultureModel
 * */
class ScultureRepository(private val scultures: MutableList<ScultureModel>) {
    fun getSculture() = scultures
    fun addSculture(newSculture: ScultureModel) = scultures.add(newSculture)
}