package com.example.demotest

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class TotalValidRegion(val max: Int = Int.MAX_VALUE, val min: Int = Int.MIN_VALUE)