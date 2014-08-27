package reservation;

public class TestingBookingMainForCorrectness {
	
	
	public static void main(String[] args) {
		Client c = new Client();
		BookingService bookingService = new BookingServiceImpl();
		if(bookingService.checkIn(c)){
			System.out.println("Client booked:" + c);
		}
		bookingService.getCurrentRoomCapacity();
		System.out.println();
		bookingService.getWaitingList();
		System.out.println();
		bookingService.printRoomCapacityReport();
		System.out.println("\n\n\n\n");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("checking out lone client:" + c);
		bookingService.checkOut(c);
		System.out.println();
		bookingService.getCurrentRoomCapacity();
		System.out.println();
		bookingService.getWaitingList();
		System.out.println();
		bookingService.printRoomCapacityReport();
		
		
		
		
		
	}

}
