import java.util.Scanner;


public class MergeSort {
	public static int[] b;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		int[] a = new int[n];
		b = new int[n];
		for(int i=0;i<n;i++){
			a[i] =sc.nextInt();
		}
		mergeSort(a,0,n-1);
		for(int i=0;i<n;i++){
		System.out.println(a[i]);
		}
	}

	private static void mergeSort(int[] a, int i, int j) {
		if(i<j){
			int mid = (i+j)/2;
			mergeSort(a, i, mid);
			mergeSort(a, mid+1, j);
			merge(a,i,mid,j);
		}
		
	}

	private static void merge(int[] a, int low, int mid, int high) {
		int i = low;
		int k = low;
		int j = mid + 1;
		while(i<=mid && j<=high){
			if(a[i]<a[j]){
				b[k] = a[i++];
			} else {
				b[k] = a[j++];
			}
			k++;
		}
		while(i<=mid){
			b[k++] = a[i++];
		}
		while(j<=high){
			b[k++] = a[j++];
		}
		for(i=low;i<=k-1;i++){
			a[i] = b[i];
		}
		
	}
}
