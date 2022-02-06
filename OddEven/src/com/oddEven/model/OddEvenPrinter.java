package com.oddEven.model;

public class OddEvenPrinter {
	private boolean isEvenPrinted;

	public OddEvenPrinter() {
		this.isEvenPrinted = true;
	}

	public void printOdd(int n) throws InterruptedException {
		synchronized (this) {
			if (!isEvenPrinted) {
				wait();
			}
			System.out.println(Thread.currentThread().getName() + ": " + n);
			isEvenPrinted = false;

			// Notify other thread to print even number
			notify();

		}
	}

	public void printEven(int n) throws InterruptedException {
		synchronized (this) {
			if (isEvenPrinted) {
				wait();
			}
			System.out.println(Thread.currentThread().getName() + ": " + n);
			isEvenPrinted = true;
			// notify other thred to print odd number
			notify();
		}
	}

}
