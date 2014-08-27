package executors;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import com.google.common.collect.Lists;

public class ExecutorsForCallableJob {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int cores = Runtime.getRuntime().availableProcessors();
		FileContent fileContent = new FileContent();
		List<String> origFileList = fileContent.getFileList("/home/ravi/data");
        List<List<String>> subLists = Lists.partition(origFileList, cores*2);
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		List<Future<Integer>> futures  = new ArrayList<>();
		List<CallableJob> callableJobs = new ArrayList<>();
        for(List<String> l:subLists){
        	CallableJob callableJob = new CallableJob(l);
        	//futures.add(executor.submit(callableJob));
        	callableJobs.add(callableJob);
        	
        	
        }
        
        futures = executor.invokeAll(callableJobs);
        
        
        Integer totalWordcount = new Integer(0);
        for(Future<Integer> f: futures){
        	totalWordcount += f.get();
        }
        
        
        System.out.println("total word count :" + totalWordcount);
        executor.shutdown();
	}
	
	
}
