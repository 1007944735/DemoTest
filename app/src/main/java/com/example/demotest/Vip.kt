package com.example.demotest
@TotalValidRegion(1000,2000)
class Vip : CalPrice {
    override fun calPrice(originalPrice: Double): Double = originalPrice * 0.8
}