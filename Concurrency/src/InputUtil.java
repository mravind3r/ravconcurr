import java.util.regex.Pattern;


public class InputUtil {

	private String input;
	private String regex;
	
     
	
	public InputUtil(String input,String regex) {
		this.input = input;
		this.regex = regex;
	}
	
	
	
	public String[] getSplits() {
	    Pattern p = Pattern.compile(regex);
	    return p.split(input);
	}

	
	
	
}
