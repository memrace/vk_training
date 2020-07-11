package com.android.example.vk_training



import android.os.Bundle
import android.provider.Contacts
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.android.example.vk_training.NetWorking.IJsonVKApi
import com.android.example.vk_training.NetWorking.NetWork
import com.android.example.vk_training.NetWorking.data.DataVK
import com.android.example.vk_training.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

	private lateinit var dB:ActivityMainBinding
	private lateinit var inputIdET:TextInputEditText
	private lateinit var findBT:Button
	private lateinit var resultTV:TextView
	private val apiVKApi:IJsonVKApi = IJsonVKApi()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		dB = DataBindingUtil.setContentView(this,R.layout.activity_main)
// View
		inputIdET = dB.inputIdET
		findBT = dB.findBT
		resultTV = dB.resultTV

// OnClickListener
		findBT.setOnClickListener {
			val inputText = inputIdET.toString()
			CoroutineScope(Dispatchers.Main).launch{
				val userInfo = apiVKApi.getUserInfo(inputText).await()
				resultTV.text =  userInfo.f_Name
			}

			}








		}







}
