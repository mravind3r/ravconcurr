package atomic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;


public class TestBankAccount {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		BankAccount b1 = new BankAccount();
		BankAccount b2 = new BankAccount();
		BankOpsDepositTask dep = new BankOpsDepositTask(b1, new BigDecimal(10));

		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		
		List<Callable<Void>> calls = new ArrayList<>();
		for(int i=0;i<20;i++){
			calls.add(dep);
		}
		
		List<Future<Void>> futures = executor.invokeAll(calls);
		
		// to make sure that the threads join
		for(Future<Void> f :futures){
			f.get();
		}
		
		System.out.println("balance :" + b1.getBalance());
		executor.shutdown();
		
	}
	
	
	
	
	
	
	
}
