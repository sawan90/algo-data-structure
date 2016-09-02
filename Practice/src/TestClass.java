import java.util.Scanner;

public class TestClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < test; i++) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			sc.nextLine();
			int []a = new int[n]; 
			for(int j=0;j<n;j++){
				a[j] = sc.nextInt(); 
			}
			checkEquality(a,x,y,z);
		}
	}

	private static void checkEquality(int[] a, int x, int y, int z) {
		long lcm = lcm(a);
		boolean sheCan = true;
		for(int i=0;i<a.length;i++){
			if(!lcmEquality(a[i], x, y, z, lcm)){
				System.out.println("She can't");
				sheCan = false;
				break;
			}
		}
		if(sheCan){
			System.out.println("She can");
		}
		
	}
	
	
	private static boolean lcmEquality(int i, int x, int y, int z, long lcm) {
	int m = (int) lcm / i;
	return true;
	}

	private static long lcm(long a, long b)
	{
	    return a * (b / gcd(a, b));
	}

	private static long lcm(int[] input)
	{
	    long result = input[0];
	    for(int i = 1; i < input.length; i++) result = lcm(result, input[i]);
	    return result;
	}
	
	private static long gcd(long a, long b)
	{
	    while (b > 0)
	    {
	        long temp = b;
	        b = a % b; // % is remainder
	        a = temp;
	    }
	    return a;
	}

}
