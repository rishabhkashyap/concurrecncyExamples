package com.demo.resource;

import com.demo.consumer.Philosopher;
import com.demo.consumer.State;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
    private int stickId;
    private Lock lock;

    public Chopstick(int stickId) {
        this.stickId = stickId;
        this.lock = new ReentrantLock();
    }

    public boolean pickUpChopStick(Philosopher philosopher, State state) {
        try {
            if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
                System.out.println(philosopher.toString() + " picked up " + state.toString() + " " + this);
                return true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void putDownChopstick(Philosopher philosopher, State state) {
        lock.unlock();

        System.out.println(philosopher.toString() + " has put down " + state.toString() + " " + this);
    }

    @Override
    public String toString() {
        return "chopstick" + this.stickId;
    }
}
