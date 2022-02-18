package com.demo;

import java.util.concurrent.Exchanger;

public class Producer implements Runnable {
    private Exchanger<String> exchanger;

    public Producer(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            String str = "Producer" + i;
            System.out.println("Producing data = " + str);
            try {
                str = exchanger.exchange(str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
