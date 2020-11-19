package com.example.demotest
@TotalValidRegion(2000,3000)
class SuperVip : CalPrice {
    override fun calPrice(originalPrice: Double): Double = originalPrice * 0.7
}