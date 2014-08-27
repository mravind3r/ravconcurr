package executors;


import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.google.common.collect.Lists;

public class CountWordsUsingExecutorPool {
	
	public static void main(String[] args) {
		
		
    	int cores = Runtime.getRuntime().availableProcessors();
		FileContent fileContent = new FileContent();
		List<String> origFileList = fileContent.getFileList("/home/ravi/data");
        List<List<String>> subLists = Lists.partition(origFileList, cores*2);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) 
        		Executors.newFixedThreadPool(cores*2);
        for(List<String> l:subLists){
        	Job task = new Job(l);
        	executor.execute(task);
        	
        }
        
        
        executor.shutdown();
     
	}

}
