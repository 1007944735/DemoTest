package com.example.demotest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("TAG", "onCreate: ")
        print("23")
        print("123")
        print("测试")
        print("分支测试")
        print("测试2")
        print("测试3")
    }
}