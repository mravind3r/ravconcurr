package synch;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RentrantLockEx {
	

	public static void main(String[] args) throws InterruptedException {
		
		long t1 = System.currentTimeMillis();
		Thread[] t = new Thread[7];
		Printer printer = new Printer();
		for(int i=0;i<t.length;i++){
			Job job = new  Job(printer, "job" + i);
			t[i] = new Thread(job);
		}
		
		for(int i=0;i<t.length;i++){
			t[i].start();
		}
		
		for(int i=0;i<t.length;i++){
			t[i].join();
		}
		
		long t2 = System.currentTimeMillis();
		
		System.out.println("time taken " + (t2-t1));
		
	}
	
	
	
	
	
		
	
	
	
}
