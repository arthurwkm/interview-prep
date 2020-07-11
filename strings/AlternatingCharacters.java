package strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AlternatingCharacters {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
    	int deletions = 0;
    	StringBuilder string = new StringBuilder();
    	string.append(s);
		for (int i = 0; i < string.length();i++) { 
			if(string.charAt(i)=='A') {
				for (int j = i+1; j < string.length();j++) {
					if(string.charAt(j)=='A') {
						System.out.println("i:"+i+" j:"+j+" deleted char:"+string.charAt(j));
						string.deleteCharAt(j);
						j--;
						deletions++;
					}else {
						System.out.println("i:"+i+" j:"+j+" break at:"+string.charAt(j));
						break;
						
					}
				}
				
			}else {
				for (int j = i+1; j < string.length();j++) {
					if(string.charAt(j)=='B') {
						System.out.println("i:"+i+" j:"+j+" deleted char:"+string.charAt(j));
						string.deleteCharAt(j);
						j--;
						deletions++;
					}else {

						break;
					}
				}
			}
			
		}
		System.out.println(string.toString());

		return deletions;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);
            System.out.println(result);
//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
