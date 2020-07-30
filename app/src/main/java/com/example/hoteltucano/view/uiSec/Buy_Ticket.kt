package com.example.hoteltucano.view.uiSec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.hoteltucano.R
import com.example.hoteltucano.databinding.ActivityBuyTicketBinding
import kotlinx.android.synthetic.main.activity_buy__ticket.*

class Buy_Ticket : AppCompatActivity() {


    private lateinit var binding:ActivityBuyTicketBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_buy__ticket)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_buy__ticket)

        textIncluding()
        button()
    }


    private fun textIncluding() {
        val intent = intent
        val nameHotel = intent.getStringExtra(DescriptionHotel.NAME)

        binding.checkInBuyTicket.text = nameHotel
    }

    private fun button() {


        binding.btnBuyTicket.setOnClickListener {
            onBackPressed()
        }
    }
}