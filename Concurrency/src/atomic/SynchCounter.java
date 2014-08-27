package atomic;

public class SynchCounter {

	private int count;
	
	
	public synchronized void  increment(){
		count++;
	}
	
	public void printCount(){
		System.out.println("value of counter="+count);
	}
	
	
}
