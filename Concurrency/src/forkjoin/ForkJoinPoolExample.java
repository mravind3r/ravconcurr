package forkjoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

import executors.FileContent;

public class ForkJoinPoolExample {

	// example of a recursive task  cos we need a return value
	
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		FileContent fileContent = new FileContent();
		List<String> origFileList = fileContent.getFileList("/home/ravi/data");
		WordCountTask wordCountTask = new WordCountTask(origFileList);
		System.out.println(forkJoinPool.invoke(wordCountTask));
		forkJoinPool.shutdown();
	}
	
}
