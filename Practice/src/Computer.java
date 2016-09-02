import java.util.Scanner;

public class Computer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int computer = sc.nextInt();
		int link = sc.nextInt();
		int[] count = new int[computer + 1];
		for (int i = 1; i <= link; i++) {
			int vertex1 = sc.nextInt();
			int vertex2 = sc.nextInt();
			count[vertex1]++;
			count[vertex2]++;
		}
		boolean safe = true;
		for (int i = 1; i <= computer; i++) {
			if (count[i] < computer - 1) {
				safe = false;
			}
		}
		System.out.println(safe ? "Safe" : "Unsafe");
		sc.close();
	}

}
