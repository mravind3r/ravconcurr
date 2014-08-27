package basics;

import java.util.Date;
import java.util.Random;

public class ThreadLocalEx {
	
	public static void main(String[] args) {
		
		UnSafetask unSafetask = new ThreadLocalEx().new UnSafetask();
		Thread t1 = new Thread(unSafetask);
		Thread t2 = new Thread(unSafetask);
		Thread t3 = new Thread(unSafetask);
		
		t1.start();t2.start();t3.start();
	}
	
	

	
	
	public class UnSafetask implements Runnable {

		
		
		ThreadLocal<Date> threadLocalDate = new ThreadLocal<Date>(){
			protected Date initialValue(){
				return new Date();
			}
		};
		
		@Override
		public void run() {
			Date date = new Date();
			System.out.println("initial value of date for = "
		         + Thread.currentThread().getName() + " is  "  + date);
			try {
				Thread.sleep(new Random().nextInt(50000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			date = new Date();
			System.out.println("setting the date in the thread :" + Thread.currentThread().getName()
					 + " to " + date);
			
		}
		
	}
	
}
