package reservation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class BookingServiceImpl implements BookingService {

	
	private Lock lock ;
	private Room standard ;
	private Room gold ;
	private Room premium ;

	public BookingServiceImpl() {
		lock = new ReentrantLock();
		standard =  Inventory.getInstance().getRoomInventory().get("S");
		gold = Inventory.getInstance().getRoomInventory().get("G");
		premium = Inventory.getInstance().getRoomInventory().get("P");
	}

	@Override
	public boolean checkIn(Client client) {
		boolean success = false;
		lock.lock();
		try{
		
		success = bookRoom(standard,gold,premium,client);
			if(!success){
				Inventory.getInstance().addClientToWaitList(client);
			}
		}finally{
		   lock.unlock();	
		}
		return success;
	}

	
	private boolean bookRoom(Room standard,Room gold,Room premium,Client client){
		boolean success = false;
			if (client.getType() == 0) {
				if(standard.getNumRooms().get() > 0){
					standard.bookRooms();
					standard.getCustomers().add(client);
					success = true;
				}
			}else if(client.getType() == 1) {
				if(gold.getNumRooms().get() > 0){
					gold.bookRooms();
					gold.getCustomers().add(client);
					success = true;
				}else if(standard.getNumRooms().get() > 0){
					standard.bookRooms();
					standard.getCustomers().add(client);
					success = true;
				} 
			} else{
				
				if(premium.getNumRooms().get() > 0){
					premium.bookRooms();
					premium.getCustomers().add(client);
					success = true;
				}else if(gold.getNumRooms().get() > 0){
					gold.bookRooms();
					gold.getCustomers().add(client);
					success = true;
				}else if(standard.getNumRooms().get() > 0){
					standard.bookRooms();
					standard.getCustomers().add(client);
					success = true;
				}
				
			}
		
		
		return success;
	}
	
	
	
	@Override
	// assuming checkout process does the following
	// a) checkouts client
	// b) books the client whose wait period is is over
	// c) books the client based on the priority
  public Client checkOut(Client client) {
		lock.lock();
		try{
	     if(client.getType()==0){
	    	 if(standard.getCustomers().remove(client)){
	    	   standard.releaseRoom();
	    	 }
	     }else if(client.getType()==1){
	    	 if(gold.getCustomers().remove(client)){
	    	 gold.releaseRoom();
	    	 }
	     }else{
	    	 if(premium.getCustomers().remove(client)){
	    	 premium.releaseRoom();
	    	 }
	     }
	     
	  // book client whose wait period is over
	     
	     Client maxWaitPeriodClient = Inventory.getInstance().getWaitingList().poll();
	     if(maxWaitPeriodClient!=null){
	     System.out.println("Booking client from waitlist based on waiting time..");
	     System.out.println(maxWaitPeriodClient);
	     bookRoom(standard, gold, premium, maxWaitPeriodClient);
	     }else{
	    	// if no client wait period is over book based on priority
	    	 
	    	 // get the waitlist into some priority queue
	    	 // priority based on customer type
	    	 // comparator used
	    	 
	    	 BlockingQueue< Client> prioriBlockingQueue
	    	   = new PriorityBlockingQueue<Client>(100,typeCompare);
	    	 for(Client c: Inventory.getInstance().getWaitingList()){
	    		 prioriBlockingQueue.add(c);
	    	 }
	    	 
	    	 // take the first one
	    	Client nextClient = prioriBlockingQueue.poll();
	    	if(nextClient!=null){
	    	System.out.println("Booking client from waitlist based on priority..");
		    System.out.println(maxWaitPeriodClient); 
	        bookRoom(standard, gold, premium, nextClient);
	    	}
	     }
	     
		}finally{
			lock.unlock();
		}
		
		return client;
	}	

	@Override
	public Map<MembershipStatus, Integer> getCurrentRoomCapacity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> getWaitingList() {
		List<Client> waitList = new ArrayList<>();
		for(Client c:Inventory.getInstance().getWaitingList()){
			waitList.add(c);
		}
		return waitList;
	}

	@Override
	public void printRoomCapacityReport() {
		Map<String, Room> roomInventory = Inventory.getInstance().getRoomInventory();
		for(Map.Entry<String, Room> e:roomInventory.entrySet()){
			System.out.println();
			System.out.println("Inventory Report for Room type:" +e.getKey());
			System.out.println("Total number of rooms avail:" + e.getValue().getNumRooms());
			System.out.println("Customer list.... =" + e.getValue().getCustomers().size());
			for(Client s: e.getValue().getCustomers()){
				System.out.println(s);
			}
			
		}
	}

	@Override
	public void printWaitingListReport() {
		System.out.println("waiting list report..=" + Inventory.getInstance().getWaitingList().size());
		for(Client c :Inventory.getInstance().getWaitingList()){
			System.out.println(c);
		}

	}

	
	// comparator based only on id , got to take time into account
	
	Comparator<Client> typeCompare = new Comparator<Client>() {
		@Override
		public int compare(Client o1, Client o2) {
			if(o1.getType() < o2.getType()){
				return -1;
			}
			if(o1.getType() > o2.getType()){
				return 1;
			}
			return 0;
		}
	}; 

	
	
}
