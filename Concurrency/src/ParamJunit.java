import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;




@RunWith(Parameterized.class)
public class ParamJunit {

	private int i;
	private int j;
	private int k;
	
	public ParamJunit(int i,int j,int k){
		this.i=i;
		this.j=j;
		this.k=k;
	}
	
	
	
	@Parameters
	public static Collection<Object[]> data(){
		Object [][]o = { {2,3,5}, {0,0,0} };
		
		return Arrays.asList(o);
	}
	
	@Test
	public void testsum(){
       Calculator c = new Calculator(i,j);
       Assert.assertEquals(k, c.addition());
  }
	
}
