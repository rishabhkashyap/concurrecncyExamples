package com.oddEven.locks;

import com.oddEven.locks.threads.EvenThread;
import com.oddEven.locks.threads.OddThread;

public class Main {
    public static void main(String[] args) {
        System.out.println("Using locks and condition to print even and odd numbers using different thread");
        Printer printer = new Printer();
        Thread even = new Thread(new EvenThread(10, printer), "Even thread");
        Thread odd = new Thread(new OddThread(10, printer), "Odd thread");
        odd.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        even.start();
    }
}
