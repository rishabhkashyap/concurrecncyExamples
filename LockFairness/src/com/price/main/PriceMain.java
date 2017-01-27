package com.price.main;

import com.price.model.PriceInfo;
import com.price.threads.Reader;
import com.price.threads.Writer;

public class PriceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriceInfo priceInfo=new PriceInfo();
		Reader[]readers=new Reader[5];
		Thread[]threadReader=new Thread[5];
		for(int i=0;i<5;i++){
			readers[i]=new Reader(priceInfo);
			threadReader[i]=new Thread(readers[i]);
		}
		Writer writer=new Writer(priceInfo);
		for(int j=0;j<5;j++){
			threadReader[j].start();
		}
		Thread threadWriter=new Thread(writer);
		threadWriter.start();
		

	}

}
