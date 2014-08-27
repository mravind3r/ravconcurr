package cyclicb;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CycBarrier {

	public static void main(String[] args) {
		
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
		
		Task task = new CycBarrier().new Task(cyclicBarrier);
		Thread t1 = new Thread(task);
		t1.start();
		
		Thread t3 = new Thread(task);
		t3.start();
		
		Thread t2 = new Thread(task);
		t2.start();
		
	}

	
	public class Task implements Runnable{
       
		CyclicBarrier barrier;
		
       public Task(CyclicBarrier cyclicBarrier){
    	   this.barrier = cyclicBarrier;
       }
		
		
		@Override
		public void run() {
			try {
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			
			System.out.println("thread running....:" + Thread.currentThread().getName());
			
			
		}
		
	}
	
	
	
}



