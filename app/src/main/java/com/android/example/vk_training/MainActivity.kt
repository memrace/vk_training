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

// IJsonVKAPI
		val vkApi:IJsonVKApi = IJsonVKApi.instance
// OnClickListener
		findBT.setOnClickListener {
			var inputText = inputIdET.text.toString()

			GlobalScope.launch() {
				val responseVK = vkApi.getUserInfo(inputText).await()
				resultTV.text = responseVK.response[0].last_name
			}

		}








		}







}
