package qs;

import java.util.Comparator;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Customer implements Delayed{

	private String name;
	private long startTime;
	private int customerType;
	
	public Customer(){
		Random r = new Random();
		name = UUID.randomUUID().toString();
		startTime = System.currentTimeMillis() + r.nextInt(400000); // adding extra buffer
		customerType = r.nextInt(3);
	}
	

	


	@Override
	public String toString() {
		return "Customer [name=" + name + ", startTime=" + startTime
				+ ", customerType=" + customerType + "]";
	}





	public String getName() {
		return name;
	}





	public long getStartTime() {
		return startTime;
	}





	public int getCustomerType() {
		return customerType;
	}





	@Override
	public int compareTo(Delayed o) {
		// used to compare with other obejcts in the queueus
		
		if(this.startTime < ((Customer)o).startTime){
			return -1;
		}
		
		if(this.startTime > ((Customer)o).startTime){
			return 1;
		}
		
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		// this shud be the delay time returned before the object is dropped off
		// if 0 or - values are returned it means this object is ready for collection
		long diff = this.startTime - System.currentTimeMillis();
		
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}




	
	
}
