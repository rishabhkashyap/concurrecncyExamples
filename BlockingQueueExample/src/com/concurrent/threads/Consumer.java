package com.concurrent.threads;

import java.util.concurrent.BlockingQueue;

import com.concurrent.model.Message;

public class Consumer implements Runnable {
	private BlockingQueue<Message>queue;
	
	

	public Consumer(BlockingQueue<Message> queue) {		
		this.queue = queue;
	}



	@Override
	public void run() {
		Message msg=null;
		try {
			while(!(msg=queue.take()).getMsg().equals("Message10")){
				
					
					Thread.sleep(10);
					System.out.println("Message consumed = "+msg.getMsg());
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
