package atomic;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

public class BankAccount {

	
	
	private AtomicReference<BigDecimal> balance;
	
	public BankAccount(){
		this.balance =  new AtomicReference<BigDecimal>(new BigDecimal(0));
	}
	
	
	public  void deposit(BigDecimal val){
		
		for(;;){
			BigDecimal oldval = balance.get();
			if(balance.compareAndSet(oldval,oldval.add(val))){
				return;
			}
		}
		
		
	}
	
	public void withDraw(BigDecimal val){
		
		for(;;){
			BigDecimal oldVal = this.balance.get();
			if(this.balance.compareAndSet(oldVal, oldVal.add(val))){
				return;
			}
		}
	}


	public BigDecimal getBalance() {
		return this.balance.get();
	}


	
	
	
	
}
