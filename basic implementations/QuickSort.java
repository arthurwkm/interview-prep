package basic_implementations;

public class QuickSort {
	
	public static void main(String[] args) {
		int[] a = {10, 5, 11, 3, 2, 1, 4};
		quickSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	private static int[] quickSort(int[] a) {
		quicksort(a, 0, a.length-1);
		return null;
	}

	private static void quicksort(int[] a, int left, int right) {
		if(left>=right) {
			return;
		}
		int pivot = a[(left+right)/2];
		int index = partition(a,left,right,pivot);
		quicksort(a,left,index-1);
		quicksort(a,index,right);
	}

	private static int partition(int[] a, int left, int right, int pivot) {
		while(left<=right) {
			while(a[left]<pivot) {
				left++;
			}
			while(a[right]>pivot) {
				right--;
			}
			if(left<=right) {
				swap(a,left,right);
				left++;
				right--;
			}
		}
		return left;
	}

	private static void swap(int[] a, int left, int right) {
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
		
	}
	
	
	
	
}
