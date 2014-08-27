package atomic;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

public class BankOpsDepositTask implements Callable<Void> {

	  private BankAccount account;
	  private BigDecimal sum;
	  public BankOpsDepositTask(BankAccount account,BigDecimal sum){
		  this.account = account;
		  this.sum = sum;
	  }
	
	@Override
	public Void call() throws Exception {
		account.deposit(sum);
		return null;
	}

}
