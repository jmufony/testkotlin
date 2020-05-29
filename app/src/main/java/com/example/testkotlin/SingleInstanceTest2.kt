package com.example.testkotlin

class SingleInstanceTest2 private constructor(){
    companion object {
        val instance: SingleInstanceTest2 by lazy { SingleInstanceTest2() }
    }

    var str:String = ""

    fun chgStr(){
        str += "chg"
        println("str is $str")
    }

}