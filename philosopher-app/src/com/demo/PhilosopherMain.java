package com.demo;

import com.demo.consumer.Philosopher;
import com.demo.resource.Chopstick;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PhilosopherMain {

    private static final int N = 5;
    private static final int RUN_TIME_MILLI_SECONDS = 30 * 1000;

    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[N];
        Chopstick[] chopsticks = new Chopstick[N];
        ExecutorService executorService = Executors.newFixedThreadPool(N);
        try {
            for (int i = 0; i < N; i++) {
                chopsticks[i] = new Chopstick(i + 1);
            }
            for (int i = 0; i < N; i++) {
                philosophers[i] = new Philosopher(i + 1, chopsticks[i], chopsticks[(i + 1) % N]);
                executorService.execute(philosophers[i]);
            }
            Thread.sleep(RUN_TIME_MILLI_SECONDS);
            Arrays.stream(philosophers).forEach(e -> e.setTerminated(true));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
            while (executorService.isTerminated()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (Philosopher philosopher : philosophers) {
                System.out.println(philosopher.toString() + " has eaten " + philosopher.getEatCounter() + " times");
            }
        }

    }
}
