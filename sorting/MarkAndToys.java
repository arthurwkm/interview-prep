package sorting;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MarkAndToys {

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
    	quickSort(prices);
    	int toys = 0;
    	boolean out = false;
    	for (int i = 0; i < prices.length && !out; i++) {
    		if(prices[i]<k) {
    			k = k - prices[i];
    			toys++;
    		}else {
    			out = true;
    		}
    	}
    	
    	return toys;

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

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
