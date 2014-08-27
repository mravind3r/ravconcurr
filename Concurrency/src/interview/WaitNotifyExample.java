package interview;

import java.util.LinkedList;
import java.util.Queue;

public class WaitNotifyExample {
    public static void main(String[] args) throws InterruptedException {
		Queue<Integer> queue = new LinkedList<>();
    	final Basket basket = new Basket(queue);
    	
    	Thread producer = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					basket.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
    	
    	
Thread consumer = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					basket.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
    	
    producer.start();
    consumer.start();
    
    producer.join();
    consumer.join();


    	
	}
}
