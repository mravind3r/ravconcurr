import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class TestInputUtil {
	
	private String input;
	private String regexPattern;
	private int arrayLenght;
	
	
 public TestInputUtil(String input,String regexPattern,int arrayLength){
	 this.input = input;
	 this.regexPattern = regexPattern;
	 this.arrayLenght = arrayLength;
 }
	
	
  @Parameters
  public static Collection<Object[]> testData(){
	  Object [][] data = { {"1,ravi,2000,5,India",",",5}, {"1,ravi,2000,5",",",4}};
	  return Arrays.asList(data);
  }	
	

	@Test
	public void test_splits_length(){
		InputUtil ip = new InputUtil(this.input,this.regexPattern);
		Assert.assertEquals(this.arrayLenght, ip.getSplits().length);
		
	}
	
	
}
