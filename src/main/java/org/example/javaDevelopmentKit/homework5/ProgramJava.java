package org.example.javaDevelopmentKit.homework5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProgramJava {
//    1.Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
//    2.Вилки лежат на столе между каждой парой ближайших философов.
//    3.Каждый философ может либо есть, либо размышлять.
//    4.Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
//    5.Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
//
//    Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Philosophy(1,new ReentrantLock(),new ReentrantLock()));
        Thread thread2 = new Thread(new Philosophy(2,new ReentrantLock(),new ReentrantLock()));
        Thread thread3 = new Thread(new Philosophy(3,new ReentrantLock(),new ReentrantLock()));
        Thread thread4 = new Thread(new Philosophy(4,new ReentrantLock(),new ReentrantLock()));
        Thread thread5 = new Thread(new Philosophy(5,new ReentrantLock(),new ReentrantLock()));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

}
