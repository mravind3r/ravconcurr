package interview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Basket {

	private Queue<Integer> queue;
	
	
	public Basket(Queue<Integer> queue){
		this.queue = queue;
	}
	
	
	public void produce() throws InterruptedException{
		synchronized (this) {
			System.out.println("....");
		while(true){
			if(!queue.isEmpty()){
			 wait();
			}else{
				int x = new Random().nextInt();
				System.out.println("produced:" + x);
				queue.offer(x);
				notify();
			}
			
			Thread.sleep(100); 
			}
			
		}
		
	}
	
	public void consume() throws InterruptedException{
		
		synchronized (this) {
			while(true) {
				if(queue.isEmpty()){
					wait();	
				}else{
				System.out.println("consumed:" + queue.poll());
				  notify();
				}
				
				
		}	
	}
		
		
	}

	
}	
	
	
	

