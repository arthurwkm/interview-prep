package strings;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockValidString {

	// Complete the isValid function below.
	static String isValid(String s) {
		int alphabetCount[] = new int[26]; 
		int arr[] = new int[26];
		Arrays.fill(alphabetCount, 0); 
		for (int i = 0; i < s.length();i++) { 
			alphabetCount[(s.charAt(i)-19)%26]++;
			arr[(s.charAt(i)-19)%26]++;
		}

		for (int i = 0; i < s.length();i++) {
			System.out.print(alphabetCount[i]+" ");
		}
		
		Arrays.parallelSort(arr);
		System.out.println();
		
		for (int i = 0; i < arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
		int max_count = 1, res = arr[0]; 
		int curr_count = 1; 

		for (int i = 1; i < arr.length; i++) 
		{ 
			if(arr[i]!=0) {
				if (arr[i] == arr[i - 1]) 
					curr_count++; 
				else 
				{ 
					if (curr_count > max_count) 
					{ 
						max_count = curr_count; 
						res = arr[i - 1]; 
					} 
					curr_count = 1; 
				} 
			}
		} 
		
		if (curr_count > max_count) 
        { 
            max_count = curr_count; 
            res = arr[arr.length - 1]; 
        } 
		
		boolean exception = false;
		boolean valid = true;
		for (int i = 0; i < 26;i++) {
			if(alphabetCount[i]== res || alphabetCount[i] == 0) {
				System.out.println(alphabetCount[i]);
			}else {	
				if(alphabetCount[i]!= res && exception == false) {
					if(alphabetCount[i]== res +1 || alphabetCount[i]== 1) {
						exception = true;
					}else {
						valid = false;
						break;
					}
				}else {
					valid = false;
					break;
				}
			}
		}
		if(valid) {
			return "YES";
		}else {
			return "NO";
		}

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		
		String s = scanner.nextLine();

		String result = isValid(s);

		System.out.println(result);
		scanner.close();
	}
}
