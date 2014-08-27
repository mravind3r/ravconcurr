package atomic;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class BankAccountTest {

	@Test
	public void testDeposit() {
		BankAccount bankAccount = new BankAccount();
		bankAccount.deposit(new BigDecimal(100));
		assertEquals(10, bankAccount.getBalance().intValue());
	}

	@Test
	public void testWithDraw() {
	//	fail("Not yet implemented");
	}

}
