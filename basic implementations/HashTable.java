package basic_implementations;

import java.util.LinkedList;

public class HashTable {
	//hashtable of strings, not of objects 
	//object hashtable would be made with a array of linkedlist of {key, object}
	public static void main(String[] args) {
		

	}
	
	
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
			return Math.abs(hashcode%this.data.length);
		}
		
	}

}
