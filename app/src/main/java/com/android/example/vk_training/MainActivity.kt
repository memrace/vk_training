package com.android.example.vk_training



import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.android.example.vk_training.NetWorking.IJsonVKApi
import com.android.example.vk_training.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.*
import retrofit2.await



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
			val apiVKApi = IJsonVKApi.begin()
			val inputText = inputIdET.toString()

			GlobalScope.launch(Dispatchers.Default){
				val userInfo = apiVKApi.getUserInfo(inputText)
				resultTV.text = userInfo.await().f_Name
			}

			}








		}







}
