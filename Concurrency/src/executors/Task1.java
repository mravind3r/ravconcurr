package executors;

import java.util.Random;
import java.util.concurrent.Callable;

public class Task1 implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		Random r = new Random();
		int x = r.nextInt(1000);
		System.out.println("random number:"+x);
		return x;
	}

}
