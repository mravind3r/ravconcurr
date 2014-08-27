package reservation;
import java.util.List;
import java.util.Map;

public interface BookingService
{
	boolean checkIn(Client client);
	Client checkOut(Client client);
	Map<MembershipStatus, Integer> getCurrentRoomCapacity();
	List<Client> getWaitingList();
	void printRoomCapacityReport();
	void printWaitingListReport();
}