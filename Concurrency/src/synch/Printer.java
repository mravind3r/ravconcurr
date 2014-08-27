package synch;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Printer {
		
		private final Lock renLock =  new ReentrantLock();
		
		public Printer(){
			
		}

		
		public   void  printJob(String jobName) {
			   renLock.lock(); // locks from here non
			    try{
				System.out.println(" printing " + jobName);
				Thread.sleep(100);
				System.out.println(" finishing  " + jobName);
			    } catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					
					
			     	renLock.unlock();
			    }
            
		}
		
		
		public void justFluf(){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
