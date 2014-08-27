package basics;

import java.lang.Thread.UncaughtExceptionHandler;

public class HandlingUncheckedExceptions {

	public static void main(String[] args) throws InterruptedException {
		
		HandlingUncheckedExceptions.Uncheck uncheck 
		                 = new HandlingUncheckedExceptions().new  Uncheck();
		uncheck.setUncaughtExceptionHandler(new  HandlingUncheckedExceptions().new MyExceptionHandler());
		uncheck.start();
		uncheck.join();
		
		System.out.println("ending main..");
	}
	
	
	class Uncheck extends Thread {
		public void run(){
			Integer x = Integer.parseInt("abc");
			for(int i=0;i<10;i++){
				System.out.println("processing ..." + i);
			}
		}
	}
	
	
	class MyExceptionHandler implements UncaughtExceptionHandler{

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println("thread causing this exception:" + t.getName());
			System.out.println(" exception:" + e.getMessage());
			System.out.println(t.getState());
		}
		
	}
	
}
