package com.deadlock.main;

import com.deadlock.resources.ResourceA;
import com.deadlock.resources.ResourceB;
import com.deadlock.threads.ThreadA;
import com.deadlock.threads.ThreadB;

public class DeadLockMain {
	
	

	public static void main(String[] args) {
		final ResourceA resourceA=new ResourceA();
		final ResourceB resourceB=new ResourceB();
		Thread threadA=new Thread(new ThreadA(resourceA,resourceB));
		Thread threadB=new Thread(new ThreadB(resourceA,resourceB));
		threadB.start();
		threadA.start();

	}

}
