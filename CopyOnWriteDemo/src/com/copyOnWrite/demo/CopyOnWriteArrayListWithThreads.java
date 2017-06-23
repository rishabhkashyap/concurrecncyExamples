package com.copyOnWrite.demo;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListWithThreads {

	public static void main(String[]args){
		List<Integer>numbers=new CopyOnWriteArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		Runnable r1=()->{
			try{
				Iterator<Integer>iterator =numbers.iterator();
				while(iterator.hasNext()){
					System.out.print(iterator.next()+" ");
					Thread.sleep(1000);
				}
			}catch(ConcurrentModificationException e){
				System.out.println(Thread.currentThread().getName()+"  ConcurrentModificationException");
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			
		};
		Runnable r2=()->{
			try{
				
				
					Thread.sleep(2000);
					numbers.add(100);
					System.out.println("\nNew element added" );
					System.out.println("New list = "+numbers );
					
					
				
			}catch(ConcurrentModificationException e){
				System.out.println(Thread.currentThread().getName()+"  ConcurrentModificationException");
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			
		};
		Thread thread1=new Thread(r1,"Thread 1");
		Thread thread2=new Thread(r2,"Thread 2");
		thread1.start();
		thread2.start();
	}

}
