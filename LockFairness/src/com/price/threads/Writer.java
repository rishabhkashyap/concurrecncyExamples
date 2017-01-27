package com.price.threads;

import com.price.model.PriceInfo;

public class Writer implements Runnable {

	private PriceInfo priceInfo;
	public Writer(PriceInfo priceInfo){
		this.priceInfo=priceInfo;
	}
	@Override
	public void run() {
		for(int i=0;i<3;i++){
			System.out.println("Writer : Modifying prices");
			priceInfo.setPrice1(Math.random()*10, Math.random()*8);
			System.out.println("Pricess modified");
			try{
				Thread.sleep(2);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

}
