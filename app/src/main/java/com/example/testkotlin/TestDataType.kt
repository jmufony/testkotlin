package com.example.testkotlin

fun main() {

    testEqual()
}

private fun testEqual(){
    //100和1000结果不一样 ？
    val a:Int = 100
    val aTmp:Int? = a
    val bTmp:Int? = a
    println(aTmp===bTmp)//true

//    val a: Int = 1000
//    println(a === a) // 输出“true”
//    val boxedA: Int? = a
//    val anotherBoxedA: Int? = a
//    println(boxedA === anotherBoxedA) // ！！！输出“false”！！！
}