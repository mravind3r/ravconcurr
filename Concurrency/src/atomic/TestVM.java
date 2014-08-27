package atomic;

import java.lang.management.ManagementFactory;
import java.util.List;

public class TestVM {

	public static void main(String args[]) {
	    List<String> inputArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();
	    System.out.println("input arguments = " + inputArguments);
	}
}
