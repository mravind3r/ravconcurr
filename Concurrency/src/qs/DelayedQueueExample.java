package qs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class DelayedQueueExample {
	
	public static void main(String[] args) throws InterruptedException {
		
		HashMap<String, Integer> inventory = new HashMap<>(100);
		inventory.put("P", 0);
		inventory.put("S", 0);
		inventory.put("G", 1);
		
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
		
		BlockingQueue< Customer> blockingQueue = new DelayQueue<Customer>();
		
		List<Customer> customerList = new ArrayList<>();
		
		
		for(int i=0;i<20;i++){
			Customer customer = new Customer();
			System.out.println("adding customer " + customer);
			blockingQueue.add(customer);
		}
		
		Thread.sleep(400);
		
		Customer nextTobeCheckIn = blockingQueue.poll(); 
		// does not matter where to check in cos its upgrade as he waited 
		if(nextTobeCheckIn!=null){
			   if(inventory.get("P")>0){
				   inventory.put("P", inventory.get("P")-1);
			   }else if(inventory.get("G")>0){
				   inventory.put("G", inventory.get("G")-1);
			   }else if(inventory.get("S")>0){
				   inventory.put("S", inventory.get("S")-1);
			   }
		}else{
		 System.out.println(" no one has outlived waiting time...");
			for(Customer c:blockingQueue){
				  customerList.add(c);
				}
				Collections.sort(customerList,typeCompare);
			
				// now same logic to put customers in 
				
				nextTobeCheckIn = customerList.get(0);
				System.out.println("checking in.." + nextTobeCheckIn);
				if(nextTobeCheckIn!=null){
					if(nextTobeCheckIn.getCustomerType()==0){
					   if(inventory.get("P")>0){
						   inventory.put("P", inventory.get("P")-1);
					   }else if(inventory.get("G")>0){
						   inventory.put("G", inventory.get("G")-1);
					   }else if(inventory.get("S")>0){
						   inventory.put("S", inventory.get("S")-1);
					   }
					   
					}
				}

			
			
		}
		
				
		
	
		System.out.println("rooms in S:" + inventory.get("S"));

		
	}
	
	
	
	

}
