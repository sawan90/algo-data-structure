import java.util.Scanner;

public class LargestCycle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int m[] = new int[t];
		int visited[] = new int[t];
		int tempmax = 0;
		for (int i = 0; i < t; i++) {
			m[i] = sc.nextInt();
		}
		int max = -1;
		for (int i = 0; i < t; i++) {
			int temp = -1;
			temp = checkCycle(m, t, visited, temp, i);
			if(max < temp){
				max  = temp;
			}
		}
		System.out.println(max+1);

	}

	private static int checkCycle(int[] m, int t, int[] visited, int max,
			int index) {
		int j = -1;
		int temp = index;
		while (true) {
			if (index == -1) {
				break;
			}
			if (m[index] == temp) {
				max++;
				break;
			}
			if (visited[index] == 1) {
				break;
			}
			visited[index] = 1;
			index = m[index];
			if (max == -1) {
				max = 0;
			} else {
				max += 1;
			}
		}
		return max;
	}
}
