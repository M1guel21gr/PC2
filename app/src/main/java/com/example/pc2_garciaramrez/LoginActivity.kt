package com.example.pc2_garciaramrez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val db = FirebaseFirestore.getInstance()

        val txtDNI = findViewById<EditText>(R.id.txtDNI   )
        val txtPassword = findViewById<EditText>(R.id.txtPassword)
        val btnLogin = findViewById<Button>(R.id.btnIngresar)
        val btnRegister = findViewById<Button>(R.id.btnCrear)

        btnRegister.setOnClickListener{
            startActivity(Intent(this,RegistroActivity::class.java))
        }

        btnLogin.setOnClickListener {
            val dni = txtDNI.text.()
            val clave = txtPassword.text.toString()

            db
                .signInWithEmailAndPassword(dni,clave)
                .addOnCompleteListener(this){task->
                    if(task.isSuccessful){
                        Snackbar
                            .make(
                                findViewById(android.R.id.content),
                                "Acceso permitido",
                                Snackbar.LENGTH_LONG
                            ).show()
                    }else{
                        //Credenciales inválidas
                        Snackbar
                            .make(
                                findViewById(android.R.id.content),
                                "EL USUARIO Y/O CLAVE NO EXISTE EN EL SISTEMA",
                                Snackbar.LENGTH_LONG
                            ).show()
                    }

                }
        }
    }

}