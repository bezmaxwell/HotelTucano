package com.example.hoteltucano.view.uiMain.ui.person

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.hoteltucano.R
import com.example.hoteltucano.databinding.FragmentPersonBinding


private lateinit var binding: FragmentPersonBinding

class PersonFragment : Fragment() {

    //uso de dataBinding para otimização de codigo e limpeza

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {

        binding = FragmentPersonBinding.inflate(layoutInflater, container, false)

        binding.root.setPadding(10, 0, 10, 0)

        bindingDataBtn()

        return binding.root
    }

    private fun verifyEmailandPassword()
    {
        val email = binding.emailRegisterPerson.text.toString()
        val pwd = binding.passwordRegisterPerson.text.toString()

        if(email.isEmpty() || email.length < 10) {
                binding.emailRegisterPerson.isFocusable = true
                binding.emailRegisterPerson.error = "Preencha todos os campos corretamente"

        }else if(pwd.isEmpty() || pwd.length < 5) {
                binding.passwordRegisterPerson.isFocusable = true
                binding.passwordRegisterPerson.error = "Senha deve conter 5 values!!!"

        }else {
            Toast.makeText(context,"Email: "+email + "\n Criado com sucesso !!!",Toast.LENGTH_LONG).show()
        }

    }


    private fun bindingDataBtn() {

        binding.buttonFacebookPerson.setOnClickListener {

        }
        binding.buttonGooglePerson.setOnClickListener {

        }

        binding.loginAccountPerson.setOnClickListener {
            Toast.makeText(context,"Logando na conta...",Toast.LENGTH_LONG).show()
        }

        binding.createAccountPerson.setOnClickListener {
                verifyEmailandPassword()
        }


    }
}