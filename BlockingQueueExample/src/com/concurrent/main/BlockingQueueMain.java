package com.concurrent.main;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.concurrent.model.Message;
import com.concurrent.threads.Consumer;
import com.concurrent.threads.Producer;

public class BlockingQueueMain {
	
	public static void main(String[]args){
		BlockingQueue<Message>bq=new ArrayBlockingQueue<>(10);
		Thread producer=new Thread(new Producer(bq));
		Thread consumer=new Thread(new Consumer(bq));
		producer.start();
		consumer.start();
		
	}

}
