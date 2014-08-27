package reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class TestingForConcurrency {

	// use a gaggle of threads to book and checkout

	// print report at the end

	public static void main(String[] args) throws InterruptedException {
		int threads = Runtime.getRuntime().availableProcessors() * 2;
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors
				.newFixedThreadPool(threads);
        BookingService bookingService = new BookingServiceImpl();
		
         printStats(bookingService);
        
		// checkin
        List<Future<Void>> fTasks = new ArrayList<>();
        List<Callable<Void>> callables = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			CheckinTask checkInTask = 
					new TestingForConcurrency().new CheckinTask(bookingService);
			callables.add(checkInTask);
		}

		// checkout

		for (int i = 0; i < 10; i++) {
             CheckoutTask checkoutTask = 
            		  new TestingForConcurrency().new CheckoutTask(bookingService);
             callables.add(checkoutTask);
		}
		
	
		fTasks = threadPoolExecutor.invokeAll(callables);
		
		
		// block and let all the threads complete , join them to main thread before printing report
		
		for(Future<Void> f: fTasks){
			try {
				f.get();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
        threadPoolExecutor.shutdown();		
        
        printStats(bookingService);		

	}
	
	
	private  static void printStats(BookingService bookingService){
	    		List<Client> waitlistedClients = bookingService.getWaitingList();
	    		System.out.println("\n waitlisted clients:" +waitlistedClients.size());
				for(Client c: waitlistedClients){
					System.out.println(c);
				}
				System.out.println();
				bookingService.printRoomCapacityReport();
			
	}
	

	public class CheckinTask implements Callable<Void> {
		private BookingService service;

		public CheckinTask(BookingService service) {
			this.service = service;
		}

		@Override
		public Void call() throws Exception {
			Client c = new Client();
			if (service.checkIn(c)) {
				System.out.println("Client booked:" + c);
			}
			return null;
		}

	}

	public class CheckoutTask implements Callable<Void> {

		private BookingService service;

		public CheckoutTask(BookingService service) {
			this.service = service;
		}

		@Override
		public Void call() throws Exception {
			
			Room standard = Inventory.getInstance().getRoomInventory().get("S");
			Client c1 = standard.getCustomers().get(0);
			if(c1!=null){
			 service.checkOut(c1);
			System.out.println("checking out client :" + c1);
			}else{
				System.out.println("checkout failed^^^^^^");
			}
			
			Room premium = Inventory.getInstance().getRoomInventory().get("P");
			if(c1!=null){
			c1 = premium.getCustomers().get(0);
			service.checkOut(c1);
			System.out.println("checking out client :" + c1);
			}else{
				System.out.println("checkout failed^^^^^^");
			}
			
			Room gold = Inventory.getInstance().getRoomInventory().get("G");
			c1 = gold.getCustomers().get(0);
			if(c1!=null){
			service.checkOut(c1);
			System.out.println("checking out client :" + c1);
			}else{
				System.out.println("checkout failed^^^^^^");
			}
			return null;
		}

	}

}
