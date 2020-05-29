package com.example.testkotlin;

public class SingleInstanceTest0 {
    private static SingleInstanceTest0 mInstance = null;
    public static SingleInstanceTest0 getInstance(){
        if (mInstance == null){
            synchronized (SingleInstanceTest0.class){
                if (mInstance == null){
                    mInstance = new SingleInstanceTest0();
                }
            }
        }
        return mInstance;
    }
    public void fun(){
        System.out.println("singleinstance0 fun");
    }
}
