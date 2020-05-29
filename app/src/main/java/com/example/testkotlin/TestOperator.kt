package com.example.testkotlin

import androidx.core.util.rangeTo

fun main(){
    overrideOperator(100)
}

fun overrideOperator(value:Int){
    var tmpValue = value
    //运算符的重载
    println("value inc = ${value.inc()}")//自增
    println("value dec = ${value.dec()}")//自减
    println("value plus 10 = ${value.plus(10)}")//加法或者字符串连接
    println("value minus 10 = ${value.minus(10)}")//减法
    println("value times 10 = ${value.times(10)}")//相乘
    println("value divide 10 = ${value.div(10)}")//相除
    println("value rem 3 = ${value.rem(3)}")//取余数
    var valueList = ArrayList<Int>()
    valueList.plusAssign(value)
    println("valueList.plusAssign(value) = ${valueList}")//添加元素
    valueList.minusAssign(value)
    println("valueList.minusAssign(value) = ${valueList}")//减少元素
    //timesAssign ,divAssign ,remAssign how to use
    tmpValue %= 3
    var booleanValue = false
    println("booleanValue false not = ${booleanValue.not()}")
    println("tmpValue = $tmpValue")
    println("value.compareTo(tmpValue) = ${value.compareTo(tmpValue)}")
    println("value.compareTo(101) = ${value.compareTo(101)}")
    var tmpClass = TmpClass()
    //invoke how to use?

    //rangeTo how to use?
//    for (num in 1 rangeTo 7){
//
//    }

    for (num in 1 until 7 step 1){
        println("until step num = $num")
    }
    for (num in 7 downTo 1 step 2){
        println("dowto step num = $num")
    }
}

class TmpClass{
    fun classMethod(intValue:Int,strValue:String){
        println("intValue:=$intValue,strValue = $strValue")
    }
}