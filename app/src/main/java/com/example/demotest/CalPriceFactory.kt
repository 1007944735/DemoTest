package com.example.demotest

import java.io.File

object CalPriceFactory {


    private val classLoader: ClassLoader = javaClass.classLoader

    private var calPriceList: MutableList<Class<out CalPrice>>? = mutableListOf()

    private const val CAL_PRICE_PACKAGE = "com.example.demotest";

    init {
        var resources = getResources()
        var calPriceClazz = classLoader.loadClass(CalPrice::class.java.name)
        resources.forEach { file ->
            val clazz =
                classLoader.loadClass("${CAL_PRICE_PACKAGE}.${file.name.replace(".class", "")}")
            if (CalPrice::class.java.isAssignableFrom(clazz) && clazz != calPriceClazz) {
                calPriceList?.add(clazz as Class<out CalPrice>)
            }
        }

    }

    private fun getResources(): Array<File> {
        return try {
            val file = File(classLoader.getResource(CAL_PRICE_PACKAGE.replace(".", "/")).toURI())
            file.listFiles { pathname -> pathname.name.endsWith(".class") }
        } catch (e: Exception) {
            throw RuntimeException("未找到策略资源")
        }
    }

    fun createCalPrice(customer: Customer): CalPrice {
        calPriceList?.iterator()?.forEach { clazz ->
            val validRegion = handleAnnotation(clazz)
            if (customer.getTotalAmount() in validRegion?.min?.toDouble()!!..validRegion.max.toDouble()) {
                try {
                    return clazz.newInstance()
                } catch (e: Exception) {
                    throw RuntimeException("策略获取失败")
                }
            }
        }
        throw RuntimeException("策略获取失败")
    }

    private fun handleAnnotation(clazz: Class<out CalPrice>): TotalValidRegion? {
        val annotations = clazz.annotations

        if (annotations == null || annotations.isEmpty()) return null

        annotations.forEach { annotation -> if (annotation is TotalValidRegion) return annotation }

        return null

    }
}