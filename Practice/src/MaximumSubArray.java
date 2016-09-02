import java.util.Scanner;

public class MaximumSubArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int j = 0; j < n; j++) {
				a[j] = sc.nextInt();
			}
			maxSubArray(a);
		}
	}

	private static void maxSubArray(int[] a) {
		int nonContaSoFar = 0;
		int index = -1;
		boolean pos = false;
		int contaMax = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] >= 0) {
				index = i;
				nonContaSoFar = a[i];
				pos = true;
				break;
			}
			if (contaMax < a[i]) {
				contaMax = a[i];
			}
		}
		if (pos) {
			int maxSoFar = a[0];
			int maxEndingHere = a[0];
			for (int i = 1; i < a.length; i++) {
				maxEndingHere = Math.max(a[i], maxEndingHere + a[i]);
				maxSoFar = Math.max(maxEndingHere, maxSoFar);
				if (a[i] > 0 && i != index) {
					nonContaSoFar = nonContaSoFar + a[i];
				}
			}
			System.out.println(maxSoFar + " " + nonContaSoFar);
		} else {
			System.out.println(contaMax + " " + contaMax);
		}
	}
}
