package com.oddEven.locks.threads;

import com.oddEven.locks.Printer;

public class EvenThread implements Runnable {
	private int limit;

	private Printer printer;

	public EvenThread(int limit, Printer printer) {
		this.limit = limit;
		this.printer = printer;
	}

	@Override
	public void run() {
		for (int i = 2; i <= limit; i = i + 2) {
			printer.printEven(i);
		}
	}
}
