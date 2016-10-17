package com.sync.main;

import com.sync.model.EventStorage;
import com.sync.threads.Consumer;
import com.sync.threads.Producer;

public class SyncMain {
	public static void main(String[] args) {
		EventStorage eStorage = new EventStorage();
		Producer producer = new Producer(eStorage);
		Consumer consumer = new Consumer(eStorage);
		Thread producerThread = new Thread(producer);
		Thread consumerThread = new Thread(consumer);
		consumerThread.start();
		producerThread.start();
	}

}
