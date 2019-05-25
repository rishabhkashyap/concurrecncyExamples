package com.sequence.threads;

public class SequenceThread implements Runnable {

    public int upto;
    static int  number=1;
    int remainder;
    static Object lock=new Object();

    public SequenceThread(int remainder,int upto)
    {
        this.remainder=remainder;
        this.upto=upto;
    }

    @Override
    public void run() {
        while (number < upto -1) {
            synchronized (lock) {
                while (number % 3 != remainder) { // wait for numbers other than remainder
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + number);
                number++;
                lock.notifyAll();
            }
        }
    }
}
