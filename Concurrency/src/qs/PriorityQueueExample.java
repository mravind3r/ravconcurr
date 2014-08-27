package qs;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueExample {

	public static void main(String[] args) {
		
		Comparator<Customer> typeCompare = new Comparator<Customer>() {

			@Override
			public int compare(Customer o1, Customer o2) {
				if(o1.getCustomerType() < o2.getCustomerType()){
					return -1;
				}
			
				if(o1.getCustomerType() > o2.getCustomerType()){
					return 1;
				}
				
				return 0;
			}
		}; 

		PriorityQueue<Customer>  priorityQueue = new PriorityQueue<>(10,typeCompare);
		
		
		for(int i=0;i<10;i++){
			Customer customer = new Customer();
			System.out.println("adding" + customer);
			priorityQueue.add(customer);
		}
		
		System.out.println("the contents ....");
		System.out.println("retreiving data:" + priorityQueue.poll());
		
	
		System.out.println("size of priority  quueue:" + priorityQueue.size());
		
		
		
	}
	
	
}
