package basic_implementations;

public class BubbleSort {

	public static void main(String[] args) {
		int[] a = {10, 5, 11, 3, 2, 1, 4};
		a = bubbleSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static int[] bubbleSort(int[] arr){
		for (int i = 0; i < arr.length; i++) {   
		    for (int j = 0; j < arr.length - 1; j++) {
		        if (arr[j] > arr[j + 1]) {
		            int temp = arr[j];
		            arr[j] = arr[j+1];
		            arr[j+1] = temp;
		        }
		    }
		    
		}
		
		return arr;
	}
	

}
