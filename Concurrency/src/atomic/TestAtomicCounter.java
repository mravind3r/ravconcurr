package atomic;

import java.util.concurrent.atomic.AtomicReference;

public class TestAtomicCounter {

	
	public static void main(String[] args) throws InterruptedException {
		final  AtomicReference<AtomicCounter> c = new AtomicReference<>(new AtomicCounter());
		
		Thread[] t1 = new Thread[100];
		
		for(int i=0;i<t1.length;i++){
			t1[i] = new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int i=0;i<1000;i++)
					   c.get().incr();
					
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
		
		c.get().print();
 
	}
	
	
}
