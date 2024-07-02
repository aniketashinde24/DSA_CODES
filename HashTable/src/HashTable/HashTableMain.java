package HashTable;

import java.util.LinkedList;
import java.util.Scanner;

class HashTable {
	static class Pair {
		private int key;// key = roll
		private String value;// value = name
		public Pair() {
			key = 0;
			value = "";
		}

		public Pair(int key, String value) {
			this.key = key;
			this.value = value;
		}
		@Override
		public String toString() {
			return "Pair [key=" + key + ", value=" + value + "]";
		}
	}

	private static final int SLOTS = 10;
	private LinkedList<Pair> table[];

	public int hash(int key) {
		return key % SLOTS;
	}

	public HashTable() {
		table = new LinkedList[SLOTS];
		for (int i = 0; i < SLOTS; i++) {
			table[i] = new LinkedList<>();
		}
	}

	public void put(int key, String value) {
		// find slot for given key using hash function
		int slot = hash(key);
		// access the bucket (linked list) in the slot
		LinkedList<Pair> bucket = table[slot];
		// find the element (key-value) in that bucket - liner search
		for (Pair pair : bucket) {
			// if key is duplicated, replace the value
			if (key == pair.key) {
				pair.value = value;
				return;
			}
		}
		// if key not found,return null
		Pair pair = new Pair(key, value);
		bucket.add(pair);
	}

	public String get(int key) {
		// find slot for given key using hash function
		int slot = hash(key);
		// access the bucket (linked list) in the slot
		LinkedList<Pair> bucket = table[slot];
		// find the element (key-value) in that bucket - liner search
		for (Pair pair : bucket) {
			if (key == pair.key)
				return pair.value;
		}
		return null;
	}
}

public class HashTableMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashTable ht = new HashTable();
		ht.put(1, "Aniket");
		ht.put(2, "Ani");
		ht.put(24, "Pranav");
		ht.put(8, "Aadesh");
		ht.put(5, "Sahil");
		ht.put(34, "Arbaaz");
		ht.put(25, "Akash");
		ht.put(1, "sachuu");
		System.out.println("Enter roll to find : ");
		int roll = sc.nextInt();
		String name = ht.get(roll);
		System.out.println("Name found : " + name);
		sc.close();
	}
}
