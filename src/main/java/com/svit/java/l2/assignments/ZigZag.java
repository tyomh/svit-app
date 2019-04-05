package com.svit.java.l2.assignments;
/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
	P   A   H   N
	A P L S I I G
	Y   I   R
	And then read line by line: "PAHNAPLSIIGYIR"
	Write the code that will take a string and make this conversion given a number of rows:
	string convert(string text, int nRows);
	convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */

class Solution2 {
	public String convert(String s, int nRows) {
	    char[] c = s.toCharArray();
	    int len = c.length;
	    String[] sb = new String[nRows];
	    for (int i = 0; i < sb.length; i++) sb[i] = "";
	    
	    int i = 0;
	    while (i < len) {
	        for (int idx = 0; idx < nRows && i < len; idx++) 
	            sb[idx] += (c[i++]);
	        for (int idx = nRows-2; idx >= 1 && i < len; idx--)
	            sb[idx] += (c[i++]);
	    }
	    for (int idx = 1; idx < sb.length; idx++)
	        sb[0] += (sb[idx]);
	    return sb[0];
	}
}

public class ZigZag {
	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		String test = "PAYPALISHIRING";
		String res = solution.convert(test, 3);
		System.out.println(res);
	}
}
