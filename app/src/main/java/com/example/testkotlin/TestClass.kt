package com.example.testkotlin

fun main(){

//    var wheels:List<Wheel> = ArrayList<Wheel>()
//    var car = Car(wheels)
//    println("car's wheelCount is ${car.wheelCount}")
//    println("car's wheelCount is ${car.wheels.size}")
//    println("car's wheelCount is ${car.engine}")
//    println(Wheel::howManyWheels)
////    car.engine = "afafa" //设置set为private就不能再赋值了
//
//    var isOddClass = isOddClass()
//    print("isOddClass.testListIsOdd:")
//    isOddClass.testListIsOdd()

//    var order = Order("Order name")
//    var order = Order("Order name")
//    var order2 = Order("Order name","1000")

//    var person1 = Person()
//    println("person1 person count = ${person1.children.size}")
//    var person2 = Person(person1)
//    println("person2 person count = ${person2.children.size}")
//    println("person1 person count = ${person1.children.size}")

//    var person2 = Person2()
//    println("person2.name = ${person2.name}, perons2.id = ${person2.id}")
//    var person3:Person3()

//    var derived = Derived("fan","zhu")

//    var filledRectangle = FilledRectangle()
//    filledRectangle.draw()
//    println("filledRectangle.fillColor = ${filledRectangle.fillColor}")
//    filledRectangle.Filler().drawAndFill()

    var testConstructor = TestConstructor(100,200)
}

//可以在构造函数中声明成员变量，Kotlin中叫属性
class Car(var wheels:List<Wheel>){
//    val wheels:List<Wheel> = wheels
    var wheelCount = wheels.size

    var engine:String = "Engine"
        private set

    private var _id = 0//幕后字段
    var id//属性
    get() = _id
    set(value){
        _id = value
    }
}

class Wheel(){

    fun howManyWheels():String{
        return "1000"
    }
}

class isOddClass{
    fun isOdd(value:Int):Boolean{
        return value%2 != 0
    }
    fun testListIsOdd(){
        var list = listOf(1,2,3,4)
        println(list.filter(this::isOdd))
    }
}

class Order(var name:String){
    var firstProperty = "First property name :$name".also(::println)
    init{
        println("First init blck print name = $name")
        name += "Hello"
    }
    var secondProperty = "Second property name :$name".also(::println)
    init{
        println("Second init blck print name = $name")
    }
    //次构造函数执行前，会执行初始化的所有操作
    constructor(name:String,id:String):this(name){
        println("id = $id")
    }
    var thirdProperty = "Third property name :$name".also(::println)
    init{
        println("Third init blck print name = $name")
    }
}

class Person{
    var children:MutableList<Person> = mutableListOf<Person>()
    constructor(){
    }
    constructor(parent:Person)  {
        parent.children.add(this)
    }
}
//在 JVM 上，如果主构造函数的所有的参数都有默认值，编译器会生成 一个额外的无参构造函数，它将使用默认值
open class Person2(var name:String="Person2",var id:String="1000"){
}
//如果你不希望你的类有一个公有构造函数，你需要声明一个带有非默认可见性的空的主构造函数
class Person3 private constructor(){
    constructor(name:String,id:String):this(){

    }
}

//open class Base(p: Int)
//class Derived(p: Int) : Base(p)

open class Shape {
    open fun draw() { /*……*/ }
    fun fill() { /*……*/ }
}

class Circle() : Shape() {
    final override fun draw() { /*……*/ }
//    override fun fill(){} //不是open的不能覆盖，同时因为父类已定义，不能使用相同名称
}
//class Rectangle() : Circle() {
//    override fun draw() { /*……*/ } //声明为final后，不能再被覆盖
//}


open class Base(val name: String) {

    init { println("Initializing Base") }

    open val size: Int =
        name.length.also { println("Initializing size in Base: $it") }
}

//在构造派生类的新实例的过程中，第一步完成其基类的初始化（在之前只有对基类构造函数参数的求值），
// 因此发生在派生类的初始化逻辑运行之前。
class Derived(
    name: String,
    val lastName: String
) : Base(name.capitalize().also { println("Argument for Base: $it") }) {

    init { println("Initializing Derived") }

    override val size: Int =
        (super.size + lastName.length).also { println("Initializing size in Derived: $it") }
}

//超类的调用
//open class Rectangle {
//    open fun draw() { println("Drawing a rectangle") }
//    open val borderColor: String get() = "black"
//}
//class FilledRectangle : Rectangle() {
//    override fun draw() {
//        super.draw()
//        println("Filling the rectangle")
//    }
//
//    val fillColor: String get() = super.borderColor
//}
//super @的使用
//class FilledRectangle: Rectangle() {
//    override fun draw() { /* …… */ }
//    override val borderColor: String get() = "black"
//
//    inner class Filler {
//        fun fill() { /* …… */ }
//        fun drawAndFill() {
//            super@FilledRectangle.draw() // 调用 Rectangle 的 draw() 实现
//            fill()
//            println("Drawn a filled rectangle with color ${super@FilledRectangle.borderColor}") // 使用 Rectangle 所实现的 borderColor 的 get()
//        }
//    }
//}

//如果继承了类，同时实现了接口，都包含了相同的函数，则派生类必须实现这个函数
open class Rectangle {
    open fun draw() { /* …… */ }
}

interface Polygon {
    fun draw() { /* …… */ } // 接口成员默认就是“open”的
}

class Square() : Rectangle(), Polygon {
    // 编译器要求覆盖 draw()：
    override fun draw() {
        super<Rectangle>.draw() // 调用 Rectangle.draw()
        super<Polygon>.draw() // 调用 Polygon.draw()
    }
}

class TestConstructor(value:Int){
    var testValue = 0
    init {
        testValue = value
        println("init testValue = $testValue")
    }
    constructor(value1:Int,value2:Int):this(value1){
        println("constructor testValue = $testValue")
        testValue = value2
        println("constructor testValue = $testValue")
    }
}
