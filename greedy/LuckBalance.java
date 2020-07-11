package greedy;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LuckBalance {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
    	int[] importants = new int [contests.length];
    	int luck = 0;
    	for(int i = 0; i < contests.length; i++) {
    		if(contests[i][1] == 1) {
    			importants[i] = contests[i][0]; 
    		}else if (contests[i][1] == 0) {
    			luck += contests[i][0];
    		}
    	}
    	Arrays.sort(importants);
    	int i = 0;
    	for(i = importants.length-1; i >= 0 && k!=0; i--) {
    		if(k>0) {
    			luck+=importants[i];
    			k--;
    		}
    		System.out.println(i);
    	}
//    	System.out.println(k);
    	System.out.println(i);
//    	for(int j = 0; j < importants.length; j++) {
//    		System.out.print(importants[j] + " ");
//    	}
    	for(i = i; i >= 0; i--) {
    		luck-=importants[i];
    	}
    	
    	return luck;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
