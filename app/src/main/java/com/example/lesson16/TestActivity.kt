package com.example.lesson16

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.lesson16.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityTestBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        val message = intent.getStringExtra("key")
        bindingClass.tvMessage.text = message
    }

    fun onClickBack(view: View){

        intent.putExtra("key", bindingClass.edName.text.toString())
        setResult(RESULT_OK, intent)
        finish()

    }
}