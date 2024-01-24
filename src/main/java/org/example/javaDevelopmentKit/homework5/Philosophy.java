package org.example.javaDevelopmentKit.homework5;

import java.util.concurrent.locks.Lock;

public class Philosophy implements Runnable{
    private final int id;
    private  final Lock leftFork;
    private final Lock rightFork;
    private int number;

    public Philosophy(int id,Lock leftFork, Lock rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.id = id;
    }

    private void eat() throws InterruptedException {
        System.out.println("Philosophy "+ id+", Eat...");
        number++;
        Thread.sleep(300);
    }
    private void think() throws InterruptedException {
        System.out.println("Philosophy "+ id+", Thinking...");
        Thread.sleep(300);
    }

    @Override
    public void run() {
        try {
            while (number < 3) {
                think();
                leftFork.lock();
                System.out.print(id+" Lock left, ");
                try{
                    rightFork.lock();
                    System.out.print(id+" Lock right, ");
                    try{
                        eat();
                    }finally {
                        rightFork.unlock();
                        System.out.print(id+" Unlock right, ");
                    }
                }finally {
                    leftFork.unlock();
                    System.out.print(id+" Unlock left, ");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
