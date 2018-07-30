package com.georgcantor.kotlinsamples.newsmvvm.model

import android.arch.persistence.room.Entity

@Entity
data class Article(val author: String)