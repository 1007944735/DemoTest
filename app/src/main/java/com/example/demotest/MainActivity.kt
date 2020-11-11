package com.example.demotest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demotest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var databind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        databind = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}