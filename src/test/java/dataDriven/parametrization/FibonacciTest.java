package dataDriven.parametrization;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FibonacciTest {

	public FibonacciTest(int input, int expected) {
		fInput = input;
		fExpected = expected;
	}

	@Parameters(name = "{index}: fib[{0}]={1}")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 } });
	}

	private int fInput;

	private int fExpected;

	@Test
	public void testFibonacci() {
		Fibonacci f = new Fibonacci();
		assertEquals(fExpected, Fibonacci.compute(fInput));

	}

}
