public class FibonacciDP {
	int[] fib;

	public int fibDP(int x) {
		int fib[] = new int[x + 1];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i < x + 1; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[x];
	}

	public int fibTopDown(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		if (fib[n] != 0) {
			return fib[n];
		} else {
			fib[n] = fibTopDown(n - 1) + fibTopDown(n - 2);
			return fib[n];
		}
	}

}
