package com.example.gastodeviagem

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCalculate.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonCalculate) {
            calculate()
        }
    }


    private fun calculate() {
        if (validationOK()) {
            val distance = edt_distancia.text.toString().toFloat()
            val preco = edt_preco.text.toString().toFloat()
            val autonomia = edt_autonomia.text.toString().toFloat()
            val gasto = (preco * distance) / autonomia
            valueTotal.text = "R$ ${"%.2f".format(gasto)}"
        }
    }

    private fun validationOK(): Boolean {
        if (edt_distancia.text.toString() == ""
            && edt_preco.text.toString() == ""
            && edt_autonomia.text.toString() == ""
            || edt_autonomia.text.toString() == "0"
        )
            return false

        return true
    }
}