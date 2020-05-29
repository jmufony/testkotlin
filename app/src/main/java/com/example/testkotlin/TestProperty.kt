package com.example.testkotlin

fun main(){



}

class testClass{
    var size:Int = 0
    var isEmpty: Boolean = false
        get() = size == 0
        set(value){
            field = value
        }
}