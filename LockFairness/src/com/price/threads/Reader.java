package com.price.threads;

import com.price.model.PriceInfo;

public class Reader implements Runnable {
	private PriceInfo priceInfo;
	public Reader(PriceInfo priceInfo){
		this.priceInfo=priceInfo;
	}

	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println("Price 1 = "+priceInfo.getPrice1()+"Thread = "+Thread.currentThread().getName());
			System.out.println("Price 2 = "+priceInfo.getPrice2()+"Thread = "+Thread.currentThread().getName());
		}

	}

}
