package dictionaries_hashmaps;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
    	class Hashtable{
    		LinkedList[] data;
    		public Hashtable(int length) {
    			data = new LinkedList[length/2];
    		}

    		void put(String key) {
    			int hashcode = key.hashCode();
    			int index = convertoToIndex(hashcode);
    			if (data[index] == null) {
    				data[index] = new LinkedList<Integer>();
    			}
    			LinkedList list = data[index];
    			list.add(key);
    		}
    		
    		boolean get(String key) {
    			int hashcode = key.hashCode();
    			int index = convertoToIndex(hashcode);
    			if(data[index].contains(key)) {
    				return true;
    			}else {
    				return false;
    			}
    		}
    		
    		private int convertoToIndex(int hashcode) {
    			return hashcode%this.data.length;
    		}
    		
    	}
    	
    	Hashtable revista = new Hashtable(magazine.length);
    	for(int i = 0; i < magazine.length; i++) {
    		revista.put(magazine[i]);
    	}
    	for(int i = 0; i < note.length; i++) {
    		if(revista.get(note[i]) == false) {
    			System.out.println("No");
    			return;
    		}
    	}
    	System.out.println("Yes");
    	
    }
    
    


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
