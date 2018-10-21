package com.leetcode.zyang;

public class StringSort {

	public StringSort() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Section[] a = new Section[6];
		a[0] = new Section("An", 2);
		a[1] = new Section("Br", 3);
		a[2] = new Section("Da", 3);
		a[3] = new Section("Ga", 4);
		a[4] = new Section("Ha", 1);
		a[5] = new Section("Ja", 3);

		StringSort stringSort = new StringSort();
		
		stringSort.sort(a);
	}
	
	public void sort(Section[] a) {
		int N = a.length;
		int R = 5;
		
		String[] aux = new String[N];
		int[] count = new int[R+1];
		
		//compute frequency counts
		for (int i = 0; i < N; i++)
			count[a[i].key + 1]++;
		
		//transform counts to indices
		for (int r = 0; r < R; r++) 
			count[r+1] += count[r];
		
		//Distribute the records
		for (int i = 0; i < N; i++) 
			aux[count[a[i].key]++] = a[i].name;
				
		return;
	}
	
	static class Section {
		public String name;
		public int key;
		
		public Section(String name, int key) {
			this.name = name;
			this.key = key;
		}
	}
}
