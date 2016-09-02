import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MazeMeetingCell {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int m[] = new int[t];
		for (int i = 0; i < t; i++) {
			m[i] = sc.nextInt();
		}
		int start = sc.nextInt();
		int t1 = start;
		int end = sc.nextInt();
		int t2 = end;
		boolean test = true;
		List<Integer> temp = new ArrayList<Integer>();
		temp.add(start);
		boolean done = false;
		while (test) {
			if (t1 == -1 || t2 == -1) {
				break;
			} else if (m[t1] == start || m[t2] == end) {
				break;
			} else if(m[t1] == end || m[t2] == start){
				break;
			}
			t1 = m[t1];
			t2 = m[t2];
			if(temp.contains(t1)){
				System.out.println(t1);
				done =true;
				break;
			} else if(temp.contains(t2)){
				System.out.println(t2);
				done = true;
				break;
			}
			temp.add(t1);
			temp.add(t2);
		}
		if (!done) {
			System.out.println("-1");
		} 		sc.close();
	}
}
