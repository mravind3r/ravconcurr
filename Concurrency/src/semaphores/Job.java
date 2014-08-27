package semaphores;

public class Job  implements Runnable{

	Printer printer;
	String printJob;
	public Job(Printer printer,String printJob){
		this.printer = printer;
		this.printJob = printJob;
	}
	
	@Override
	public void run() {
		printer.printJob(printJob);
	}

}
