import java.util.Scanner;

/**
 * @author sawanchoubisa
 * 
 *         Given an array of elements, find the maximum possible sum of a
 * 
 *         Contiguous subarray Non-contiguous (not necessarily contiguous)
 *         subarray. Input Format
 * 
 *         First line of the input has an integer . cases follow. Each test case
 *         begins with an integer . In the next line, integers follow
 *         representing the elements of array .
 * 
 *         Constraints:
 * 
 *         The subarray and subsequences you consider should have at least one
 *         element.
 * 
 *         Output Format
 * 
 *         Two, space separated, integers denoting the maximum contiguous and
 *         non-contiguous subarray. At least one integer should be selected and
 *         put into the subarrays (this may be required in cases where all
 *         elements are negative).
 * 
 */
public class SumArray {
	public static int t;
	public static int n;
	public static int[] arr;
	public static int[][] csum;
	public static int[][] ucsum;
	public static int[] size;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		sc.nextLine();
		ucsum = new int[t][1];
		size = new int[t];
		csum = new int[t][];
		for (int i = 0; i < t; i++) {
			n = sc.nextInt();
			size[i] = n;
			sc.nextLine();
			arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			getSum(i);
		}
		for (int i = 0; i < t; i++) {
			int cs = -99999999;
			int ucs = -99999999;
			for (int j = 0; j < size[i]; j++) {
				if (csum[i][j] > cs) {
					cs = csum[i][j];
				}
			}
			if (cs != -99999999) {
				System.out.print(cs + " ");
			}
			if(ucsum[i][0] != -99999999){
				System.out.println(ucsum[i][0]);
			}
		}
		sc.close();
	}

	private static void getSum(int i) {
		csum[i] = new int[arr.length];
		ucsum[i][0] = -99999999;
		csum[i][0] = arr[0];
		if (arr[0] > 0) {
			ucsum[i][0] = arr[0];
		}
		for (int j = 1; j < arr.length; j++) {
			csum[i][j] += arr[j] + csum[i][j - 1];
			if (arr[j] > 0) {
				ucsum[i][0] += arr[j];
			}

		}

	}
}
