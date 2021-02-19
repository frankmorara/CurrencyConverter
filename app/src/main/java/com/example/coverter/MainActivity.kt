package com.example.coverter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coverter.R.string
import com.example.coverter.databinding.ActivityMainBinding
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.convertButton.setOnClickListener { convertCash() }
    }

    @SuppressLint("StringFormatMatches")
    private fun convertCash() {
        val textInputEditText = binding.inputCurrency.text.toString()
        val foreignCurrency = textInputEditText.toDoubleOrNull()

        if (foreignCurrency == null){
            return
        }
        val checkedRadio = when(binding.optionCurrencies.checkedRadioButtonId){
            R.id.option_sterling_pounds -> 153.70
            R.id.option_euros -> 133.12
            R.id.option_us_dollars -> 109.66
            R.id.option_south_african_rand -> 7.50
            R.id.option_singapore_dollar -> 82.88
            else -> 0.29
        }
        val amountInKenyanShillings = foreignCurrency * checkedRadio
        val formattedCurrency = ceil(amountInKenyanShillings)
        binding.resultTextView.text = getString(R.string.kenyan_currency,formattedCurrency)



    }



}
