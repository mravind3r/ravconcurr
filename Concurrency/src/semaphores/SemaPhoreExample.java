package semaphores;

public class SemaPhoreExample {

	public static void main(String[] args) {
		
		Thread[] t = new Thread[10];
		Printer printer = new Printer();
		for(int i=0;i<t.length;i++){
			Job job = new Job(printer, "job-" + i);
			t[i] = new Thread(job);
		}
		
		for(int i=0;i<t.length;i++){
			t[i].start();
		}
		
		
	}
	
	
}
