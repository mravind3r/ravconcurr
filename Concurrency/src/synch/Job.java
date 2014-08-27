package synch;
public class Job implements Runnable{

		private Printer printer ;
		String jobName;
		public Job(Printer printer,String jobName){
			this.printer = printer;
			this.jobName = jobName;
		}
		@Override
		public void run() {
			
			  
				   printer.printJob(jobName);
			       printer.justFluf(); 
					
			}
			
			
		}
		
	