package com.oddEven.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Printer {

    private final Lock lock = new ReentrantLock();

    private final Condition evenPrinted = lock.newCondition();

    private final Condition oddPrinted = lock.newCondition();

    private volatile boolean evenFlag = true;


    public void printEven(int num) {

        try {
            lock.lock();
            if (evenFlag) {
                oddPrinted.await();
            } else {
                System.out.println(Thread.currentThread().getName() + ": " + num);
                evenFlag = true;
                evenPrinted.signalAll();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            lock.unlock();
        }
    }

    public void printOdd(int num) {
        try {
            lock.lock();
            if (!evenFlag) {
                evenPrinted.await();

            } else {
                System.out.println(Thread.currentThread().getName() + ": " + num);
                evenFlag = false;
                oddPrinted.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            lock.unlock();
        }
    }
}
