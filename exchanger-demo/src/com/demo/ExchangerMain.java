package com.demo;

import java.util.concurrent.Exchanger;

public class ExchangerMain {
    public static void main(String[] args) {

        Exchanger<String> exchanger = new Exchanger<>();
        Thread producerThread = new Thread(new Producer(exchanger));
        Thread consumerThread = new Thread(new Consumer(exchanger));
        producerThread.start();
        consumerThread.start();

    }
}
