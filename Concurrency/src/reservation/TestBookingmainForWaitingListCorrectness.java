package reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestBookingmainForWaitingListCorrectness {

	public static void main(String[] args) {
		BookingService bookingService = null;
		List<Client> clients = new ArrayList<>();
		for(int i=0;i<50;i++){
			Client c = new Client();
			clients.add(c);
		}	
		
		for(Client c:clients){
			bookingService = new BookingServiceImpl();
			if(bookingService.checkIn(c)){
				System.out.println("Client booked:" + c);
			}else{
				System.out.println("Client in waiting List:" + c);
			}	
			
		}
		    System.out.println();
			bookingService.getCurrentRoomCapacity();
			System.out.println("\n\n waitlisted clients");
			List<Client> waitlistedClients = bookingService.getWaitingList();
			for(Client c: waitlistedClients){
				System.out.println(c);
			}
			System.out.println();
			bookingService.printRoomCapacityReport();
		
		
			
		  System.out.println("^^^^^^^^^^^^^^^^^^^^^");
		  System.out.println("checking out a few clients randomly");
		  
		  
		  // get the rooms and get the clients
		  Random random = new Random();
		  Room room = Inventory.getInstance().getRoomInventory().get("S");
		  Client c1 = room.getCustomers().get(random.nextInt(9));
		  System.out.println("checking out client :" + c1);
		  bookingService.checkOut(c1);
		  
		  System.out.println();
			bookingService.getCurrentRoomCapacity();
			System.out.println("\n\n waitlisted clients");
			waitlistedClients = bookingService.getWaitingList();
			for(Client c: waitlistedClients){
				System.out.println(c);
			}
			System.out.println();
			bookingService.printRoomCapacityReport();
		  
		
			
			
			
		
	}
	
}
