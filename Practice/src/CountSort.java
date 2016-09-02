import java.util.Scanner;


public class CountSort {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int t = sc.nextInt();
	int m[] = new int[t];
	int count[] = new int[t];
	int tempmax = 0;
	for (int i = 0; i < t; i++) {
		m[i] = sc.nextInt();
		if(m[i] != -1){
			count[m[i]] += 1;
			if(tempmax < count[m[i]]){
				tempmax = count[m[i]];
			}
		}
	}
	System.out.println(tempmax);
	int max= 0;
	for (int i = 0; i < t; i++) {
		if(max < count[i]){
			max = count[i];
		}
	}
	System.out.println(max);
}
}
