
/**
 * @author sawanchoubisa
 * Comparable
 */
public class NaturalCompare implements Comparable<NaturalCompare> {
	public int a;

	public static void main(String[] args) {
		NaturalCompare  nc1 = new NaturalCompare();
		NaturalCompare  nc2 = new NaturalCompare();
		nc1.a = 15;
		nc2.a = 10;
		System.out.println(nc1.compareTo(nc2) > 0? "nc2": "nc1");
	}

	@Override
	public int compareTo(NaturalCompare o) {
		return o.a - a;
	}
}
