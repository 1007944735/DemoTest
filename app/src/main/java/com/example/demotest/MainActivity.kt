package com.example.demotest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.demotest.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    lateinit var databind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        databind = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        val customer=Customer()
//        customer.buy(500.0)
//        System.out.println("客户需要付钱：" + customer.callLastAmount())
//        customer.buy(1200.0)
//        System.out.println("客户需要付钱：" + customer.callLastAmount())
//        customer.buy(1200.0)
//        System.out.println("客户需要付钱：" + customer.callLastAmount())
//        customer.buy(1200.0)
//        System.out.println("客户需要付钱：" + customer.callLastAmount())
        GlobalScope.launch{
            val result=async {
                delay(2000)
                10
            }

            val value=result.await()
            Log.d("TAG", "onCreate: "+value)
        }

    }
}