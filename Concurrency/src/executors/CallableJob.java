package executors;

import java.util.List;
import java.util.concurrent.Callable;

public class CallableJob implements Callable<Integer> {

	List<String> filenames ;
	public CallableJob(List<String> filenames){ 
		this.filenames = filenames;
	}
	
	@Override
	public Integer call() throws Exception {
		
		Integer count = new Integer(0);
		for(String filename:filenames){
			FileContent content = new FileContent();
           count +=content.getWords(filename); 		
		}
		
		return count;
	}

	
	
}
