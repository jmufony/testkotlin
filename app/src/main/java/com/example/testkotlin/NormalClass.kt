package com.example.testkotlin

class NormalClass(string1:String,string2:String) {

    var mString1 = string1
    var mString2 = string2

    fun printString1(){
        println("String1 is ${mString1}")
    }
    fun printString2(){
        println("String2 is ${mString2}")
    }
}