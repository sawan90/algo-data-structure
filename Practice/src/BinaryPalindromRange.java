import java.util.LinkedHashMap;
import java.util.Map;

public class BinaryPalindromRange {
	public static Map<Long, Long> a = new LinkedHashMap<Long, Long>();

	public static void main(String[] args) {
		long[] b = new long[] { 1l, 2l, 4l, 8l, 16l, 32l, 64l, 128l, 256l,
				512l, 1024l, 2048l, 4096l, 8192l, 16384l, 32768l, 65536l,
				131072l, 262144l, 524288l, 1048576l, 2097152l, 4194304l,
				8388608l, 16777216l, 33554432l, 67108864l, 134217728l,
				268435456l, 536870912l, 1073741824l, 2147483648l, 4294967296l,
				8589934592l, 17179869184l, 34359738368l, 68719476736l,
				137438953472l, 274877906944l, 549755813888l, 1099511627776l,
				2199023255552l, 4398046511104l, 8796093022208l,
				17592186044416l, 35184372088832l, 70368744177664l,
				140737488355328l, 281474976710656l, 562949953421312l,
				1125899906842620l, 2251799813685250l, 4503599627370500l,
				9007199254740990l, 18014398509482000l, 36028797018964000l,
				72057594037927900l, 144115188075856000l, 288230376151712000l,
				576460752303423000l, 1152921504606850000l,
				2305843009213690000l, 4611686018427390000l };

		for (int i = 0; i < b.length; i++) {
			String s = Long.toBinaryString(b[i]);

			if (s.length() % 2l == 0l) {
				a.put(b[i],
						((Math.round(Math.pow(2, ((s.length() / 2l) - 1))))));
			} else {
				a.put(b[i], ((Math.round(Math.pow(2,
						(((s.length() + 1l) / 2) - 1))))));
			}
		}
		for (Long l : a.keySet()) {
			System.out.println(l + " " + a.get(l));
		}

	}
}
