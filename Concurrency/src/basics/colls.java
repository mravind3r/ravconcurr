package basics;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class colls {
	
	public static void main(String[] args) {
		
		Queue<Integer> queue = new PriorityQueue<Integer>();
		
		queue.add(9);
		queue.add(12);
		queue.add(23);
		queue.add(19);
		// the least element is processed first , useful to implement algos where
		// for example you have premium customer first and ordinary custimers later
		
		for(int i=0;i<3;i++)
		System.out.println(queue.poll());
		
		System.out.println("elements remaining...");
		
		for(Integer i:queue){
			System.out.println(i);
		}
		
		
	 //  System.out.println(queue.peek());// does not take items off the queue
	   
	   
	   
	   Queue<Integer> queue2 = new LinkedList<Integer>();
	   queue2.add(12);
	   queue2.add(1);
	   System.out.println("elemets inside linked list");
	   for(Integer i:queue2){
		   System.out.println(i);
	   }
	   
	   
		
	}

}
