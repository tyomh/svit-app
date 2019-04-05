package com.svit.java.l3.assignments;

/*
 * return the number from int array that is closest to zero. If there are two equally close to zero elements like 2 and -2, consider the positive element
  	to be "closer" to zero. 1. loop through array elements and fetch min diff with 0 2. return the value in that index	
 */

class Solution3 {
	public int closestToZero (int[] A) {
		if (A == null || A.length == 0)
			return -1;
		
		int distance = Integer.MAX_VALUE;
		int res = 0;
		for (int a : A) {
			if (Math.abs(a) == distance && a > 0) {
				res = a;
			} else if (Math.abs(a) < distance) {
				res = a;
				distance = Math.abs(a);
			}
		}
		
		return res;
	}
}

public class ClosestToZero {
	public static void main(String[] args) {
		int[] testCase = new int[] {-1, 1, 2, 3};
		Solution3 solution = new Solution3();
		int res = solution.closestToZero(testCase);
		System.out.println(res);
	}	
}
