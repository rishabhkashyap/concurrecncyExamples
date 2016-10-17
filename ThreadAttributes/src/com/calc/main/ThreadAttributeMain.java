package com.calc.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;

import com.calc.model.Calculator;

public class ThreadAttributeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread[] threads;
		Thread.State[] status;
		// Create 10 threads
		threads = new Thread[10];
		status = new Thread.State[10];
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new Calculator(i));
			if (i % 2 == 0) {
				threads[i].setPriority(Thread.MAX_PRIORITY);
			} else {
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
			threads[i].setName("Thread" + i);
		}
		File file = new File("C:/Users/rikashyap/workspace/ThreadAttributes/src/log.txt");
		try (PrintWriter pw = new PrintWriter(file)) {
			for (int i = 0; i < 10; i++) {
				pw.println("Main : Status of Thread " + i + " : " + threads[i].getState());
				status[i] = threads[i].getState();
			}

			for (int i = 0; i < 10; i++) {
				threads[i].start();
			}
			boolean finish = false;
			while (!finish) {
				for (int i = 0; i < 10; i++) {
					if (threads[i].getState() != status[i]) {
						writeThreadInfo(pw, threads[i], status[i]);
						status[i] = threads[i].getState();
					}
				}

				finish = true;
				for (int i = 0; i < 10; i++) {
					finish = finish && (threads[i].getState() == State.TERMINATED);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void writeThreadInfo(PrintWriter pw, Thread thread, State state) {
		pw.println();
		pw.printf("\nMain : Id %d - %s\n", thread.getId(), thread.getName());
		pw.println();
		pw.printf("\nMain : Priority: %d\n", thread.getPriority());
		pw.println();
		pw.printf("\nMain : Old State: %s\n", state);
		pw.println();
		pw.printf("\nMain : New State: %s\n", thread.getState());
		pw.println();
		pw.printf("\nMain : ************************************\n");
		pw.println();
	}

}
