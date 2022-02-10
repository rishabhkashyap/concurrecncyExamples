package com.oddEven.sync.threads;

import com.oddEven.sync.model.OddEvenPrinter;

public class OddThread implements Runnable {
	private  OddEvenPrinter oddEvenPrinter;
	private int max;
	 public OddThread(OddEvenPrinter oddEvenPrinter,int max) {
		this.oddEvenPrinter=oddEvenPrinter;
		this.max=max;
	}

	@Override
	public void run() {
		for(int i=1;i<max;i=i+2){
			try{
				oddEvenPrinter.printOdd(i);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
		}

	}

}
