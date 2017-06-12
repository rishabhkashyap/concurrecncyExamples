package com.countDownLatch.main;

import java.util.concurrent.CountDownLatch;

import com.countDownLatch.service.Service;

public class LatchMain {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		Thread cacheService = new Thread(new Service(latch, 1000, "CacheService"));
		Thread alertService = new Thread(new Service(latch, 1000, "AlertService"));
		Thread validationService = new Thread(new Service(latch, 1000, "ValidationService"));
		cacheService.start();
		alertService.start();
		validationService.start();
		
		try{
			latch.await();
			System.out.println("All services are up, Application is starting now");
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		

	}

}
