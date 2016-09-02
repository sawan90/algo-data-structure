import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author sawanchoubisa
 * 
 *         A series is defined in the following manner:
 * 
 *         Given the nth and (n+1)th terms, the (n+2)th can be computed by the
 *         following relation Tn+2 = (Tn+1)2 + Tn
 * 
 *         So, if the first two terms of the series are 0 and 1: the third term
 *         = 12 + 0 = 1 fourth term = 12 + 1 = 2 fifth term = 22 + 1 = 5 ... And
 *         so on.
 * 
 *         Given three integers A, B and N, such that the first two terms of the
 *         series (1st and 2nd terms) are A and B respectively, compute the Nth
 *         term of the series.
 * 
 *         Input Format
 * 
 *         You are given three space separated integers A, B and N on one line.
 * 
 *         Input Constraints 0 <= A,B <= 2 3 <= N <= 20
 * 
 *         Output Format
 * 
 *         One integer. This integer is the Nth term of the given series when
 *         the first two terms are A and B respectively.
 * 
 *         Note
 * 
 *         Some output may even exceed the range of 64 bit integer.
 * 
 *
 */
public class Solution {
	public static BigInteger[] table;
	public static int a;
	public static int b;
	public static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		n = sc.nextInt();
		table = new BigInteger[n];
		for (int i = 0; i < n; i++) {
			table[i] = BigInteger.ZERO;
		}
		table[0] = new BigInteger(String.valueOf(a));
		table[1] = new BigInteger(String.valueOf(b));
		System.out.println(fab());
		sc.close();
	}

	private static BigInteger fab() {
		int i = 2;
		while (i < n) {
			if (table[i].equals(BigInteger.ZERO)) {
				table[i] = (table[i - 1].multiply(table[i - 1])
						.add(table[i - 2]));
			}
			i++;
		}

		return table[n - 1];
	}
}
