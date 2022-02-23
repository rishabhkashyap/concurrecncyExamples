package com.demo.consumer;

import com.demo.resource.Chopstick;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Philosopher implements Runnable {

    private int philosopherId;
    private AtomicBoolean terminated;
    private Chopstick leftChopstick;
    private Chopstick rightChopStick;
    private Random random;
    private int eatCounter;

    public Philosopher(int philosopherId, Chopstick leftChopstick, Chopstick rightChopStick) {
        this.philosopherId = philosopherId;
        this.leftChopstick = leftChopstick;
        this.rightChopStick = rightChopStick;
        this.random = new Random();
        this.terminated = new AtomicBoolean(false);

    }

    @Override
    public void run() {
        while (!this.terminated.get()) {
            this.thinkPhilosopher();
            if (this.leftChopstick.pickUpChopStick(this, State.LEFT)) {
                if (this.rightChopStick.pickUpChopStick(this, State.RIGHT)) {
                    this.eatPhilosopher();
                    this.rightChopStick.putDownChopstick(this, State.RIGHT);
                }
                this.leftChopstick.putDownChopstick(this, State.LEFT);
            }
        }

    }

    private void thinkPhilosopher() {
        System.out.println(this + " is thinking...");
        try {
            Thread.sleep(this.random.nextInt(1001));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void eatPhilosopher() {
        System.out.println(this + " is eating");
        ++this.eatCounter;
        try {
            Thread.sleep(this.random.nextInt(1001));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public AtomicBoolean getTerminated() {
        return terminated;
    }

    public void setTerminated(boolean value) {
        this.terminated.set(value);
    }

    public int getEatCounter() {
        return eatCounter;
    }

    @Override
    public String toString() {
        return "Philosopher" + this.philosopherId;
    }
}
