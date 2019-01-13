package com.georgcantor.kotlinsamples.viewmodel.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.georgcantor.kotlinsamples.R
import com.georgcantor.kotlinsamples.viewmodel.ui.home.MenuFragment

class SampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        if (savedInstanceState == null) {
            val fragment = MenuFragment()

            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.frame_container, fragment, "MenuFragment")
                    .commit()
        }
    }
}
