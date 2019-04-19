package com.svit.java.l7;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}

public class BinaryTreeLevelOrderTraversal{
    public static void main(String[] args){
    	TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node4.left = node7;
        
        System.out.println(levelOrder(node1));
        System.out.println(eachLevelOrder(node1));
        System.out.println(BottomUpLevelOrder(node1));
        System.out.println(ZigzagLevelOrder(node1));
    }   
	
    /**
     * BFS: return all levels together in one print
     * @param root
     * @return
     */
	public static ArrayList<Integer> levelOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        
        //using Queue to store tree nodes
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        TreeNode curNode = null;
 
        while (!queue.isEmpty()) {
            curNode = queue.poll();
             
            result.add(curNode.val);
 
            if (curNode.left != null)
                queue.add(curNode.left);
            if (curNode.right != null)
                queue.add(curNode.right);
        }
        
        return result;        
    }
	
	/**
	 * level by level print
	 * @param root
	 * @return
	 */
    public static List<List<Integer>> eachLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root == null) return result;
        
        //using Queue to store tree nodes
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        TreeNode curNode = null;
        
        ArrayList<Integer> curLevelNodes = new ArrayList<Integer>();
        int currentLevelCount = 1;
        int nextLevelCount = 0;
        
        while(!queue.isEmpty()) {
            curNode = queue.poll();
            currentLevelCount --;
            
            curLevelNodes.add(curNode.val);
            
            if (curNode.left != null) {
                queue.add(curNode.left);
                nextLevelCount++;
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
                nextLevelCount++;
            }
            //reset next level
            if (currentLevelCount == 0){
                currentLevelCount = nextLevelCount;
                nextLevelCount = 0;
                //remember to use clone to avoid clear() function in next statement
                result.add((ArrayList<Integer>)curLevelNodes.clone());
                curLevelNodes.clear();
            }
        }
        return result;
    }
    
	/**
	 * bottom-up level order print
	 * @param root
	 * @return
	 */
    public static List<List<Integer>> BottomUpLevelOrder(TreeNode root) {
    	// to be finished
    	LinkedList<List<Integer>> res = new LinkedList<>();
    	if (root == null) {
    		return res;
    	}
    	
    	Queue<TreeNode> queue = new LinkedList<>();
    	List<Integer> curList = new LinkedList<>();
    	queue.add(root);
    	int curNode = 1;
    	int nextNode = 0;
    	
    	while (!queue.isEmpty()) {
    		TreeNode cur = queue.poll();
    		curNode--;
    		curList.add(cur.val);
    		if (cur.left != null) {
    			queue.add(cur.left);
    			nextNode++;
    		}
    		
    		if (cur.right != null) {
    			queue.add(cur.right);
    			nextNode++;
    		}
    		
    		if (curNode == 0) {
    			curNode = nextNode;
    			nextNode = 0;
    			res.addFirst(new LinkedList<>(curList));
    			curList.clear();
    		}
    	}
    	
    	return res;

    }
    
    
    
	/**
	 * Zigzag Level order print (ie, from left to right, then right to left for the next level and alternate between).
	 * @param root
	 * @return
	 */
    public static List<List<Integer>> ZigzagLevelOrder(TreeNode root) {
    	// to be finished
    	if (root == null)
    		return null;
    	
    	List<List<Integer>> res = new LinkedList<>();
    	
    	Queue<TreeNode> queue = new LinkedList<>();
    	LinkedList<Integer> curList = new LinkedList<>();
    	queue.add(root);
    	boolean leftToRight = true;
    	int curLevel = 1;
    	int nextLevel = 0;

    	while (!queue.isEmpty()) {
    		TreeNode cur = queue.poll();
    		curLevel--;
    		if (leftToRight) {
    			curList.add(cur.val);
    		} else {
    			curList.addFirst(cur.val);
    		}
    		if (cur.left != null) {
    			queue.add(cur.left);
    			nextLevel++;
    		}
    		
    		if (cur.right != null) {
    			queue.add(cur.right);
    			nextLevel++;
    		}
    		
    		if (curLevel == 0) {
    			curLevel = nextLevel;
    			nextLevel = 0;
    			res.add(new LinkedList<>(curList));
    			curList.clear();
    			leftToRight = leftToRight ? false : true;
    		}
    	}
    	
    	return res;
    }
    
}
