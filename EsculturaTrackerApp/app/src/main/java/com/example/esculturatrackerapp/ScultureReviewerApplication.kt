package com.example.esculturatrackerapp

import android.app.Application
import com.example.esculturatrackerapp.data.esculturas
import com.example.esculturatrackerapp.repository.ScultureRepository

/**
 * ScultureReviewerApplication
 * */
class ScultureReviewerApplication:Application() {
    val scultureRepository: ScultureRepository by lazy {
        ScultureRepository(esculturas)
    }
}