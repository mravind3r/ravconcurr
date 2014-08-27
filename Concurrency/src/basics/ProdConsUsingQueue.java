package basics;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class ProdConsUsingQueue {
	
	public static void main(String[] args) {
		
		BlockingQueue<Integer> production = new PriorityBlockingQueue<Integer>();
		
		Producer producer = new ProdConsUsingQueue().new Producer(production);
		Consumer consumer = new ProdConsUsingQueue().new Consumer(production);
		
		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(consumer);
		
		t1.start();t2.start();
	}
	
	
	public class Producer implements  Runnable{
		
		BlockingQueue<Integer> queue;
		
		public Producer(BlockingQueue<Integer> queue){
			this.queue = queue;
		}

		@Override
		public void run() {
			for(int i=0;i<100;i++){
				System.out.println("producing.. :" +i);
				try {
					queue.put(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	
	public class Consumer implements Runnable {

		BlockingQueue<Integer> blockingQueue ;
		
		public Consumer(BlockingQueue<Integer> queue){
			this.blockingQueue = queue;
		}
		
		public void run() {
			try {
				while(true){
				Integer i = blockingQueue.take();
				System.out.println("consuming..:" + i);
				
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
		}
	}
	

}
