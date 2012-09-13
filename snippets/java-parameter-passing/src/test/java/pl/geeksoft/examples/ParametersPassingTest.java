package pl.geeksoft.examples;

import static java.lang.System.identityHashCode;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ParametersPassingTest {

	@Test
	public void testSwapPrimitives() {
		int a, b;
		swap(a = 10, b = 20);
		printPrimitiveValues("Outside swap", a, b);
		// Check values
		assertEquals(10, a);
		assertEquals(20, b);
	}

	@Test
	public void testSwapObjects() {
		String a, b;
		swap(a = "foo", b = "bar");
		printObjectValues("Outside swap", a, b);
		printObjectHashCodes("Outside swap", a, b);
		// Check values
		assertEquals("foo", a);
		assertEquals("bar", b);
	}

	private void swap(int a, int b) {
		printPrimitiveValues("Before swap", a, b);
		int t = a; a = b; b = t;
		printPrimitiveValues("After swap", a, b);
	}

	private void swap(String a, String b) {
		printObjectValues("Before swap", a, b);
		printObjectHashCodes("Before swap", a, b);
		String t = a; a = b; b = t;
		printObjectValues("After swap", a, b);
		printObjectHashCodes("After swap", a, b);
	}

	private void printPrimitiveValues(String message, int a, int b) {
		System.out.println(message + " [a = " + a + "; b = " + b + "]");
	}

	private void printObjectValues(String message, Object a, Object b) {
		System.out.println(message + " [a = " + a + "; b = " + b + "]");
	}

	private void printObjectHashCodes(String message, Object a, Object b) {
		System.out.println(message + " [a.hashCode = " + identityHashCode(a) + "; b.hashCode = " + identityHashCode(b) + "]");
	}

}
