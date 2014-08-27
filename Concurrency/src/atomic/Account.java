package atomic;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

public class Account {

	private AtomicReference<BigDecimal> ref = null;
	
	
	public Account(Integer i){
		ref = new AtomicReference<BigDecimal>(new BigDecimal(i));
	}


	public void addBal(BigDecimal bigDecimal) {
		for(;;){
			BigDecimal oldVal = ref.get();
			if(ref.compareAndSet(oldVal, oldVal.add(bigDecimal)))
				return;
		}
		
	}


	public void printBal() {
		System.out.println(ref.get());
	}
	
	
	
	
	
}
