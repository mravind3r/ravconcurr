package atomic;

public class TestSynchCounter {

	
	public static void main(String[] args) throws InterruptedException {
		final SynchCounter c = new SynchCounter();
		
		Thread[] t1 = new Thread[100];
		
		for(int i=0;i<t1.length;i++){
			t1[i] = new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int i=0;i<1000;i++)
					   c.increment();
					
				}
			});
		}
		
		long t0 = System.currentTimeMillis();
		
		
		for(int i=0;i<t1.length;i++){
			t1[i].start();
		}
		
		
		
		for(int i=0;i<t1.length;i++){
			t1[i].join();
		}
		
		
		
		long t01 = System.currentTimeMillis();
		
		
		System.out.println("time taken:"+ (t01-t0));
		
		c.printCount();
 
	}
	
	
}
