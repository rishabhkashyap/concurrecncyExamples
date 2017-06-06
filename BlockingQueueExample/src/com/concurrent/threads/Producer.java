package com.concurrent.threads;

import java.util.concurrent.BlockingQueue;

import com.concurrent.model.Message;

public class Producer implements Runnable {
	
	private BlockingQueue<Message>queue;
	
	
	public Producer(BlockingQueue<Message> queue) {		
		this.queue = queue;
	}


	@Override
	public void run(){
		for(int i=1;i<=10;i++){
			Message msg=new Message("Message"+i);
			try{
				Thread.sleep(i);
				queue.put(msg);
				System.out.println("Message generated => "+msg.getMsg());
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		

	}

}
