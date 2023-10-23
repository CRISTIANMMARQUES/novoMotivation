package com.example.novomotivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.novomotivation.infra.MotivationConstants
import com.example.novomotivation.R
import com.example.novomotivation.infra.SecurityPreferences
import com.example.novomotivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener(this)

        verifyUserName()//Função que não deixa abrir a tela de usuário.
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_save) {
            handleSave()
        }
    }

    private fun handleSave() {
        val name = binding.editName.text.toString()
        if (name != "") {

            SecurityPreferences(this).storeString(MotivationConstants.KEY.USER_NAME, name)

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }else{
            Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_LONG).show()
        }
    }

    private fun verifyUserName(){
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        if(name != ""){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}