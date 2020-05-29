package com.example.testkotlin;

public class TestJavaRunnable {

    public class tRunnable implements  Runnable{

        @Override
        public void run() {

        }
    }

    public static void main(String args[]){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }).start();
//        new Thread(()-> System.out.println("Hello"));
//        SingleInstanceTest.fun2()
//        SingleInstanceTest.getInstance()
//        var singleInstaceTest2 = SingleInstanceTest2()
//        SingleInstanceTest2.instance
//        SingleInstanceTest2 singleInstanceTest2 = SingleInstanceTest2.instance;


        SingleInstanceTest2 singleInstanceTest20 = SingleInstanceTest2.Companion.getInstance();
        singleInstanceTest20.chgStr();
        SingleInstanceTest2 singleInstanceTest21 = SingleInstanceTest2.Companion.getInstance();
        singleInstanceTest21.chgStr();

//        SingleInstanceTest3.INSTANCE.method();
//        SingleInstanceTest3 singleInstanceTest3 = SingleInstanceTest3.INSTANCE;

    }
}
