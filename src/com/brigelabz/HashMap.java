package com.brigelabz;

public class HashMap {
	String key;
	int value;
	MyMapNode next;

	public HashMap(String key, int value) {
	     this.key = key;
	     this.value = value;
	     next = null;
	 }
}

class MyHashMap {
	private int size;
	private HashMap[] bucket;

	public MyHashMap() {
		size = 10;
		bucket = new HashMap[size];
	}

	private int getHash(String key) {
		return Math.abs(key.hashCode()) % size;
	}

	public void put(String key, int value) {
		int index = getHash(key);
		HashMap newNode = new HashMap(key, value);
		if (bucket[index] == null) {
			bucket[index] = newNode;
		} else {
			HashMap curr = bucket[index];
			while (curr.next != null) {
				if (curr.key.equals(key)) {
					curr.value = value;
					return;
				}
				curr = curr.next;
			}
			curr.next = newNode;
		}
	}
	public Integer get(String key) {
		int index = getHash(key);
		if (bucket[index] != null) {
			HashMap curr = bucket[index];
			while (curr != null) {
				if (curr.key.equals(key)) {
					return curr.value;
				}
				curr = curr.next;
			}
		}
		return null;
	}

	public int findFrequency(String sentence, String word) {
		String[] words = sentence.split(" ");
		int wordCount = 0;
		for (String w : words) {
			if (w.equals(word)) {
				wordCount++;
			}
		}
		return wordCount;
	}
}

public class HashTable {
	public static void main(String[] args) {
		MyHashMap hashMap = new MyHashMap();

		hashMap.put("To", 1);
		hashMap.put("be", 2);
		hashMap.put("or", 3);
		hashMap.put("not", 4);

		String sentence = "To be or not to be";
		String[] words = sentence.split(" ");
		for (String word : words) {
			int frequency = hashMap.findFrequency(sentence, word);
			System.out.println("The frequency of '" + word + "' in the sentence is: " + frequency);
		}
	}
}
