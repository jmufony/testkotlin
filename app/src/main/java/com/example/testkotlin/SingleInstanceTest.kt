package com.example.testkotlin

class SingleInstanceTest {
    private var mInstance: SingleInstanceTest? = null

    fun getInstance(): SingleInstanceTest? {
        if (mInstance == null) {
            synchronized(SingleInstanceTest::class.java) {
                if (mInstance == null) {
                    mInstance = SingleInstanceTest()
                }
            }
        }
        return mInstance
    }

    fun fun2():String{
        return "test"
    }
}