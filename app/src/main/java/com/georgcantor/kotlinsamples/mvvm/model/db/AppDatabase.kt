package com.georgcantor.kotlinsamples.mvvm.model.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.georgcantor.kotlinsamples.mvvm.model.Post
import com.georgcantor.kotlinsamples.mvvm.model.PostDao

@Database(entities = [(Post::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}