package reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class StandardRoom implements Room{

	
	private  List<Client> customers;
	private AtomicInteger numRooms; 
	public StandardRoom(){
		customers = new ArrayList<>();
		numRooms = new AtomicInteger(10);
	}
	public List<Client> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Client> customers) {
		this.customers = customers;
	}
	public AtomicInteger getNumRooms() {
		return numRooms;
	}
	public void bookRooms() {
		this.numRooms.getAndDecrement();
	}
	@Override
	public void releaseRoom() {
		this.numRooms.getAndIncrement();
		
	}
	
	
}
