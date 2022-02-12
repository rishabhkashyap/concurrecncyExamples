package com.demo.liveLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//At some point in exexution thread 1 and thread2 will be able to acquire both lock1 and lock2
//and complete their execution but behaviour will be unpredictable.It doesn't matter
//fairness is enabled it will not change the behaviour of both thread
public class LivelockDemo {
    public static void main(String[] args) {
        Worker worker = new Worker();
        new Thread(worker::operation1, "Thread1").start();
        new Thread(worker::operation2, "Thread2").start();

    }

}

class Worker {
    private final Lock lock1 = new ReentrantLock(true);
    private final Lock lock2 = new ReentrantLock(true);

    public void operation1() {
        while (true) {
            try {
                lock1.tryLock(50, TimeUnit.MILLISECONDS);
                System.out.println("Thread1 acquired lock1");
                System.out.println("Thread1 trying to acquire lock2");
                Thread.sleep(50);
                if (lock2.tryLock()) {
                    System.out.println("Thread1 acquired lock2");
                } else {
                    System.out.println("Thread1 failed to acquire lock2");
                    lock1.unlock();
                    continue;
                }
                break;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock1.unlock();
        lock2.unlock();
    }

    public void operation2() {
        while (true) {
            try {
                lock2.tryLock(50, TimeUnit.MILLISECONDS);
                System.out.println("Thread2 acquired lock2");
                System.out.println("Thread2 trying to acquire lock1");
                Thread.sleep(50);
                if (lock1.tryLock()) {
                    System.out.println("Thread2 acquired lock1");

                } else {
                    System.out.println("Thread2 failed to acquire lock1");
                    lock2.unlock();
                    continue;
                }
                break;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock1.unlock();
        lock2.unlock();
    }
}
