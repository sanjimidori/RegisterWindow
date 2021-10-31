package com.sanji.registerwindow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.sanji.registerwindow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }
    var login:String? = null
    var password:String? = null
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 100 && resultCode == RESULT_OK && data != null){
            login = data.getStringExtra("Login")
            password = data.getStringExtra("Password")
        }
    }

    fun onClickRegister(view: View){
        val i = Intent(this,RegisterActivity::class.java)
        startActivityForResult(i,100)
    }
    fun onClickLogin(view:View){
        val tryLogin = bindingClass.loginText.text.toString()
        val tryPass = bindingClass.passwordText.text.toString()
        if (tryLogin == login && tryPass == password){
            bindingClass.faggot.visibility = View.GONE
            val i = Intent(this,AuthorizeActivity::class.java)
            startActivity(i)
        }
        else
            bindingClass.faggot.visibility = View.VISIBLE
        bindingClass.loginText.text = null
        bindingClass.passwordText.text = null
    }
}