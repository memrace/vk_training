package com.android.example.vk_training



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.android.example.vk_training.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.android.example.vk_training.NetWorking.NetWork
import java.io.IOException
import java.net.URL


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
		findBT.setOnClickListener {
			val generatedURL: URL = NetWork().generateURL(inputIdET.text.toString())
			var response: String? = null
			try {
				response = NetWork().getResponseFromURL(generatedURL)
			} catch (e:IOException) {
				e.printStackTrace()
			}

			resultTV.text = response
		}


	}
}