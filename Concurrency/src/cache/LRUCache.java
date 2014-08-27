package cache;

import java.lang.ref.WeakReference;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

public class LRUCache {

	
	 private ConcurrentHashMap<Integer,Customer> cache = null;
	 
	 private ExecutorService executorService = null;
	 
	 public LRUCache(){
		 cache = new ConcurrentHashMap<Integer,Customer>();
		 executorService = Executors.newFixedThreadPool(4);
	 }
	 
	 
	 
	 
	 public Customer getCustomer(int customerId){
		 Customer customer = cache.get(customerId);
		 if(customer==null){
			 // no cache hit
			 // retreive from source and add it to the map
			 // strategy is to get the data using future task
			 
			 Future<Customer> future = executorService.submit(new Callable<Customer>() {

				@Override
				public Customer call() throws Exception {
					// TODO Auto-generated method stub
					return null;
				}
			});
			 
			 
			 try {
				Customer c = future.get();
				if(c!=null){
					// check if the cache is full ie size 
					if(cache.size()>100){
						// delete the first one to be added here 
						cache.put(c.getCustomerId(), c);
						customer = c;
					}
					
				}
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }
		 
		 return customer;
		 
	 }
	 
	 
	 
	
	
	 
}
