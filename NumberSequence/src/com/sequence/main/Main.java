package com.sequence.main;

import com.sequence.threads.SequenceThread;

public class Main {

    public static void main(String[] args) {

        SequenceThread sequenceThread1=new SequenceThread(1,10);
        SequenceThread sequenceThread2=new SequenceThread(2,10);
        SequenceThread sequenceThread3=new SequenceThread(0,10);

        Thread t1=new Thread(sequenceThread1,"T1");
        Thread t2=new Thread(sequenceThread2,"T2");
        Thread t3=new Thread(sequenceThread3,"T3");

        t1.start();
        t2.start();
        t3.start();

    }
}
