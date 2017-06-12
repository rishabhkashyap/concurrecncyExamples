package com.countDownLatch.service;

import java.util.concurrent.CountDownLatch;

public class Service implements Runnable {

	private CountDownLatch latch;
	private int timeToStart;
	private String serviceName;

	public Service(CountDownLatch latch, int timeToStart, String serviceName) {
		this.serviceName = serviceName;
		this.timeToStart = timeToStart;
		this.latch = latch;

	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(timeToStart);
			System.out.println("Starting srvice = " + serviceName);
			latch.countDown();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
