package com.svit.java.l2.assignments;
/*
 * Reverse a linked list.
	Example
	For linked list 1->2->3, the reversed linked list is 3->2->1
 */

import java.util.*;

class Node{
	int val;
	Node next;
	Node(int val) {
		this.val = val;
	}
}

class Solution4 {
	public Node reverse(Node head) {
		Node h = head;
		Node prev = null;
		while (h != null) {
			Node temp = h.next;
			h.next = prev;
			prev = h;
			h = temp;
		}
		
		return prev;
	}
}

public class ReverseLinkedList {
	public static void main(String[] args) {
		Node n1 = new Node(0);
		Node n2 = new Node(1);
		Node n3 = new Node(2);
		Node n4 = new Node(3);
		Node n5 = new Node(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		Solution4 solution = new Solution4();
		Node reversedHead = solution.reverse(n1);
		while (reversedHead != null) {
			System.out.println(reversedHead.val);
			reversedHead = reversedHead.next;
		}
	}
}

