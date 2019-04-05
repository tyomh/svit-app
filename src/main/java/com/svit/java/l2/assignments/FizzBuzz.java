package com.svit.java.l2.assignments;
import java.util.*;
/*
 *  consider a range of positive integers from 1 to a limit. For each value, print either a string
	or the value based on whether the number is a multiple of 3, 5, both or neither. Determine the string to
	return based on the following rules for an integer i:
	If i is a multiple of both 3 and 5, print FizzBuzz.
	If i is a multiple of 3 (but not 5), print Fizz.
	If i is a multiple of 5 (but not 3), print Buzz.
	For all others, print the value of i.
 */
interface Rule {
	boolean apply(int i);
}

class Solution {
	private Set<Rule> rules = new LinkedHashSet<>();
	private Map<Rule, String> ruleContainers = new HashMap<>();
	
	Solution() {
		addRule(i -> i % 15 == 0, "FizzBuzz");
        addRule(i -> i % 3 == 0, "Fizz");
        addRule(i -> i % 5 == 0, "Buzz");
	}
	
	public void addRule(Rule rule, String res) {
		rules.add(rule);
		ruleContainers.put(rule, res);
	}
	
	public String getValue(int i) {
		for (Rule rule: rules) {
			if (rule.apply(i)) {
				return ruleContainers.get(rule);
			}
		}
		return String.valueOf(i);
	}
	
	public List<String> fizzBuzz(int n) {
		List<String> res = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			res.add(getValue(i));
		}
		return res;
	}
}

public class FizzBuzz {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int test = 15;
		List<String> result = solution.fizzBuzz(test);
		for (String res : result) {
			System.out.println(res);
		}
	}
}
