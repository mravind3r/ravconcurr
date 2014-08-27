package forkjoin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

import com.google.common.collect.Lists;

import executors.FileContent;

public class WordCountTask  extends RecursiveTask<Integer>{
	static int count;
	List<String> filenames;
	Integer wordCount = new Integer(0);
	public WordCountTask(List<String> filenames){
		this.filenames = filenames;
		
	}

	@Override
	protected Integer compute() {
	    
		if(filenames.size() <=10) {
			for(String s:filenames){
				FileContent content = new FileContent();
				try {
					wordCount+=content.getWords(s);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}else{
			List<List<String>> subLists = Lists.partition(filenames, 10);
			
			List<WordCountTask> tasks = new ArrayList<>();
			for(List<String> s: subLists){
				WordCountTask countTask1 = new WordCountTask(s);
				tasks.add(countTask1);
			}
			 invokeAll(tasks);
			 try {
				for(WordCountTask task:tasks){
					wordCount += task.get();
				}
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		return wordCount;
	}

}
