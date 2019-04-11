package com.svit.java.l4.assignments;

public class QuickSort {
	public int partition(int[] a, int l, int r) {
		int pivot = a[r];
		int i = l - 1;
		for (int j = l; j < r; j++) {
			if (a[j] <= pivot) {
				i++;
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		
		int temp = a[i+1]; 
        a[i+1] = a[r]; 
        a[r] = temp; 
        
        return i + 1;
		
	}
	
	public void sort(int[] a, int l, int r) {
		if (l < r) {
			int pivot = partition(a, l, r);
			sort(a, l, pivot - 1);
			sort(a, pivot + 1, r);
		}
	}
	
	public static void main(String[] args) {
		int[] test = new int[] {5,4,3,2,1};
		QuickSort quicksort = new QuickSort();
		quicksort.sort(test, 0, test.length - 1);
		
		for (int i : test) {
			System.out.println(i);
		}
	}
}
