package reservation;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class Inventory {

	private BlockingQueue<Client> waitingList;
	private Map<String, Room> roomInventory;
	
	private Inventory(){
		waitingList = new DelayQueue<>();
		roomInventory = new HashMap<>();
		roomInventory.put("P", new PremiumRoom());
		roomInventory.put("S", new StandardRoom());
		roomInventory.put("G", new GoldRoom());
	}
	
	private static final Inventory instance = new Inventory();
	
	public static Inventory getInstance(){
		return instance;
	}
	
	
	protected void addClientToWaitList(Client client){
	  	waitingList.add(client);
     }

	
	protected BlockingQueue<Client> getWaitingList(){
		
		return waitingList;
	}
	
	
	protected  Map<String, Room> getRoomInventory(){
		return roomInventory;
	}
	
	
	
	
	
}
