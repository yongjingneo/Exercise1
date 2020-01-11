package com.example.exercise1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_cal.setOnClickListener {
            calculateCarLoan(it)
        }
    }

    private fun calculateCarLoan (view: View) {
        var carPrice = v_carPrice.text.toString().toDouble();
        var DPA = v_DPA.text.toString().toDouble();
        var interestRate = v_interestRate.text.toString().toDouble();
        var loanPeriod = v_loanPeriod.text.toString().toDouble();

        var carLoan = carPrice - DPA;
        text_carLoan.text = carLoan.toString();

        var interest = interestRate * loanPeriod;
        text_interest.text = interest.toString();

        var monthly:Double = (carLoan + interest) / loanPeriod / 12;
        text_monthlyRepay.text = "%.2f".format(monthly);

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
