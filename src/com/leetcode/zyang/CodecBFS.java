package com.leetcode.zyang;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zyang
 * 
 * L0297
 * 
 *         Serialization is the process of converting a data structure or object
 *         into a sequence of bits so that it can be stored in a file or memory
 *         buffer, or transmitted across a network connection link to be
 *         reconstructed later in the same or another computer environment.
 * 
 *         Design an algorithm to serialize and deserialize a binary tree. There
 *         is no restriction on how your serialization/deserialization algorithm
 *         should work. You just need to ensure that a binary tree can be
 *         serialized to a string and this string can be deserialized to the
 *         original tree structure.
 * 
 *         For example, you may serialize the following tree
 * 
 *         1 
 *        / \ 
 *        2 3 
 *         / \ 
 *         4 5 
 *         
 *         as "[1,2,3,null,null,4,5]", just the same as how
 *         LeetCode OJ serializes a binary tree. You do not necessarily need to
 *         follow this format, so please be creative and come up with different
 *         approaches yourself.
 *         
 *         Note: Do not use class member/global/static variables to store states. 
 *         Your serialize and deserialize algorithms should be stateless.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class CodecBFS {

	public CodecBFS() {
		// TODO Auto-generated constructor stub
	}

	// BFS, using queue
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {          
        StringBuilder sb = new StringBuilder();
        if (root == null)
        	return sb.toString();
        
        Queue<TreeNode> parent = new LinkedList<TreeNode>();       
        parent.offer(root);        
        while (!parent.isEmpty()) {
        	Queue<TreeNode> child = new LinkedList<TreeNode>();
        	while(!parent.isEmpty()) {
	        	TreeNode node = parent.poll();
	        	if (node == null)
	        		sb.append("null");
	        	else {
	        		sb.append(node.val);		        	
		        	child.offer(node.left);
		        	child.offer(node.right);
	        	}
	        	
	        	sb.append(" ");
        	}
        	
        	parent = child;
        }
        	        	
        return sb.toString().trim();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if (data == null)
    		return null;
    	
        String[] array = data.split(" ");        
        if (array.length == 0 || array[0].equals("null") || array[0].equals(""))
        	return null;
        
        Queue<TreeNode> parent = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.valueOf(array[0])); 
        parent.offer(root);
        int pos = 1;
        while (!parent.isEmpty()) {
        	Queue<TreeNode> child = new LinkedList<TreeNode>();
        	while(!parent.isEmpty()) {
        		TreeNode node = parent.poll();
        		if (node != null) {
	        		if (pos < array.length && !array[pos].equals("null")) 
	        			node.left = new TreeNode(Integer.valueOf(array[pos]));        		
	        		pos++;
	        		
	        		if (pos < array.length && !array[pos].equals("null")) 
	        			node.right = new TreeNode(Integer.valueOf(array[pos]));        		
	        		pos++;
	        		
	        		child.offer(node.left);
	        		child.offer(node.right);
        		}
        	}
        	
        	parent = child;
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));