package com.example.testkotlin

fun fun1():Unit{
    var str = "hello";
    println("$str");
}

fun sum(a:Int,b:Int):Int = a + b

fun main(){
//    var returnValue:Unit = fun1()
//    println("fun1 return value is 11111${returnValue}")

//    var sumResult = sum(1,2)
//    println("sum is $sumResult")
//    println("sum2 is ${sum(2,3)}")

//    var student1 = Student(1)
//    var student2 = Student(2,"student2")
//    var student3 = Student(3,"student3","male")
//    println("student1.id = ${student1.id},student1.name=${student1.name},student1.gender=${student1.gender}")
//    println("student2.id = ${student2.id},student2.name=${student2.name},student2.gender=${student2.gender}")
//    println("student3.id = ${student3.id},student3.name=${student3.name},student3.gender=${student3.gender}")
//    println("student2 name = "+ student2::name)

    var s2 = SingleInstanceTest2.instance
    s2.chgStr()
    var s3 = SingleInstanceTest2.instance
    s3.chgStr()

//    var normalClass = NormalClass("1111","22222")
//    normalClass.printString1()
//    normalClass.printString2()

//    var singleInstanceTest0 = SingleInstanceTest0.getInstance()
//    singleInstanceTest0.`fun`()
}

class Student(id:Int){
    private var _id = id//幕后字段
    var id//属性
    get() = _id
        set(value){
            _id = value
        }
    private var _name = ""
    private var _gender = ""

    var name
    get()=_name
    set(value) {
        _name = value
    }

    var gender
    get() = _gender
    set(value){
        _gender = value
    }


    constructor(id:Int,name:String):this(id){
        this._id = id
        this._name = name
    }

    constructor(id:Int,name:String,gender:String):this(id){
        this._id = id
        this._name = name
        this._gender = gender
    }

}