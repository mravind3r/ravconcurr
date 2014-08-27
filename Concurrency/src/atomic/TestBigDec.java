package atomic;

import java.math.BigDecimal;

public class TestBigDec {

	public static void main(String[] args) {
		BigDecimal b = new BigDecimal(10);
		System.out.println(b);
		b = b.add(new BigDecimal(10));
		System.out.println(b);
	}
}
