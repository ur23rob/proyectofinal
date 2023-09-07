package com.android.app.pfi

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        buttonCompare.setOnClickListener {
            val text1 = editText1.text.toString()
            val text2 = editText2.text.toString()
            viewModel.compareTexts(text1, text2)
        }

        viewModel.getComparisonResult().observe(this, { result ->
            textViewResult.text = if (result) "Los textos son iguales" else "Los textos NO son iguales"
        })
    }
}
