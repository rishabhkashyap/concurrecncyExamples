package com.deadlock.threads;

import com.deadlock.resources.ResourceA;
import com.deadlock.resources.ResourceB;

public class ThreadB implements Runnable {
	private ResourceA resourceA;
	private ResourceB resourceB;
	
	public ThreadB(ResourceA resourceA, ResourceB resourceB) {		
		this.resourceA = resourceA;
		this.resourceB = resourceB;
	}
	
	public void  getLocks(){
		synchronized (resourceA) {
			try{
				Thread.sleep(200);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		synchronized (resourceB) {
			
			System.out.println("\n Inside Thread A");
			
		}
	}

	@Override
	public void run() {
		getLocks();
		
	}
	
	
	
	
}
