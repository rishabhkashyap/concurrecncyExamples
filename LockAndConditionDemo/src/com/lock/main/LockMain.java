package com.lock.main;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.lock.model.EventStorage;
import com.lock.threads.Consumer;
import com.lock.threads.Producer;

public class LockMain {

	public static void main(String[] args) {
		Lock lock=new ReentrantLock();
		EventStorage eventStorage=new EventStorage(lock, 10);
		Thread consumerThread=new Thread(new Consumer(eventStorage));
		Thread producerThread=new Thread(new Producer(eventStorage));
		producerThread.start();
		consumerThread.start();
		

	}

}
