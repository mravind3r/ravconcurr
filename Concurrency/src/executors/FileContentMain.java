package executors;

import java.io.IOException;
import java.util.List;

public class FileContentMain {

	public static void main(String[] args) throws IOException {
		
		long t1 = System.currentTimeMillis();
		FileContent fileContent = new FileContent();
		
		List<String> filenames = fileContent.getFileList("/home/ravi/data");
		
		
		for(String s:filenames){
		System.out.println(s+ " = " + 
				fileContent.getWords(s));
		}	
		long t2 = System.currentTimeMillis();
		
		System.out.println("total time taken =" + (t2-t1));
		
	}
	
}
