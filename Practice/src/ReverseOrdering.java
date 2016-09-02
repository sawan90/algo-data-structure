import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author sawanchoubisa
 *  Comparator
 */
public class ReverseOrdering implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1 - o2;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		int j = 10;
		for (int i = 0; i < 10; i++) {
			list.add(j--);
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(list.get(i));
		}
		Collections.sort(list, new ReverseOrdering());
		for (int i = 0; i < 10; i++) {
			System.out.println(list.get(i));
		}
	}

}
