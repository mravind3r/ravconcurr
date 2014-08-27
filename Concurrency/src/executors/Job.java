package executors;

import java.io.IOException;
import java.util.List;

public class Job implements Runnable {
		List<String> fileList;
		
		
		public Job(List<String> fileList){
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