package com.svit.java.l3.assignments;

class Solution5 {
	public int sqrt1(int x) {
		if (x < 0)
			return -1;
		
		if (x == 0 || x == 1)
			return x;
		
		int left = 1, right = x;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (mid * mid <= x) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		return left - 1;
	}
	
	public double sqrt2(int x) {
		if (x < 0)
			return -1;
		
		if( x == 0 || x == 1){
            return x;
        }
        
        double left = 1.0;
        double right = x;
        if (x < 1){
            left = x;
            right = 1.0;
        }
        double err = 1e-10;
        while (left <= right){
            double mid = left + (right - left) / 2;
            double multiple = x/mid;
            if (multiple == mid || Math.abs(multiple - mid) <= err){
                return mid;
            }
            if (multiple > mid){
                left = mid;
            }else{
                right = mid;
            }
        }
        
        return left;
	}
}
public class Sqrt {
	public static void main(String[] args) {
		Solution5 solution = new Solution5();
		System.out.println(solution.sqrt1(4));
		System.out.println(solution.sqrt2(5));
	}
}
