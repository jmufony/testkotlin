package com.example.testkotlin

fun main(){
    testDestructuringDeclarations()
    testDataClass()
    testMap()
    testCopy()
}

private fun testDestructuringDeclarations(){

    var (first,second) = Pair(1,"one")
    println("testDestructuringDeclarations first is $first,second is $second")
}

class Pair<K,V>(val first:K,val second:V){
    operator fun component1():K{
        return first
    }
    operator fun component2():V{
        return second
    }
}

private fun testDataClass(){
    val (first,second) = DCTest(0,"one")
    println("testDataClass first is $first,second is $second")
}

data class DCTest(val first:Int ,val second: String)

private fun testMap(){
//    var testMap = HashMap<Int,String>()
    var testMap = hashMapOf<Int,String>()
    testMap[1] = "one"
    testMap[2] = "two"
    for ((first,second) in testMap){
        println("test map1 key = $first value = $second")
    }

    var testMap2 = hashMapOf<String,Int>()
    testMap2["one"] = 1
    testMap2["two"] = 2
    for ((first,second) in testMap2){
        println("test map1 key = $first value = $second")
    }
}

private fun testCopy(){

    println("testCopy start***************************************")

    val firstDCTest = DCTest(1,"one")
    val secondDCTest = DCTest(1,"one")
    val thirdDCTest = DCTest(2,"two")

    println("firstDCTest == secondDCTest result is ${firstDCTest == secondDCTest}")
    println("firstDCTest == thirdDCTest result is ${firstDCTest == thirdDCTest}")

//    println("${firstDCTest.copy(_,"hundred")}")
//    println("${firstDCTest.copy(100,"hundred")}")
//    println("${firstDCTest.copy(100,_)}")
    println("${firstDCTest.copy(first=1000)}")
    println("${firstDCTest.copy(second= "thousand")}")
    println("${firstDCTest.copy(10000,"ten thousand")}")

    println("testCopy end***************************************")
}