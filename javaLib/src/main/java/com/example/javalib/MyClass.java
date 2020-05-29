package com.example.javalib;

public class MyClass {

    public int testPlus(int a,int b){
        return a+b;
    }

    public static void main(String args[]){
        new Thread(()-> System.out.println("Hello")).start();
        System.out.println("Hello2");
        System.out.println("Hello2");
    }
}
