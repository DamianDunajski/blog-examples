package pl.geeksoft.examples;

public class Basic {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		for (int i = 0; i < 100 * 1000 * 1000; i++) {
			calculate();
		}

		long end = System.currentTimeMillis();
		System.out.println("Execution time: " + (end - start) + " milliseconds");
	}

	public static void calculate() {
		int a, b, c;
		a = 1;
		b = 2;
	}

}
