package com.price.model;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PriceInfo {
	private  double price1;
	private  double price2;
	private ReadWriteLock lock;
	
	public PriceInfo(){
		price1=1;
		price2=2;
		lock=new ReentrantReadWriteLock();
	}
	public double getPrice1(){
		lock.readLock().lock();
		double value=price1;
		lock.readLock().unlock();
		return value;
	}
	
	public double getPrice2(){
		lock.readLock().lock();
		double value=price2;
		lock.readLock().unlock();
		return value;
	}
	public void setPrice1(double value1,double value2){
		lock.writeLock().lock();
		price1=value1;
		price2=value2;
		lock.writeLock().unlock();
	}

}
