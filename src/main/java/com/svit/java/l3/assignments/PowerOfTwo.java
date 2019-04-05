package com.svit.java.l3.assignments;

// Given an integer, write a function to determine if it is a power of two.

class Solution4 {
	public boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;
        
        if (n == 1)
            return true;
        
        if (n % 2 != 0) {
            return false;
        } else {
            return isPowerOfTwo(n / 2);
        }
    }
}

public class PowerOfTwo {
	public static void main(String[] args) {
		Solution4 solution = new Solution4(); 
		int[] testCase = new int[] {0, 1, 2, 3};
		for (int testcase : testCase) {
			System.out.println(solution.isPowerOfTwo(testcase));
		}
	}
}
