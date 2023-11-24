package org.example;

public class Freelancer extends BaseWorker{

    public Freelancer(String name, int age, int balance) {
        super(name, age, balance);
    }

    @Override
    void payment() {
        System.out.println("im Freelancer");
    }
}
