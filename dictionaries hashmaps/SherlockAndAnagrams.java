package dictionaries_hashmaps;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockAndAnagrams {

	// Complete the sherlockAndAnagrams function below.
	static int sherlockAndAnagrams(String s) {
		class Hashtable{
            LinkedList[] data;
            public Hashtable(int length) {
                data = new LinkedList[length*2];
            }

            void put(String key) {
                int hashcode = this.hashFunction(key);
                int index = convertoToIndex(hashcode);
                if (data[index] == null) {
                    data[index] = new LinkedList<Integer>();
                }
                LinkedList list = data[index];
                list.add(key);
            }

            int hashFunction(String key) {
                int hash = 0;
                for(int i = 0; i < key.length(); i++) {
                    hash = hash + key.charAt(i)*31;
                }
                return hash;


            }

            private int convertoToIndex(int hashcode) {
                return Math.abs(hashcode%this.data.length);
            }
            
            int countAnagrams(LinkedList list, String substring){
                int anagrams = 0;
                int count2[] = new int[26]; 
                int count1[] = new int[26]; 
                for (int j = 0; j < list.size(); j++) {
                    String substring2 = ((String) list.get(j));
                    
                    Arrays.fill(count1, 0); 
                    Arrays.fill(count2, 0); 
                    if (substring.length() == substring2.length()) {
                        for (int i = 0; i < substring.length();i++) { 
                            count1[(substring.charAt(i)-19)%26]++; 
                            count2[(substring2.charAt(i)-19)%26]++; 
                        } 

//                        System.out.println("substring original:" + substring);
//                        for (int i = 0; i < 26;i++) {
//                            System.out.print(count1[i]+" ");
//                        }
//                        System.out.println();
//                        System.out.println("possível anagrama:" + substring2);
//                        for (int i = 0; i < 26;i++) {
//                        
//                            System.out.print(count2[i] + " ");
//                        }
                        boolean equals = true;
                        for (int i = 0; i < 26;i++){
                            if(count1[i]!=count2[i]){
                                equals = false;
                                break;
                            }
                        }
                        //System.out.println();
                        if(equals) {
                            anagrams++;
                        }
                    }
                }
                return anagrams;
            }

            public int numberOfAnagrams(String substring) {
                int hashcode = this.hashFunction(substring);
                int index = convertoToIndex(hashcode);
                if(!data[index].isEmpty() && data[index].contains(substring)) {
                    //remove itself
                    //count the n of anagrams in the list
                    LinkedList list = data[index];
                    list.removeFirstOccurrence(substring);
                    int anagrams = countAnagrams(list, substring);
                    
                    return anagrams;
                }else {
                    return 0;
                }
            }
        }

        Hashtable substrings = new Hashtable(s.length());
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length()+1; j++) {
                //System.out.println(s.substring(i, j));
                substrings.put(s.substring(i, j));
            }
        }
        int anagrams = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length()+1; j++) {
                if(i!=j){
                anagrams = anagrams + substrings.numberOfAnagrams(s.substring(i, j));
            }
            }
        }




        return anagrams;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			int result = sherlockAndAnagrams(s);
			System.out.println(result);
//			bufferedWriter.write(String.valueOf(result));
//			bufferedWriter.newLine();
		}

		//bufferedWriter.close();

		scanner.close();
	}
}
