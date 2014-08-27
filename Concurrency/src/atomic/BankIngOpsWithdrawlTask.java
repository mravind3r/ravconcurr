package atomic;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

public class BankIngOpsWithdrawlTask implements Callable<Void>{

	 private BankAccount account;
	  private BigDecimal sum;
	  public BankIngOpsWithdrawlTask(BankAccount account,BigDecimal sum){
		  this.account = account;
		  this.sum = sum;
	  }
	
	@Override
	public Void call() throws Exception {
		account.withDraw(sum);
		return null;
	}


}
