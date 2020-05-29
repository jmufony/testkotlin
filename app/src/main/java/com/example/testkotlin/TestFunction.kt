package com.example.testkotlin

fun main() {
    println("testAnonymousFun \"1000\" : ${testAnonymousFun("1000")}")
    println("testHighLevelFun \"abcEd\" : ${testHigherOrderFun("abcEd",{ input -> input.toUpperCase()})}")
    //匿名函数是在某个函数上定义的最后一个参数，则您可以在用于调用该函数的圆括号之外传递它
    println("testHighLevelFun \"abcEd\" : ${testHigherOrderFun("abcEd"){ input -> input.toUpperCase()}}")

    val items = listOf(1, 2, 3, 4, 5)

// Lambdas are code blocks enclosed in curly braces.
    val tmpInt = items.fold(0, {
        // When a lambda has parameters, they go first, followed by '->'
            acc: Int, i: Int ->
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        // The last expression in a lambda is considered the return value:
        result
    })

    println("tmpInt = $tmpInt")

// Parameter types in a lambda are optional if they can be inferred:
    val joinedToString = items.fold("Elements:", { acc, i -> acc + " " + i })
    println("joinedToString = $joinedToString")
// Function references can also be used for higher-order function calls:
    val product = items.fold(1, Int::times) // times方法是全部相乘的操作
    println("product = $product")


}

var testAnonymousFun:(String) -> Int = {input -> input.length}

fun testHigherOrderFun(str:String, toUpperFun:(String) -> String):String{
    return toUpperFun(str)
}

fun <T, R> Collection<T>.fold(
    initial: R,
    combine: (acc: R, nextElement: T) -> R
): R {
    //这个函数就是给个初始值R，然后循环输入调用的对象的所有内容执行这个combine方法
    var accumulator: R = initial
    for (element: T in this) {
        accumulator = combine(accumulator, element)
    }
    return accumulator
}