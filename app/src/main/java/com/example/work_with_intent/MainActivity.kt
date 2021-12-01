package com.example.work_with_intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.annotation.IdRes

private const val HELLO_KEY = "hello"

class MainActivity : AppCompatActivity() {

    lateinit var nextActivityButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nextActivityButton = findViewById(R.id.next_activity_button)

        //Это код для запуска второй активити с текстом
        /*nextActivityButton.setOnClickListener {
            val secondActivityIntent: Intent= Intent(this,SecondActivity::class.java)
            secondActivityIntent.putExtra(HELLO_KEY, "Привет от Тани")

            startActivity(secondActivityIntent)

        }*/

        //А это код для запуска браузера при нажатии той же кнопки
        /* nextActivityButton.setOnClickListener {

            val googleLink = Uri.parse("https://google.com") //обязательно парсить в uri, так как интент не работает со стрингом.

            val openBrowserIntent = Intent(Intent.ACTION_VIEW, googleLink)

            startActivity(openBrowserIntent)
        }*/

        //Далее код для вызова звонка при нажатии кнопки
        // В манифесте прописать разрешение на звонки <uses-permission android:name="android.permission.CALL_PHONE" />

        nextActivityButton.setOnClickListener {
            val phoneNumberUri = Uri.parse("tel: +79201234567")

            val callIntent = Intent(Intent.ACTION_CALL, phoneNumberUri)

            startActivity(callIntent)

        }
    }
}