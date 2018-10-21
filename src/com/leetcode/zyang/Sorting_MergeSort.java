package com.leetcode.zyang;

public class Sorting_MergeSort {

	private int[] aux;
	
	public void  mergeSort(int[] nums) {
		if (nums == null || nums.length < 2)
			return;
		
		aux = new int[nums.length];	// allocate space just once
		sort(nums, 0, nums.length - 1);
		
		return;
	}
	
	private void sort(int[] nums, int low, int high) {
		if (nums == null || nums.length < 2 || low >= high)
			return;
		
		int mid = low + (high - low) / 2;
		sort(nums, low, mid);
		sort(nums, mid + 1, high);
		merge(nums, low, mid, high);
		
		return;
	}
	
	private void merge(int[] nums, int low, int mid, int high) {
		if (nums == null)
			return;
		
		for (int i = low; i <= high; i++) 
			aux[i] = nums[i];

		int left = low;
		int right = mid + 1;
		for (int i = low; i <= high; i++) {
			if (left > mid) 
				nums[i] = aux[right++];
			else if (right > high) 
				nums[i] = aux[left++];
			else if (aux[left] <= aux[right]) 
				nums[i] = aux[left++];
			else 
				nums[i] = aux[right++];
		}
		
		return;
	}
}
