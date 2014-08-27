package atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {

	private AtomicInteger count = new AtomicInteger();
	
	public void incr(){
		count.getAndIncrement();
	}
	
	public void print(){
		System.out.println("value of count:"+count);
	}
	
}
