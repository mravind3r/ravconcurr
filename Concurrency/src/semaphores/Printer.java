package semaphores;

import java.util.concurrent.Semaphore;

public class Printer {

	private final Semaphore semaphore = new Semaphore(1,true);
	
	
	public void printJob(String job){
		try {
			semaphore.acquire();
			System.out.println("printing .." + job);
			System.out.println("finishing .." + job);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			semaphore.release();
		}
		
	}
	
}
