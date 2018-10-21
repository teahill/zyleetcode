package com.leetcode.zyang;

public class Sorting_QuickSort {

	public void quickSort(int[] nums) {
		if (nums == null || nums.length < 2)
			return;
		
		sort(nums, 0, nums.length - 1);
		
		return;
	}
	
	private void sort(int[] nums, int low, int high) {
		if (nums == null || low >= high)
			return;
		
		int pos = partition(nums, low, high);
		sort(nums, low, pos - 1);
		sort(nums, pos + 1, high);
		
		return;
	}
	
	private int partition1(int nums[], int low, int high) {
		int pivot = nums[low];
		
		int left = low + 1;
		int right = high;
		while (left < right) {
			if (nums[left] <= pivot) {
				left++;
				continue;
			}
			if (nums[left] > pivot) {
				while (left < right && nums[right] > pivot) 
					right--;
				
				if (left == right)
					break;
				
				//swap
				swap(nums, left, right);
				left++;
				right--;				
			}			
		}
			
		int pos = (nums[left] <= pivot) ? left : left - 1;
		swap(nums, low, pos);
		
		return pos;
	}
	
	private int partition(int nums[], int low, int high) {
		int pivot = nums[low];
		
		int left = low;
		int right = high + 1;
		
		while (true) {
			while (nums[++left] <= pivot)
				if(left == high)
					break;
			while (nums[--right] > pivot)
				if(right == low)
					break;
			
			if (left >= right)
				break;			
			
			swap(nums, left, right);
		}
		
		swap(nums, low, right);
		
		return right;
	}
	
	private void swap(int[] nums, int p1, int p2) {
		if (nums == null || p1 < 0 || p1 > (nums.length - 1)
			|| p2 < 0 || p2 > (nums.length - 1))
			return;
		
		int temp = nums[p1];
		nums[p1] = nums[p2];
		nums[p2] = temp;
		
		return;		
	}
}
