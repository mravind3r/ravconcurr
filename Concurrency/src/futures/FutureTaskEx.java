package futures;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskEx {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Task task = new FutureTaskEx().new Task();
		FutureTask<Integer> f1 = new FutureTask<Integer>(task);
		FutureTask<Integer> f2 = new FutureTask<Integer>(task);
		FutureTask<Integer> f3 = new FutureTask<Integer>(task);
			
		ExecutorService executorService = Executors.newFixedThreadPool(2);
//		executorService.submit(f1);
//		executorService.submit(f2);
//		executorService.submit(f3);
//	
//		System.out.println(f1.get());
		
		
		executorService.submit(f1);
		
		
		try{
			f1.get();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		executorService.shutdown();
		
		
	}
	
	
	public class Task implements Callable<Integer>{

		@Override
		public Integer call() throws Exception {
			Thread.sleep(1000);
			System.out.println("calculating.....");
			if(true)
			throw new RuntimeException();
			return 1;
		}
		
	}
	
	
	
	
	
	
}
