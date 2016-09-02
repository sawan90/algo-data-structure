import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SparseArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<String, Integer> stringCount = new HashMap<String, Integer>();
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			stringCount.put(s,
					null != stringCount.get(s) ? stringCount.get(s) + 1 : 1);
		}
		int q = sc.nextInt();
		String[] query = new String[q];
		for (int i = 0; i < q; i++) {
			query[i] = sc.next();
		}
		for (int i = 0; i < q; i++) {
			System.out.println(null != stringCount.get(query[i]) ? stringCount
					.get(query[i]) : 0);
		}
	}
}
