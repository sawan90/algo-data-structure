import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author sawanchoubisa
 * Divisiblity by 7
 */
public class Practice {
	public static void main(String[] args) {
		Practice pc = new Practice();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			String number = br.readLine();
			System.out.println(number);
			int question = Integer.parseInt(br.readLine());
			int[][] indices = new int[question][question];
			int i = 0;
			while (i < question) {
				String tempArr[] = new String[2];
				String s = br.readLine();
				tempArr = s.split(" ");
				System.out.println(tempArr[0]);
				System.out.println(tempArr[1]);
				indices[i][0] = Integer.valueOf(tempArr[0]);
				indices[i++][1] = Integer.valueOf(tempArr[1]);
				br.read();
			}
			for (i = 0; i < question; i++) {
				System.out.println(indices[i][0] + " " + indices[i][1]);
			}
			try {
				pc.checkDivisiblity(number, indices, question);
			} catch (Throwable t) {
				System.out.println(t.getMessage());
				t.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void checkDivisiblity(String number, int[][] indices, int question) {
		Practice pc = new Practice();
		for (int i = 0; i < question; i++) {
			pc.checkDivision(number.substring(indices[i][0] - 1, indices[i][1]));
		}

	}

	private void checkDivision(String num) {
		Integer i = Integer.valueOf(num);
		System.out.println(i % 7 == 0 ? "YES" : "NO");
	}

}
