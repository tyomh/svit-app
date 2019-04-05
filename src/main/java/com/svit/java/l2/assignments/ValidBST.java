package com.svit.java.l2.assignments;
/*
 * Valid Binary Search Trees  
	Given a binary tree, determine if it is a valid binary search tree (BST).
	Assume a BST is defined as follows:
	•	The left subtree of a node contains only nodes with keys less than the node's key.
	•	The right subtree of a node contains only nodes with keys greater than the node's key.
	•	Both the left and right subtrees must also be binary search trees.
 */

import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Solution3 {
	public boolean isValidBST(TreeNode root) {
		return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	private boolean helper(TreeNode root, long min, long max) {
		if (root == null)
            return true;
        if (root.val >= max || root.val <= min)
            return false;
        
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
	}
}

/*
 *      5
 *    1   4
 *      3   6
 */

public class ValidBST {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(4);
		TreeNode t4 = new TreeNode(3);
		TreeNode t5 = new TreeNode(6);
		
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t3.right = t5;
		
		Solution3 valid = new Solution3();
		System.out.println(valid.isValidBST(t1));
	}
}
