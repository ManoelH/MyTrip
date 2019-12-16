package com.manoelh.mytrip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity()/*, View.OnClickListener*/ {
/*    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //buttonCalculate.setOnClickListener(this)
    }

    fun onClickButtonCalculate(view: View){
        if (isEmptyValues()) {
            try {
                calculateValue()
            }catch (nfe: NumberFormatException){
                Toast.makeText(applicationContext, getString(R.string.MESSAGE_ENTER_VALID_VALUES), Toast.LENGTH_LONG).show()
            }
        }
        else
            Toast.makeText(applicationContext, getString(R.string.MESSAGE_EMPTY_VALUES), Toast.LENGTH_LONG).show()
    }

    private fun calculateValue(){

        val distance = editDistance.text.toString().toDouble()
        val price = editPrice.text.toString().toDouble()
        val  autonomy = editAutonomy.text.toString().toDouble()
        val total = (distance * price) / autonomy
        textTotalValue.text = "R$ $total"
    }

    private fun isEmptyValues(): Boolean{
            return editDistance.text.toString() != ""
                    && editDistance.text.toString() != "0"
                    && editPrice.text.toString() != ""
                    && editPrice.text.toString() != "0"
                    && editAutonomy.text.toString() != ""
                    && editAutonomy.text.toString() != "0"
    }
}
