package com.oddEven.main;

import com.oddEven.model.OddEvenPrinter;
import com.oddEven.threads.EvenThread;
import com.oddEven.threads.OddThread;

public class OddEvenMain {

	public static void main(String[] args) {
		OddEvenPrinter oddEvenPrinter=new OddEvenPrinter();
		Thread evenThread=new Thread(new EvenThread(oddEvenPrinter,20));
		Thread oddThread=new Thread(new OddThread(oddEvenPrinter,20));
		oddThread.start();
		evenThread.start();

	}

}
