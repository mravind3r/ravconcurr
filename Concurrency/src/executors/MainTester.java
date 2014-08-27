package executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class MainTester {

	public static void main(String[] args) {
		ExecutorService e = Executors.newCachedThreadPool();
		
		// create a list of tasks or callable jobs
		List<Callable<Integer>> tasks = new ArrayList<>();
		List<Future<Integer>> futures = new ArrayList<>();
		
		for(int i=0;i<10;i++){
			tasks.add(new Task1());
		}
		
		try {
			futures = e.invokeAll(tasks);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		for(Future f:futures){
			try {
				System.out.println(f.get());
			} catch (InterruptedException | ExecutionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		e.shutdown();
		
	}
	
}
