package com.concurrent.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.concurrent.thread.MyCallable;

public class CallableMain {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(4);
		Future<String> f1 = es.submit(new MyCallable("callable"));
		Future<String> f2 = es.submit(new MyCallable("future"));
		Future<String> f3 = es.submit(new MyCallable("Executor"));
		Future<String> f4 = es.submit(new MyCallable("executor service"));
		Future<String> f5 = es.submit(new MyCallable("executors"));
		Future<String> f6 = es.submit(new MyCallable("scheduled executors"));
		tempMethod();
		try {
			System.out.println("1. " + f1.get());
			System.out.println("2. " + f2.get());
			System.out.println("3. " + f3.get());
			if (f4.isDone()) {
				System.out.println("F4 is done");
			} else {
				System.out.println("Waiting....");
			}

			System.out.println("5. " + f5.get());
			System.out.println("6. " + f6.get());

		} catch (Exception e) {
			e.printStackTrace();
		}
		es.shutdown();

	}

	public static void tempMethod() {
		System.out.println("I am in temp method");
	}

}
