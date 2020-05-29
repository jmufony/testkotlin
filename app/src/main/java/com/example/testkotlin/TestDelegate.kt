package com.example.testkotlin
import java.util.*
import kotlin.properties.Delegates

fun main() {
//    testLazy()
//    testLazyPublication()
//    testLazyNone()
//    testObservable()
    testLocalPropertyDelegate({ returnFoo() })
}

fun testLazy(){
    val lazyValue: String by lazy{
        println("start" + Thread.currentThread().name)

        Thread.sleep(5000)

        println("end" + Thread.currentThread().name)

        "Hello" + Thread.currentThread().name
    }

    Thread {
        println(lazyValue)
    }.start()

    Thread {
        println(lazyValue)
    }.start()

    println(lazyValue)
}
fun testLazyPublication(){
    val lazyValue: String by lazy(LazyThreadSafetyMode.PUBLICATION){
        println("start" + Thread.currentThread().name)

        Thread.sleep(5000)

        println("end" + Thread.currentThread().name)

        "Hello" + Thread.currentThread().name
    }

    Thread {
        println(lazyValue)
    }.start()

    Thread {
        println(lazyValue)
    }.start()

    println(lazyValue)
}
fun testLazyNone(){
    val lazyValue: String by lazy(LazyThreadSafetyMode.NONE){
        println("start" + Thread.currentThread().name)

        Thread.sleep(5000)

        println("end" + Thread.currentThread().name)

        "Hello" + Thread.currentThread().name
    }

    Thread {
        println(lazyValue)
    }.start()

    Thread {
        println(lazyValue)
    }.start()

    println(lazyValue)
}

fun testObservable(){
    var user = User()
    user.name = "first"
    user.name = "second"
}

class User {
    var name: String by Delegates.observable("<no name>") {
            prop, old, new ->
        println("$old -> $new")
    }
}

class Foo {
    fun isValid(): Boolean {
//        return Random().nextBoolean()
        return true
    }

    fun doSomething() {
        println("doSomething")
    }
}

fun returnFoo():Foo{
    var foo:Foo = Foo()

    println("returnFoo execute")

    return foo
}

fun testLocalPropertyDelegate(computeFoo: () -> Foo) {
    val memoizedFoo by lazy(computeFoo) //memoizedFoo: Foo
    if (memoizedFoo.isValid()) {
        memoizedFoo.doSomething()
        memoizedFoo.doSomething()
        memoizedFoo.doSomething()
    }
}