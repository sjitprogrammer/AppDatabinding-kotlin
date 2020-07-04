package com.example.appdatabinding

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.appdatabinding.data.MyName
import com.example.appdatabinding.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName : MyName = MyName("aonaja")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName = myName
//        done_button.setOnClickListener { v ->
//            addNickkName(v)
//        }

        binding.doneButton.setOnClickListener {
            addNickkName(it)
        }
    }

    private fun addNickkName(v: View?) {
//        binding.nicknameText.text = nickname_editText.text
        binding.apply {
            myName?.nickname = nicknameEditText.text.toString()
            invalidateAll()
            Log.e("neckname","test = "+nicknameEditText.text.toString())
            binding.doneButton.visibility = GONE
            binding.nicknameEditText.visibility = GONE
            binding.nicknameText.visibility = VISIBLE
        }


        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(v?.windowToken, 0)
    }
}