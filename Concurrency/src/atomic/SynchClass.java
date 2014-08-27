package atomic;

public class SynchClass {

	
	public void nonsynch(){
		System.out.println("public void nonsynch()....");
		System.out.println(" exiting .. public void nonsynch()...");
	}
	
	
	public synchronized void synchMethod(){
		System.out.println("calling .. synchronized void synchMethod()");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(" exiting .. synchronized void synchMethod()..");
	}
	
	
	public synchronized void anothersynchMethod(){
			
		
		System.out.println("calling .. synchronized void anotersynchMethod()");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(" exiting .. synchronized void anothersynchMethod()..");
		
	}
	
	
	public void synchWithBlock(){
		Object x = new Object();
		synchronized (x) {
			System.out.println("calling .. synchronized with block.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			System.out.println(" exiting .. synchronized with block..");
		}
	}
	
	
	public static synchronized void classSynchMethod(){
		System.out.println("calling .. static synchronized void classSynchMethod().");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(" exiting .. static synchronized void classSynchMethod()");
	}

	
	
	public static  void classMethod(){
		System.out.println("calling .. static  void classMethod().");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(" exiting .. static void classMethod()");
	}

	
	public synchronized void waitMethod(){
		System.out.println("entering wait method..");
		try {
			this.wait();
			System.out.println("notify method being called...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("exiting wait method");
	}
	
	
	
}
