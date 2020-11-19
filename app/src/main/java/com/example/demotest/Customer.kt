package com.example.demotest

class Customer {
    private var totalAmount: Double = 0.0
    private var amount: Double = 0.0
    private var calPrice: CalPrice = Common()

    fun buy(amount: Double) {
        this.amount = amount
        totalAmount += amount
        calPrice = CalPriceFactory.createCalPrice(this)
    }

    fun callLastAmount(): Double = calPrice.calPrice(amount)

    fun getTotalAmount(): Double = totalAmount

    fun getAmount(): Double = amount


}