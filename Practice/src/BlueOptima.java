import java.util.Date;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.concurrent.ConcurrentSkipListMap;

public class BlueOptima {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		long[] numbers = new long[t];
		for (int i = 0; i < t; i++) {
			numbers[i] = sc.nextLong();

		}
		NavigableMap<Long, Long> map = new ConcurrentSkipListMap<Long, Long>();
		for (int i = 0; i < t; i++) {
			findNthMagicalNumber(numbers[i], map);
		}
		sc.close();
	}

	private static void findNthMagicalNumber(long nextLong,
			NavigableMap<Long, Long> map) {
		Entry<Long, Long> x = map.floorEntry(nextLong);
		long tempNextLong = nextLong;
		long l = 1l;
		if (null != x && !x.getKey().equals(1l)) {
			if(x.getKey().equals(nextLong)){
				System.out.println(x.getValue());
				return;
			}
			l = x.getValue() + 1;
			tempNextLong -= x.getKey();
		}
		String s = "1";
		while (tempNextLong > 0) {
			s = getBinary(l);
				
			if (isPalindrome(s)) {
				map.put(tempNextLong, l);
				tempNextLong--;
			}
			
			/*if(isPal(l)){
				//map.put(tempNextLong, l);
				s = String.valueOf(l);
				tempNextLong--;
			}*/
			
			l++;
			
		}
		Long result = Long.parseLong(s, 2);
		System.out.println(result);
		map.put(nextLong, Long.valueOf(result));
	}

	public static boolean isPal(Long orig) {
		Long copy = orig;
		Long reversed = 0l;
		Long start = System.currentTimeMillis();
		while (copy != 0) {
			reversed <<= 1;
			reversed |= (copy & 1);
			copy >>>= 1;
		}
		System.out.println(orig +" afterTime "+(System.currentTimeMillis()- start));
		return (reversed == orig);
	}
	
	
	private static String getBinary(long num) {
		StringBuilder s = new StringBuilder();
		while (num != 0) {
			long d = num % 2;
			s.append(d);
			num /= 2;
		}

		return s.reverse().toString();
	}

	static boolean isPalindrome(String s) {
		int n = s.length();
		for (int i = 0; i < (n / 2); ++i) {
			if (s.charAt(i) != s.charAt(n - i - 1)) {
				return false;
			}
		}

		return true;
	}
	
}
