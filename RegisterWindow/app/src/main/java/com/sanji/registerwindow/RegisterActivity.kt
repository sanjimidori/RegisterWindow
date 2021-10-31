package com.sanji.registerwindow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.sanji.registerwindow.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }

    fun onClickReg(view: View){
        val i = Intent(this,MainActivity::class.java)
        i.putExtra("Login",bindingClass.newLogin.text.toString())
        i.putExtra("Password",bindingClass.newPassword.text.toString())
        setResult(RESULT_OK,i)
        finish()
    }
    fun onClickQuit(view:View){
        finish()
    }
}