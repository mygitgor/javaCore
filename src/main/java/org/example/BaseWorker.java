package org.example;

public abstract class BaseWorker {
    private  String name;
    private  int age;
    private int balance;
    abstract void payment();
    public BaseWorker(String name, int age,int balance){
        this.age = age;
        this.name = name;
        this.balance = balance;
    }


}
