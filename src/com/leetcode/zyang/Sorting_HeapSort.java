package com.leetcode.zyang;

public class Sorting_HeapSort {
	private int[] heap;
	private int size = 0;
	
	public void heapSort(int[] nums) {
		if (nums == null || nums.length < 2)
			return;
		
		buildHeap(nums);
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = getMin();
			deleteMin();
		}
		
		return;		
	}
	
	public int getMin() {
		return heap[1];		
	}

	public int getSize() {
		return size;		
	}
	
	private void deleteMin() {
		if (size < 1)
			return;
		
		if (size > 1) {
			heap[1] = heap[size];
			size--;
			sink();
		}
	}
	
	public void buildHeap(int[] nums) {
		if (nums == null || nums.length < 2)
			return;
		
		heap = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			heap[i + 1] = nums[i];
			size++;
			swim(i+1);
		}
	}
	
	private void swim(int pos) {
		if (pos < 1 || pos > size) 
			return;
		
		int i = pos;
		while ( i > 1 && heap[i/2] > heap[i]) {
			swap(i, i/2);
			i = i/2;
		}
	}

	private void swap(int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	
	private void sink() {
		int parent = 1;
		
		int leftChild = 2*parent;
		int rightChild = 2*parent + 1;
		while (leftChild <= size) {
			if (rightChild <= size) {
				int small = (heap[leftChild] < heap[rightChild]) ? leftChild : rightChild;
				
				if (heap[parent] < heap[small]) 
					break;
				
				swap(parent, small);
				parent = small;					
			}
			else {
				if (heap[parent] < heap[leftChild]) 
					break;
				
				swap(parent, leftChild);
				parent = leftChild;
			}
			
			leftChild = 2*parent;
			rightChild = 2*parent + 1;
		}
	}
}
