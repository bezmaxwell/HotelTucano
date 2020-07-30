package com.example.hoteltucano.view.uiMain.ui.hotel

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.hoteltucano.viewmodel.controller.controllerMain.adapter.SpinnerHoteisAdapter
import com.example.hoteltucano.databinding.FragmentHotelBinding
import kotlinx.android.synthetic.main.fragment_hotel.*
import java.util.*

 class HotelFragment: Fragment() {

    private lateinit var adapterHotelClasseTest: SpinnerHoteisAdapter
    private lateinit var mBinding:FragmentHotelBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        adapterHotelClasseTest =
            SpinnerHoteisAdapter()
        adapterHotelClasseTest.adapterTest(layoutInflater)

        mBinding =  FragmentHotelBinding.inflate(layoutInflater, container, false)


        Calendar1()

        mBinding.root.setPadding(10,10,10,100)

        return mBinding.root
    }

    private fun Calendar1() {

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        mBinding.textCheckInHotel.setOnClickListener {

            val dpdCheckIn = DatePickerDialog(requireContext(),DatePickerDialog.OnDateSetListener {
                    view, year, month, dayOfMonth -> text_check_in_hotel.text = ("checkIn:${day},Mês ${month}.")
            },year,month,day)
            dpdCheckIn.show()
        }

        mBinding.textCheckOutHotel.setOnClickListener {

            val dpdCheckOut = DatePickerDialog(requireContext(),DatePickerDialog.OnDateSetListener {
                    view, year, month, dayOfMonth -> mBinding.textCheckOutHotel.setText("Dia:${day},Mês:${month}")

            },year,month,day)

            dpdCheckOut.show()
            }

            mBinding.buttonSearchHotel.setOnClickListener {
           Toast.makeText(context,"Serviço indisponível!!Tente novamente mais tarde.",Toast.LENGTH_SHORT).show()
        }

    }
}
