package reservation;


import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
	    Thread thread = new Thread(new Main().new BookingTask(poolExecutor));
	   
	    thread.start();
	    thread.join();
	    poolExecutor.shutdown(); 
	}
	
	
		
	public class BookingTask implements Runnable {
  
		private ThreadPoolExecutor executor;
		
		public BookingTask(ThreadPoolExecutor  executor){
			this.executor = executor;
		}
		
		volatile String exit = "N";
		
		@Override
		public void run() {
			
			while(exit.equalsIgnoreCase("N")){System.out.println("Book [Y/N]:");
				System.out.println("running ...");
				System.out.println("Book [Y/N]:");
				String var = new Scanner(System.in).next();
				if(var.equalsIgnoreCase("Y")){
			      AnotherTask task = new Main().new AnotherTask();
				  Future<Boolean> future  = executor.submit(task);
				  try {
					System.out.println("result of :" + future.get());
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}else{
					System.out.println("Exit [Y/N]:");
				    exit = new Scanner(System.in).next();
				}
			}
		}
		
		
		
		
		
	}
	
	
	
	public class AnotherTask implements Callable<Boolean> {

		@Override
		public Boolean call() throws Exception {
			Random random = new Random();
			int x = random.nextInt(2);
			return x>0?true:false;
		}
		
	}
	
}
