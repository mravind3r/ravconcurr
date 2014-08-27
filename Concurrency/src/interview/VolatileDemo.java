package interview;

public class VolatileDemo {
    
	 int x;
	
	 
	 
	public static void main(String[] args) {
		VolatileDemo v = new VolatileDemo();
		VolatileDemo.Task task = new VolatileDemo().new Task(v);
		
		
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		
		t1.start();
		t2.start();

		
		final Thread tx = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (this) {
						System.out.println("calling notify");
						notify();	
					}
					
				}
				
			}
		}); 
		
		tx.start();
		
	}
	
	class Task implements Runnable{

		private int x;
		private VolatileDemo v ;
		
		public Task(VolatileDemo v){
			this.x = v.x;
			this.v = v;
		}
		
		@Override
		public void run() {
		   while(true){
			v.x++;
			try {
				synchronized (this) {
					v.wait();
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    System.out.println("thread name:"+ Thread.currentThread().getName()+ " " + v.x);
		    
			if(v.x==25)
				break;
		   }
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
