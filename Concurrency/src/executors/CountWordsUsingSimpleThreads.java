package executors;

import java.io.IOException;
import java.util.List;

import com.google.common.collect.Lists;



public class CountWordsUsingSimpleThreads {

	public static void main(String[] args) throws InterruptedException {
	     long t1 = System.currentTimeMillis();	
		int cores = Runtime.getRuntime().availableProcessors();
		FileContent fileContent = new FileContent();
		List<String> origFileList = fileContent.getFileList("/home/ravi/data");
        List<List<String>> subLists = Lists.partition(origFileList, cores*2);
        for(List<String> l : subLists){
        	Task t = new CountWordsUsingSimpleThreads().new Task(l);
        	Thread tr = new Thread(t);
        	tr.start();
        }
        
        
        long t2 = System.currentTimeMillis();
        System.out.println("total time taken =" + (t2-t1));
        
		
	}
	
	
	
	public class Task implements Runnable {
		List<String> fileList;
		public Task(List<String> fileList){
			this.fileList = fileList;
		}
		
		@Override
		public void run() {
			FileContent fileContent = new FileContent();
			for(String filename:fileList){
				try {
					System.out.println(filename+ " = " + 
							fileContent.getWords(filename));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	
	
}
