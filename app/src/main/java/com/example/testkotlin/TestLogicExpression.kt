package com.example.testkotlin

fun main() {
//    println("testReturnExpression 100 = " + testReturnExpression(100))
//    println("testIf 100 = " + testIf(100))
//    println("testWhen 15 = " + testWhen(15))
//    println("testWhen 25 = " + testWhen(25))
//    testWhen2("Hello")
//    testWhen2(1)
//    testWhen2(0L)
//    testWhen2(MyClass())
//    testWhen2("hello")

    //test for start
//    var strList = ArrayList<String>()
//    strList.add("happy")
//    strList.add("birthday")
//    strList.add("and")
//    strList.add("mother's day")
//    println("testFor = " + testFor(strList))
//    var strList2 = listOf("123","345","sdfsdf")
//    println("testFor2 = " + testFor(strList2))
    //test for end

    //test in start
//    testIn()
    //test in end
    //test for start
//    testForLabel()
    //test for end
    //test foreach start
    testForEachLabel()
    //test foreach end
}

private fun testReturnExpression(count: Int): String = if (count == 10) {
        "It is ten"
    } else if (count < 10) {
        "Smaller than ten"
    } else {
        "Bigger than ten"
    }

private fun testIf(count: Int): String {
    return if (count == 10) {
        "It is ten"
    } else if (count < 10) {
        "Smaller than ten"
    } else {
        "Bigger than ten"
    }
}

private fun testWhen(count: Int): String? {
    var str: String? = null
    var str1 = when {
        count == 10 -> "It is ten"
        count < 10 -> "Smaller than ten"
        else -> "Bigger than ten"
    }

    var str2 = when (count) {
        10 -> "It is ten"
        20 -> "It is twenty"
        else -> "Unknown"
    }

    if (count < 20) {
        str = str1
    } else {
        str = str2
    }
    return str
}

fun testWhen2(any:Any){
    when(any){
        1 -> println(any.javaClass.toString() + "value = ${any}")
        "789" -> println(any.javaClass.toString() + "value = ${any}")
        MyClass() -> println(any.javaClass.toString() + "value = ${any}")
        is Long -> println("Long value")
        else -> println(any.javaClass.toString() + "value = ${any}")
    }
}

class MyClass(){

}

fun testFor(strList:List<String>):Unit{
    for (str in strList)
        println("str = $str")

    for (i in strList.indices)
        println("strList[$i] = ${strList[i]}")
}
fun testIn(){
    println("test for in")
    for (i in 1..5)
        println("in for i = $i")

    println("test if in")
    if (6 in 1..5)
        println("6 in 1..5")
    else
        println("6 not in 1..5")

    val x = 4
    val array = arrayListOf<String>()
    array.add("aaa")
    array.add("bbb")
    array.add("ccc")

    if (x !in 0..array.size - 1)
        println("Out: array has only ${array.size} elements. x = ${x}")
}

private fun testForLabel(){
    //for no need label
    println("for loop label return")
    loop@for(i in 1..100) {
        if (i.rem(3) == 0) return@loop
        println("i=$i")
    }

    println("for loop label continue")
    for(i in 1..10) {
        if (i.rem(3) == 0) continue
        println("i=$i")
    }

    println("for loop label break")
    for(i in 1..10) {
        if (i.rem(3) == 0) break
        println("i=$i")
    }
}
private fun testForEachLabel(){
    //foreach label test
//    listOf<Int>(1,2,3,4,5).forEach{
//        if (it.rem(3) == 0)
//            return // 非局部直接返回到 foo() 的调用者
//        println("it = $it")
//    }

//    listOf(1,2,3,4,5).forEach loop@{
//        if (it.rem(3) == 0)
//            return@loop // 手动设置foreach loop标签
//        println("it = $it")
//    }
    //或者
//    listOf(1,2,3,4,5).forEach{
//        if (it.rem(3) == 0)
//            return@forEach //forEach 默认有隐式标签，该标签与接受该 lambda 的函数同名
//        println("it = $it")
//    }
    //或者用匿名函数
//    listOf(1,2,3,4,5).forEach(fun(value:Int){
//        if (value.rem(3) == 0) return
//        println("it = $value")
//    })
//
//    listOf(1, 2, 3, 4, 5).forEach(fun(value: Int) {
//        if (value.rem(3) == 0) return  // 局部返回到匿名函数的调用者，即 forEach 循环
//        println("it = $value")
//    })

    //达到break的效果
    run loop@{
        listOf(1,2,3,4,5).forEach{
            if (it.rem(3) == 0) return@loop
            print(it)
        }
    }
//    当要返一个回值的时候，解析器优先选用标签限制的 return，即
//    return@a 1
//    意为“返回 1 到 @a”，而不是“返回一个标签标注的表达式 (@a 1)
}