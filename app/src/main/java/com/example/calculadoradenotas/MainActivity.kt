package com.example.calculadoradenotas

import android.content.Context
import android.graphics.Color
import android.inputmethodservice.InputMethodService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCalcular = calcular

        val switch = switch1

        fun closeKeyboard() {
            val view = currentFocus
            view?.let {
                val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imn.hideSoftInputFromWindow(it.windowToken, 0)
            }
        }

        btCalcular.setOnClickListener {
            var nota1 = Integer.parseInt(nota1.text.toString())
            val nota2 = Integer.parseInt(nota2.text.toString())
            val media = (nota1 + nota2) / 2
            val faltas = Integer.parseInt(faltas.text.toString())

            if (media >=6 && faltas <=10) {
                resultado.setText("Aluno aprovado!" + "\n" + "Nota final: " + media + "\n" + "Faltas: " + faltas)
                resultado.setTextColor(Color.GREEN)
                closeKeyboard()

            }else {
                resultado.setText("Aluno reprovado!" + "\n" + "Nota final: " + media + "\n" + "Faltas: " + faltas)
                resultado.setTextColor(Color.RED)
                closeKeyboard()
            }
        }

        var x = 0

        switch.setOnClickListener{
            if (switch.isChecked){
                nota.setBackgroundColor(Color.DKGRAY)
                switch1.setTextColor(Color.WHITE)
            } else{
                nota.setBackgroundColor(Color.WHITE)
                switch1.setTextColor(Color.BLACK)
            }
        }
    }
}