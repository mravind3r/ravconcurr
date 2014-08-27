package basics;

public class ThreadGrpEx {
	
	
	public static void main(String[] args) {
		
		ThreadGroup threadGroup = new ThreadGroup("rav");
		
		Thread[] t = new Thread[10];
		for(int i=0;i<t.length;i++){
			Task task = new ThreadGrpEx().new Task();
			Thread t1 = new Thread(threadGroup,task);
			t[i] = t1;
		}
		
		for(int i=0;i<t.length;i++){
			t[i].start();
		}
		
		threadGroup.interrupt();
		
	}
	
	

	public class Task implements  Runnable {
		public void run() {
			while(true){
				System.out.println(Thread.currentThread().getName() +" is nunning ...");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
}
