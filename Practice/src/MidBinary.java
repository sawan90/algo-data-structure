
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.concurrent.ConcurrentSkipListMap;

public class MidBinary {
	public static void main(String[] args) {

		NavigableMap<Long, Long> map = new ConcurrentSkipListMap<Long, Long>();
		map.put(1l, 1l);
		map.put(2l, 2l);
		map.put(4l, 4l);
		map.put(6l, 8l);
		map.put(10l, 16l);
		map.put(14l, 32l);
		map.put(22l, 64l);
		map.put(30l, 128l);
		map.put(46l, 256l);
		map.put(62l, 512l);
		map.put(94l, 1024l);
		map.put(126l, 2048l);
		map.put(190l, 4096l);
		map.put(254l, 8192l);
		map.put(382l, 16384l);
		map.put(510l, 32768l);
		map.put(766l, 65536l);
		map.put(1022l, 131072l);
		map.put(1534l, 262144l);
		map.put(2046l, 524288l);
		map.put(3070l, 1048576l);
		map.put(4094l, 2097152l);
		map.put(6142l, 4194304l);
		map.put(8190l, 8388608l);
		map.put(12286l, 16777216l);
		map.put(16382l, 33554432l);
		map.put(24574l, 67108864l);
		map.put(32766l, 134217728l);
		map.put(49150l, 268435456l);
		map.put(65534l, 536870912l);
		map.put(98302l, 1073741824l);
		map.put(131070l, 2147483648l);
		map.put(196606l, 4294967296l);
		map.put(262142l, 8589934592l);
		map.put(393214l, 17179869184l);
		map.put(524286l, 34359738368l);
		map.put(786430l, 68719476736l);
		map.put(1048574l, 137438953472l);
		map.put(1572862l, 274877906944l);
		map.put(2097150l, 549755813888l);
		map.put(3145726l, 1099511627776l);
		map.put(4194302l, 2199023255552l);
		map.put(6291454l, 4398046511104l);
		map.put(8388606l, 8796093022208l);
		map.put(12582910l, 17592186044416l);
		map.put(16777214l, 35184372088832l);
		map.put(25165822l, 70368744177664l);
		map.put(33554430l, 140737488355328l);
		map.put(50331646l, 281474976710656l);
		map.put(67108862l, 562949953421312l);
		map.put(83886078l, 1125899906842620l);
		map.put(117440510l, 2251799813685250l);
		map.put(184549374l, 4503599627370500l);
		map.put(251658238l, 9007199254740990l);
		map.put(385875966l, 18014398509482000l);
		map.put(520093694l, 36028797018964000l);
		map.put(654311422l, 72057594037927900l);
		map.put(922746878l, 144115188075856000l);
		map.put(1459617790l, 288230376151712000l);
		map.put(1996488702l, 576460752303423000l);
		map.put(3070230526l, 1152921504606850000l);
		map.put(4143972350l, 2305843009213690000l);
		map.put(6291455998l, 4611686018427390000l);

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		long[] numbers = new long[t];
		for (int i = 0; i < t; i++) {
			numbers[i] = sc.nextLong();

		}
		for (int i = 0; i < t; i++) {
			if (numbers[i] == 1) {
				System.out.println(1);
			} else {
				long current = System.currentTimeMillis();
				findNthMagicalNumber(numbers[i], map);
				System.out.println("TIME:"
						+ (System.currentTimeMillis() - current));
			}
		}
		sc.close();

	}

	private static void findNthMagicalNumber(long nextLong,
			NavigableMap<Long, Long> map) {
		Entry<Long, Long> x;
		if (map.containsKey(nextLong)) {
			x = map.floorEntry(nextLong - 1);
		} else {
			x = map.floorEntry(nextLong);
		}
		Entry<Long, Long> y;

		y = map.ceilingEntry(nextLong);
		long l = y.getValue() + 1;
		String s = "1";
		String output = "1";
		long counter = x.getKey();
		System.out.println(l);
		System.out.println(counter);
		long time = System.currentTimeMillis();
		while (counter < nextLong) {
			s = getBinary(l);

			if (isPalindrome(s)) {
				output = s;
				System.out.println("Counter:"+counter);
				counter++;
				
			}
			
			/*if(isBinaryPalindrome(l)){
				s = String.valueOf(l);
				counter++;
			}*/
			l += 2;

		}
		Long result = Long.parseLong(output, 2);
		System.out.println(result);
	}

	private static String getBinary(long num) {

		return Long.toBinaryString(num);
		/*
		 * StringBuilder s = new StringBuilder(); while (num != 0) { long d =
		 * num % 2; s.append(d); num /= 2; }
		 * 
		 * return s.toString();
		 */
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

	public static  boolean isBinaryPalindrome ( long num ){
		  long numOfBits = (long) (Math.floor( ( Math.log( num )/Math.log(2)) ) + 1);
		  long left = 0;
		  long right = numOfBits - 1; 
		  while( left < right ){
		    if( isBitSet( num, numOfBits - left ) != isBitSet( num, numOfBits-right )  ) {
		      return false;
		    }
		    left++;
		    right--;
		    
		  }
		  return true;
		}

		private static boolean isBitSet( long num, long index ){
		  return ( num & (1 << (index - 1 ) ) ) != 0;
		}
	
}
