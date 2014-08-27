package reservation;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public interface Room {
	List<Client> getCustomers();
	AtomicInteger getNumRooms();
	 void bookRooms();
	 void releaseRoom();
	 
}
