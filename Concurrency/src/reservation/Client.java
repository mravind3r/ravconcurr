package reservation;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;



public class Client implements Delayed{

	private int type;
	private String name;
	private long startTime;
	
	private static final long MAX_WAIT_TIME = 300;
	
	public int getType() {
		return type;
	}



	public void setType(int type) {
		this.type = type;
	}



	public long getStartTime() {
		return startTime;
	}



	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}



	@Override
	public String toString() {
		return "Client [type=" + type + ", name=" + name + ", startTime="
				+ startTime + "]";
	}



	public Client(){
	 Random random = new Random();	
	 this.startTime = System.currentTimeMillis() + random.nextInt(9999999);
	 this.name = UUID.randomUUID().toString();
	 this.type = random.nextInt(3);  // for customer type standard,gold etc
	}
	
	
	
	@Override
	public int compareTo(Delayed o) {
		if(this.startTime < ((Client)o).startTime){
			return -1;
		}
		
		if(this.startTime > ((Client)o).startTime){
			return 1;
		}
	
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		long elapsedTime = startTime-System.currentTimeMillis();
		long delay = MAX_WAIT_TIME - elapsedTime;
		return unit.convert(delay, TimeUnit.MILLISECONDS);
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	
}