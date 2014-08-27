package basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InterruptingThread {
	
	
	// have a very long list of integers
	// use random to pick a number
	// if the thread has processed this random number that mathes something in the list interrupt the thread
	// eg application :finding if any employees have a salary more than 5000 in that list , we just need a method true or false

	public static void main(String[] args) throws InterruptedException {
		
		List<Integer> list = new ArrayList<>();
		
		for(int i=0;i<1000;i++){
			list.add(i);
		}
		
		ScanList scanList = new InterruptingThread().new ScanList(list);
		scanList.start();
		
		Thread.sleep(2);
		
		scanList.interrupt();
		
		Random r = new Random();
		//System.out.println(r.nextInt(1000));
	}
	
	
	public class ScanList extends Thread {
		
		List<Integer> integers;
		Integer x;
		
		public ScanList(List<Integer> integers){
		   this.integers = integers;	
		}
		
		public void setX(Integer x){
			this.x = x;
		}
		public void run(){
			int i=0;
			while(true){
			System.out.println("processing scan list..." + i++);
			if(isInterrupted()){
				System.out.println("thread interrupted.. ");
				return;
			 }
			}
			
			
			
		}
	}
	
	
}
