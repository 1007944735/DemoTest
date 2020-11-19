package com.example.demotest

@TotalValidRegion(min = 3000)
class GoldVip : CalPrice {
    override fun calPrice(originalPrice: Double): Double = originalPrice * 0.5
}