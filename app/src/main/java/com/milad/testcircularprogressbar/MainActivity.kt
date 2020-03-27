package com.milad.testcircularprogressbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.milad.customprogressbar.SolidCircularProgressbar

class MainActivity : AppCompatActivity() {

    lateinit var mProgressbar: SolidCircularProgressbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mProgressbar = findViewById(R.id.progressbar_main_solid)
    }
}
