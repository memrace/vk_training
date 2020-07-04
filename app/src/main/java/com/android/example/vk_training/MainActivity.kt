package com.android.example.vk_training

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.android.example.vk_training.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText



class MainActivity : AppCompatActivity() {

	private lateinit var dB:ActivityMainBinding
	private lateinit var inputIdET:TextInputEditText
	private lateinit var findBT:Button
	private lateinit var resultTV:TextView


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		dB = DataBindingUtil.setContentView(this,R.layout.activity_main)
// View
		inputIdET = dB.inputIdET
		findBT = dB.findBT
		resultTV = dB.resultTV

// OnClickListener
	}
}