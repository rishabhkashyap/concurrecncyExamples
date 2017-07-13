package com.concurrent.thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
	private String str;

	public MyCallable(String str) {
		this.str = str;
	}

	@Override
	public String call() throws Exception {
		System.out.println("In call method of callable  = " + str);
		StringBuffer sb = new StringBuffer();
		return (sb.append("Length of string  ").append(str).append("is").append(str.length())).toString();

	}

}
