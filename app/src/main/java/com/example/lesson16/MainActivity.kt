package com.example.lesson16

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.lesson16.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        val message = intent.getStringExtra("key")
        bindingClass.tvMessageMain.text = message
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 100 && resultCode == RESULT_OK && data != null){

            bindingClass.tvMessageMain.text  = data.getStringExtra("key")

        }
    }

    fun onClickTest(view: View){

        val i = Intent(this, TestActivity::class.java)
        i.putExtra("key", "Как тебя зовут?")
        startActivityForResult(i, 100)

    }
}