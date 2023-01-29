package com.example.task08grupalloginregistro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.task08grupalloginregistro.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    var users = HashMap<String, String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        botonLogin()
        botonRegistro()

    }

    fun botonLogin(){
        binding.login.setImageResource(R.drawable.login)
        binding.login.setOnClickListener {
            obtenerUser()
            if (users.isNotEmpty()){
                checkUser()
            }else{
                alertaUsuario()
            }
        }
    }

    fun botonRegistro(){
        binding.buttonRegistro.setImageResource(R.drawable.registro)
        binding.buttonRegistro.setOnClickListener {
            val intent= Intent(this, Registro::class.java)
            startActivity(intent)
        }
    }

    fun checkUser(){
        if (users.containsKey(binding.editTextNombre.text.toString())){
            if (users.get(binding.editTextNombre.text.toString()).equals(binding.editTextTextPassword.text.toString())){
                val intent= Intent(this, Home::class.java)
                intent.putExtra("USUARIO", binding.editTextNombre.text.toString())
                startActivity(intent)
            }else
                alertaPass()
        }else
            alertaUsuario()
    }

    fun alertaUsuario(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("El usuario introducido no existe.")
        builder.setPositiveButton("Aceptar") { dialog, which ->
            Toast.makeText(applicationContext,
                "Aceptar", Toast.LENGTH_SHORT).show()
        }
        builder.show()
    }

    fun obtenerUser(){
        val user= intent.getStringExtra("USER")
        val pass= intent.getStringExtra("PASS")

        if (user!=null && pass!=null)
            users.put(user, pass)

    }

    fun alertaPass(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("La contraseña no es correcta.")
        builder.setPositiveButton("Aceptar") { dialog, which ->
            Toast.makeText(applicationContext,
                "Aceptar", Toast.LENGTH_SHORT).show()
        }
        builder.show()
    }
}