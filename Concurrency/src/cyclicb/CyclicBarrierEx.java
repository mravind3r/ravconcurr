package cyclicb;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierEx {

	public static void main(String[] args) {
		
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
			
			@Override
			public void run() {
				System.out.println("barrier breached ...");
				
			}
		});
		
		
		Thread[] t = new Thread[3];
		
		for(int i=0;i<t.length;i++){
			Task task = new CyclicBarrierEx().new Task(cyclicBarrier);
			t[i] = new Thread(task);
			t[i].start();
		}
		
		
		
		
		
	}
	
	public class Task implements  Runnable {
		CyclicBarrier cyclicBarrier;
		
		public Task(CyclicBarrier cyclicBarrier){
			this.cyclicBarrier = cyclicBarrier;
		}
		
		public void run() {
			System.out.println("running task... " + Thread.currentThread().getName());
			try {
				cyclicBarrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(" barrier broken now finishing task... " + Thread.currentThread().getName());
			
		}
	}
	
	
	
}
