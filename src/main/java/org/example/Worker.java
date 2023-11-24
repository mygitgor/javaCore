package org.example;

public class Worker extends BaseWorker{
    public Worker(String name, int age, int balance) {
        super(name, age, balance);
    }

    @Override
    void payment() {
        System.out.println("im worker");
    }
}
