package com.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierMain {

	public static void main(String[] args) {
		final CyclicBarrier barrier=new CyclicBarrier(3, ()->System.out.println("Everyone is at barrier point ... lets play !!!"));
		Thread thread1=new Thread(new CyclicBarrierThread(barrier),"Thread1");
		Thread thread2=new Thread(new CyclicBarrierThread(barrier),"Thread2");
		Thread thread3=new Thread(new CyclicBarrierThread(barrier),"Thread3");
		
		thread1.start();
		thread2.start();
		thread3.start();

	}
	

}
