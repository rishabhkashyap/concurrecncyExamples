package com.lock.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class EventStorage {
	private List<String> storageQueue;
	private Lock lock;
	private int size;
	private Condition isFull;
	private Condition isEmpty;

	public EventStorage(Lock lock, int size) {
		super();
		this.storageQueue = new ArrayList<>();
		this.lock = lock;
		this.isFull = lock.newCondition();
		this.isEmpty = lock.newCondition();
		this.size = size;
	}

	public void add(String str) {
		lock.lock();
		try {
			if (storageQueue.size() == size) {
				isFull.await();

			} else {
				storageQueue.add(str);
				System.out.println("Inside add ... size = " + storageQueue.size());
				isEmpty.signalAll();
				lock.unlock();

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//lock.unlock();
		}

	}

	public void remove() {
		lock.lock();
		try {
			if (storageQueue.size() == 0) {
				isEmpty.await();
			} else {
				System.out.println("Inside remove... size = " + storageQueue.size());
				storageQueue.remove(0);
				isFull.signalAll();
				lock.unlock();

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//lock.unlock();
		}
	}

}
