package com.svit.java.l2.assignments;
/*
 * Merge two given sorted integer array A and B into a new sorted integer array.
	Example
	A=[1,2,3,4]
	B=[2,4,5,6]
	return [1,2,2,3,4,4,5,6]
 */

import java.util.*;

class Solution5 {
	public int[] merge(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;
		
		int[] res = new int[m + n];
		int cur = 0, i = 0, j = 0;
		
		while (i < m && j < n) {
			if (a[i] <= b[j]) {
				
				res[cur++] = a[i++];
			} else {
				res[cur++] = b[j++];
			}
		}
		
		while (i < m) {
			res[cur++] = a[i++];
		}
		
		while (j < n) {
			res[cur++] = b[j++];
		}

		return res;
	}
}

public class MergeSortedList {
	public static void main(String[] args) {
		int[] A = new int[]{1, 2, 3, 4};
		int[] B = new int[]{2, 4, 5, 6};
		
		Solution5 solution = new Solution5();
		int[] res = solution.merge(A, B);
		for (int r : res) {
			System.out.println(r);
		}
	}
}
