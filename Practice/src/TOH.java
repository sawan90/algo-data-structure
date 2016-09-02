import java.util.Scanner;


public class TOH {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		toh(n,"A","C","B");
		sc.close();
	}

	private static void toh(int n, String start, String dest, String aud) {
		if(n==1){
			System.out.println(start+"----->"+dest);
		} else{
			toh(n-1, start, aud, dest);
			System.out.println(start+"----->"+dest);
			toh(n-1, aud, dest, start);
		}
		
	}
}
