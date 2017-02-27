package com.oddEven.threads;

import com.oddEven.model.OddEvenPrinter;

public class EvenThread implements Runnable {
	private  OddEvenPrinter oddEvenPrinter;
	private int max;
	 public EvenThread(OddEvenPrinter oddEvenPrinter,int max) {
		this.oddEvenPrinter=oddEvenPrinter;
		this.max=max;
	}

	@Override
	public void run() {
		for(int i=2;i<=max;i=i+2){
			try{
				oddEvenPrinter.printEven(i);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
		}

	}

}
