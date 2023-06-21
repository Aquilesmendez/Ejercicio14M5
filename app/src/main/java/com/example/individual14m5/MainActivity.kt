package com.example.individual14m5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.individual14m5.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var saldo: Double = 0.0
    private lateinit var txtSaldo: TextView
    private lateinit var txtMonto: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(getLayoutInflater())
        setContentView(binding.getRoot())

        txtSaldo = binding.txtSaldo
        txtMonto = binding.txtMonto

        binding.btnVerSaldo.setOnClickListener { verSaldo() }
        binding.btnIngresarDinero.setOnClickListener { ingresarDinero() }
        binding.btnSacarDinero.setOnClickListener { sacarDinero() }
        binding.btnSalir.setOnClickListener { finish() }
    }

    private fun verSaldo() {
        txtSaldo.text = "Saldo: $saldo"
    }

    private fun ingresarDinero() {
        val monto = txtMonto.text.toString().toDoubleOrNull()
        if (monto != null) {
            saldo += monto
            txtMonto.text.clear()
            Toast.makeText(this, "Se ha ingresado el dinero correctamente", Toast.LENGTH_SHORT)
                .show()
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
                Toast.makeText(this, "Se ha retirado el dinero correctamente", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(this, "Saldo insuficiente", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Ingrese un monto válido", Toast.LENGTH_SHORT).show()
        }
    }
}
