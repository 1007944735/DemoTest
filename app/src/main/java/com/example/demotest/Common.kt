package com.example.demotest

import kotlin.math.max

@TotalValidRegion(1000)
class Common : CalPrice {
    override fun calPrice(originalPrice: Double): Double = originalPrice
}