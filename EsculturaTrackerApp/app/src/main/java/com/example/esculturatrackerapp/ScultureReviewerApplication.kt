package com.example.esculturatrackerapp

import android.app.Application
import com.example.esculturatrackerapp.data.esculturas
import com.example.esculturatrackerapp.repository.ScultureRepository

class ScultureReviewerApplication:Application() {
    val scultureRepository: ScultureRepository by lazy {
        ScultureRepository(esculturas)
    }
}