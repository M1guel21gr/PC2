package com.example.pc2_garciaramrez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)


        val db = FirebaseFirestore.getInstance()
        val collectionRef = db.collection("pc_02")

        val txtingreDNI: EditText = findViewById(R.id.txtIngdni)
        val txtnombre: EditText = findViewById(R.id.txtNombre)
        val txtPassword: EditText = findViewById(R.id.txtIngClave)
        val txtvalPassword: EditText = findViewById(R.id.txtverClave)
        val btnSaveRegistro: Button = findViewById(R.id.btnSaveRegistro)

        btnSaveRegistro.setOnClickListener{

            val dni = txtingreDNI.text.toString()
            val password = txtPassword.text.toString()
            val fullName = txtnombre.text.toString()
            val valpassword = txtvalPassword.text.toString()

            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}