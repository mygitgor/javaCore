package org.example.javaDevelopmentKit.homework5.semaphore;

import java.util.concurrent.Semaphore;

public class Philosophy implements Runnable{
    private int id;
    private Semaphore sem; // семафор. ограничивающий число философов
    private int number; // условный номер философа

    public Philosophy (Semaphore sem,int id){
        this.id = id;
        this.sem = sem;
    }
    private void eat() throws InterruptedException {
        System.out.println("Philosophy "+ id+", Eat...");
        Thread.sleep(500);
        number++;
    }
    private void think() throws InterruptedException {
        System.out.println("Philosophy "+ id+", Thinking...");
        Thread.sleep(500);
    }

    @Override
    public void run() {
        try{
            while (number < 3){
                sem.acquire();
                eat();

                think();
                sem.release();
            }
        }catch (InterruptedException e){
            System.out.println ("у философа " + id + " проблемы со здоровьем");
        }
    }
}
