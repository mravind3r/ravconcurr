package executors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class FileContent {

	
	public HashMap<String,Integer> getWordCount(String filename) throws IOException	{
		HashMap<String,Integer> hashMap = new HashMap<>();
		BufferedReader bufferedReader = null;
		try{
		FileInputStream fis = new FileInputStream(new File(filename));
		bufferedReader = new BufferedReader(new InputStreamReader(fis));
		String content = null;
		while(  (content = bufferedReader.readLine())!=null){
			StringTokenizer str = new StringTokenizer(content," ");
			
	        while(str.hasMoreTokens()){
	        	String token = str.nextToken();
	        	Integer value;
	        	if( (value = hashMap.get(token))!=null){
	        		hashMap.put(token, (value + 1));
	        	}else{
	        		hashMap.put(token,new Integer(1));
	        	}
	        }
			
		}
		
		}finally{
			bufferedReader.close();
		}
		return hashMap;
	}
	
	
	public Integer getWords(String filename) throws IOException	{
		BufferedReader bufferedReader = null;
		Integer wordCount = new Integer(0);
		try{
		FileInputStream fis = new FileInputStream(new File(filename));
		bufferedReader = new BufferedReader(new InputStreamReader(fis));
		String content = null;
		
		while(  (content = bufferedReader.readLine())!=null){
			StringTokenizer str = new StringTokenizer(content," ");
			while(str.hasMoreTokens()){
				str.nextToken();
				wordCount++;
			}
	   	
		}
		
		}finally{
			bufferedReader.close();
		}
		return wordCount;
	}
	
	
	public List<String> getFileList(String folderName){
		List<String> fileList = new ArrayList<>();
		File file = new File(folderName); 
		for(File f:file.listFiles()){
	       fileList.add(f.getAbsolutePath());		
		}
		return fileList;
	}
	
	
	
	
}
