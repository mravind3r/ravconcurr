package atomic;

public class TestSynch {
	
	
	public static void main(String[] args) {
		final SynchClass synchClass = new SynchClass();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				synchClass.synchMethod();
				//synchClass.anothersynchMethod();
				
			}
		});
		
Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				//synchClass.synchMethod();
				//synchClass.anothersynchMethod();
				synchClass.waitMethod();
			
			
			}
		});

   t1.start();
   t2.start();
 
		
	}

}
