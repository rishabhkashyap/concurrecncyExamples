package com.sync.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EventStorage {
	private int maxSize;
	private LinkedList<Date> storage;
	
	public EventStorage(){
		maxSize=10;
		storage=new LinkedList<>();
	}

	
	
	public synchronized void getStorage() {
		if(storage.size()==0){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}else{
			System.out.println("Inside get... size = "+storage.size());
			storage.poll();
			notifyAll();
		}
		
	}

	public synchronized void  setStorage() {
		
		if(storage.size()==maxSize){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}else{
			storage.add(new Date());
			System.out.println(" in set ... size = "+storage.size());
			notifyAll();
		}
	}
	
	

}
