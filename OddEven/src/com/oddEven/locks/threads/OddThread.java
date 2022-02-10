package com.oddEven.locks.threads;

import com.oddEven.locks.Printer;

public class OddThread implements Runnable {
	private int limit;

	private Printer printer;

	public OddThread(int limit, Printer printer) {
		this.limit = limit;
		this.printer = printer;
	}

	@Override
	public void run() {
		for (int i = 1; i <=limit ; i=i+2) {
			printer.printOdd(i);
		}
	}
}
