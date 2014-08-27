import java.util.regex.Pattern;


public class RegexProject {
	
	public static void main(String[] args) {
		
	    String REGEX = ","; 	
		String s1 = "101,Ravi,2000,5,India";
		Pattern p = Pattern.compile(REGEX);
		
		String s[] = p.split(s1);
		
		for(String sp:s){
			System.out.println(sp);
		}
		
		
		
	}
	

}
