package com.example.hoteltucano.view.error

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hoteltucano.R
import com.example.hoteltucano.view.uiMain.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_error.*

class ErrorActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)

        restart_error.setOnClickListener {
            handleFailure()
        }

    }

     fun handleFailure() {
        val intent = Intent(this,
            MainActivity::class.java)
             startActivity(intent)
                finish()
    }
}