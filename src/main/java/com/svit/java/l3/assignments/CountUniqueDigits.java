package com.svit.java.l3.assignments;

// Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10^n.

class Solution2 {
	public int uniqueDigits(int digits) {
		if (digits == 1) {
			return 10;
		}
		
		int sum = 10;
		int temp = 9;
		digits = Math.min(10, digits);
		for (int i = 1; i < digits; i++) {
			temp *= 10 - i;
			sum += temp;
		}
		
		return sum;
	}
}

public class CountUniqueDigits {
	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		System.out.println(solution.uniqueDigits(2));
	}
}
