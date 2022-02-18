package com.demo;

import java.util.concurrent.Exchanger;

public class Consumer implements Runnable {
    private Exchanger<String> exchanger;

    public Consumer(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                String str = exchanger.exchange("");
                System.out.println("Printing data from producer = " + str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
