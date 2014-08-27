package reservation;

import static org.junit.Assert.*;


import org.junit.Test;

public class TestBookingServiceImpl {

	@Test
	public void testCheckInForSuccess() {
		BookingService bookingService = new BookingServiceImpl();
		Client client = new Client();
		client.setType(2);
		assertTrue(bookingService.checkIn(client));
	}
	
	@Test
	public void testCheckInForFailure() {
		BookingService bookingService = new BookingServiceImpl();
		// set the client type to 0 and add 10 customers ( standard room has got 10 max limit)
		// 11th one will return a failure
		for(int i=0;i<10;i++){
		Client client = new Client();
		client.setType(0);
		bookingService.checkIn(client);
		}
		
		Client client = new Client();
		client.setType(0);
		assertFalse(bookingService.checkIn(client));
		
	}
	

	@Test
	public void testCheckOut() {
		// 1) if the room has inventory decremented
	
		// create booking first and then check out , check the room inventory for assertion 
		
		Client client = new Client();
		client.setType(0); // 0 for standard room
		BookingService bookingService = new BookingServiceImpl();
		int initialRoomCapacity = Inventory.getInstance().getRoomInventory().get("S").getNumRooms().get();
		boolean success = bookingService.checkIn(client);
		int currentRoomCapacity  = 0;
		if(success){
			bookingService.checkOut(client);
			currentRoomCapacity =Inventory.getInstance().getRoomInventory().get("S").getNumRooms().get();
			
		}
		
		assertEquals(initialRoomCapacity, currentRoomCapacity);
		
		
	}

	@Test
	public void testGetCurrentRoomCapacity() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetWaitingList() {
		BookingService bookingService = new BookingServiceImpl();
		// set the client type to 0 and add 10 customers ( standard room has got 10 max limit)
		// 11th one will go on a waiting list
		for(int i=0;i<10;i++){
		Client client = new Client();
		client.setType(0);
		bookingService.checkIn(client);
		}
		
		Client client = new Client();
		client.setType(0);
		
		boolean success = bookingService.checkIn(client);
		
		if(!success){
		assertTrue(Inventory.getInstance().getWaitingList().contains(client));
		}
		
	}

}
