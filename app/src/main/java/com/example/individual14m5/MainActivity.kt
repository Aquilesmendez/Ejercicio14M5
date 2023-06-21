package com.example.individual14m5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var saldo: Double = 0.0
    private lateinit var txtSaldo: TextView
    private lateinit var txtMonto: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtSaldo = findViewById(R.id.txtSaldo)
        txtMonto = findViewById(R.id.txtMonto)

        val btnVerSaldo: Button = findViewById(R.id.btnVerSaldo)
        btnVerSaldo.setOnClickListener { verSaldo() }

        val btnIngresarDinero: Button = findViewById(R.id.btnIngresarDinero)
        btnIngresarDinero.setOnClickListener { ingresarDinero() }

        val btnSacarDinero: Button = findViewById(R.id.btnSacarDinero)
        btnSacarDinero.setOnClickListener { sacarDinero() }

        val btnSalir: Button = findViewById(R.id.btnSalir)
        btnSalir.setOnClickListener { finish() }
    }

    private fun verSaldo() {
        txtSaldo.text = "Saldo: $saldo"
    }

    private fun ingresarDinero() {
        val monto = txtMonto.text.toString().toDoubleOrNull()
        if (monto != null) {
            saldo += monto
            txtMonto.text.clear()
            Toast.makeText(this, "Se ha ingresado el dinero correctamente", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Ingrese un monto válido", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sacarDinero() {
        val monto = txtMonto.text.toString().toDoubleOrNull()
        if (monto != null) {
            if (monto <= saldo) {
                saldo -= monto
                txtMonto.text.clear()
                Toast.makeText(this, "Se ha retirado el dinero correctamente", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Saldo insuficiente", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Ingrese un monto válido", Toast.LENGTH_SHORT).show()
        }
    }
}
