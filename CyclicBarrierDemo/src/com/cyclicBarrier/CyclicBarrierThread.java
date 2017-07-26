package com.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierThread implements Runnable {
	private CyclicBarrier barrier;
	
	

	public CyclicBarrierThread(CyclicBarrier barrier) {		
		this.barrier = barrier;
	}



	@Override
	public void run() {
		try{
			System.out.println(Thread.currentThread().getName()+"  is waiting for barrier");
			barrier.await();
			System.out.println(Thread.currentThread().getName()+"  has crossed barrier");
		}catch(InterruptedException e){
			e.printStackTrace();
		}catch(BrokenBarrierException ex){
			ex.printStackTrace();
		}

	}

}
