package com.fatimasousa.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btCalcular(view: View) {

        val precoAlcool = edit_preco_alcool.text.toString() // nao é possível converter direto p/ double
        val precoGasolina = edit_preco_gasolina.text.toString() //com o pluggin, não precisamos usar mais o findViewById

        val validaCampos = validarCampos( precoAlcool, precoGasolina )
        if ( validaCampos ) {
            calcularMelhorPreco(precoAlcool, precoGasolina)
        } else {
            text_resultado.text = "Preencha os preços primeiro!"
        }
    }

    fun validarCampos(precoAlcool: String, precoGasolina: String) : Boolean{

        var camposValidados = true

        if ( precoAlcool == null || precoAlcool.equals("") ) {
            camposValidados = false
        } else if( precoGasolina == null || precoGasolina.equals("") ) {
            camposValidados = false
        }
        return camposValidados

    }

    fun calcularMelhorPreco (precoAlcool: String, precoGasolina: String) {

        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        val resultadoPreco = valorAlcool / valorGasolina

        if ( resultadoPreco >= 0.7) {
            text_resultado.setText("Melhor utilizar Gasolina!")
        } else {
            text_resultado.setText("Melhor utilizar Alcool!")
        }
    }
}