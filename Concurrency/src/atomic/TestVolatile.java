package atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class TestVolatile {

	 volatile int val;
	 AtomicInteger val2 = new AtomicInteger();
	 
	 synchronized void incrVola(){
		 val++;
	 }
	 
	 void incrAtom(){
		 val2.getAndIncrement();
	 }
	
	public static void main(String[] args) throws InterruptedException {
		
		final TestVolatile v = new TestVolatile();
		Thread[] t1 = new Thread[10];
		
		for(int i=0;i<t1.length;i++){
			t1[i] = new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int i=0;i<1000;i++){
					 v.incrVola();
					 v.incrAtom();
					}
					
				}
			});
		}
		
		long t0 = System.currentTimeMillis();
		
		
		for(int i=0;i<t1.length;i++){
			t1[i].start();
		}
		
		
		
		for(int i=0;i<t1.length;i++){
			t1[i].join();
		}
		
		
		
		long t01 = System.currentTimeMillis();
		
		
		System.out.println("time taken:"+ (t01-t0));
		
		System.out.println(v.val);
		System.out.println(v.val2);
	}
	
}
