package com.sync.main;

import com.sync.model.Account;
import com.sync.threads.Bank;
import com.sync.threads.Company;

public class SyncMain {
	public static void main(String[] args){
		Account account=new Account();
		account.setBalance(1000);
		Bank bank=new Bank(account);
		Company company=new Company(account);
		Thread bankThread=new Thread(bank,"Bank");
		Thread companyThread =new Thread(company,"Company");
		System.out.println("Initial amt = "+account.getBalance());
		//Starting thread
		companyThread.start();
		bankThread.start();
		System.out.println("Final amt = "+account.getBalance());
//		try{
//			companyThread.join();
//			bankThread.join();
//			System.out.println("Final amt = "+account.getBalance());
//			
//		}catch(InterruptedException e){
//			e.printStackTrace();
//		}
		
	}

}
