package atomic;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class TestAccount {

	public static void main(String[] args) throws InterruptedException {
		final HashMap<String,Account> acc = new HashMap<>();
		acc.put("a", new Account(300));
		acc.put("b", new Account(100));
		
		Thread[] t = new Thread[50];
		
		for(int i=0;i<t.length;i++){
			t[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					for(int i=0;i<50;i++){
					acc.get("a").addBal(new BigDecimal(20));
					acc.get("b").addBal(new BigDecimal(10));
					
					
					
					}
				}
			});
		}
	
		long t0 = System.currentTimeMillis();
		for(int i=0;i<t.length;i++){
			t[i].start();
		}
		
		for(int i=0;i<t.length;i++){
			t[i].join();
		}
		
		
long t01 = System.currentTimeMillis();
		
		
		System.out.println("time taken:"+ (t01-t0));
		
		
		acc.get("a").printBal();
		acc.get("b").printBal();
		
	}
	
}
