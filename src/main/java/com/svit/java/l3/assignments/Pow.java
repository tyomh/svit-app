package com.svit.java.l3.assignments;
/*
 * Pow(x, n) (m)
	Implement pow(x, n) in iterative(todo) and recursive ways(demo)
 */
class Solution1 {
	public int powInIterative(int base, int index) {
		if (index == 0) {
			return 1;
		}
		
		int ans = 1;
		if (index < 0) {
			ans *= base;
			base = 1 / base;
			index = -(index + 1);
		}
		
		
		while (index != 0) {
			if (index % 2 == 1) {
				ans *= base;
			} 
			base *= base;
			index /= 2;
		}
		return ans;
	}
	
	public int powInRecursive(int base, int index) {
		if (index == 0) {
			return 1;
		}
		
		if (index < 0) {
			base = 1 / base;
			index = -index;
		}
		
		int temp = powInRecursive(base, index / 2);
		if (index % 2 == 0) {			
			return temp * temp;
		} else {
			return temp * temp * base;
		}
	}
}

public class Pow {
	public static void main(String[] args) {
		Solution1 solution = new Solution1();
		int res = solution.powInRecursive(2, 2);
		System.out.println(res);
		
		int r = solution.powInIterative(2, 2);
		System.out.println(r);
	}
}


