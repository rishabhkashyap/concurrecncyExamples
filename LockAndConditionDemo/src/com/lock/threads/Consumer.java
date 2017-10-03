package com.lock.threads;

import com.lock.model.EventStorage;

public class Consumer implements Runnable {

	private EventStorage eventStorage;

	public Consumer(EventStorage eventStorage) {
		this.eventStorage = eventStorage;
	}

	@Override
	public void run() {

		for (int i = 0; i < 20; i++) {
			eventStorage.add("Element" + i);
		}

	}
}
