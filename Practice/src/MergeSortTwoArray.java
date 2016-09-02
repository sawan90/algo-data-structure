public class MergeSortTwoArray {

	public static void main(String[] args) {
		Integer[] arr = new Integer[] { 3, 41, 52, 26, 38, 57, 9, 49 };
		MergeSortTwoArray mergeSortTwoArray = new MergeSortTwoArray();
		mergeSortTwoArray.mergeSort(arr, 0, arr.length - 1);
		/*for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}*/
	}

	private void mergeSort(Integer[] arr, int i, int j) {
		if (i < j) {
			int m = (i + j) / 2;
			mergeSort(arr, i, m);
			mergeSort(arr, m + 1, j);
			merge(arr, i, m, j);
		}

	}

	private void merge(Integer[] arr, int i, int m, int j) {
		
		int n1 = (m - i) + 1;
		int n2 = j - m ;
		System.out.println(n1 + " " + n2);
		//System.out.println(arr.length);
		System.out.println(i + " "+ m + " "+ j);
		int[] temp1 = new int[n1];
		int[] temp2 = new int[n2];
		for (int p = 0; p < n1; p++) {
			temp1[p] = arr[p];
		}
		for (int q = 0; q < n2; q++) {
			temp2[q] = arr[q + m ];
		}
		System.out.println(temp1.length + " " + temp2.length + " "+ i+ " "+ j);
		int l = 0;
		int k = 0;
		for (int n = i; n < j; n++) {
			System.out.println(l+ " "+k);
			if (temp1[l] <= temp2[k]) {
				//System.out.println(l+ " "+k);
				arr[n] = temp1[l];
				l = l +1;
			} else {
				//System.out.println(l+ " "+k);
				arr[n] = temp2[k];
				k = k +1;
			}
			//System.out.println(arr[n]);
		}

	}
}
