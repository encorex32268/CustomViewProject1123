package com.example.customviewproject1123

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var changeButton : Button
    private lateinit var progressView : ProgressView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeButton = findViewById(R.id.changeButton)
        progressView = findViewById(R.id.progressView)

        var count = 5

        changeButton.setOnClickListener {
            count+=5
            progressView.setMaxStep(count)
        }



    }
}