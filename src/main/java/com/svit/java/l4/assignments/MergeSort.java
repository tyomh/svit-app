package com.svit.java.l4.assignments;

public class MergeSort {
	public void merge(int[] a, int l, int m, int r) {
		int len1 = m - l + 1;
		int len2 = r - m;
		
		int[] A1 = new int[len1];
		int[] A2 = new int[len2];
		
		for (int i = 0; i < len1; i++) {
			A1[i] = a[l + i];
		}
		
		for (int j = 0; j < len2; j++) {
			A2[j] = a[m + 1 + j];
		}
		
		int i = 0, j = 0, k = l;
		
		while (i < len1 && j < len2) {
			if (A1[i] <= A2[j]) {
				a[k++] = A1[i++];
			} else {
				a[k++] = A2[j++];
			}
		}
		
		while (i < len1) {
			a[k++] = A1[i++];
		}
		
		while (j < len2) {
			a[k++] = A2[j++];
		}
	}
	
	public void sort(int[] a, int l, int r) {
		if (l < r) {
			int mid = (l + r) / 2;
			sort(a, l, mid);
			sort(a, mid + 1, r);
			merge(a, l, mid, r);
		}
	}
	
	public static void main(String[] args) {
		int[] test = new int[] {5,4,3,2,1};
		
		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(test, 0, test.length - 1);
		for (int i : test) {
			System.out.println(i);
		}
	}
}
