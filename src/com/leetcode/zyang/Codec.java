package com.leetcode.zyang;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

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
public class Codec {
	private static final String splitter = ",";
	private static final String nullChar = "#";

	// DFS, pre-order
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) { 
    	StringBuilder sb = new StringBuilder();
        StringBuilder result = serialize(root, sb);
        
        return result.toString();
    }

    private StringBuilder serialize(TreeNode root, StringBuilder sb) {        
        if (root == null) {
        	//sb.append("#,");
        	sb.append(nullChar).append(splitter);
        	return sb;
        }
         
        sb.append(root.val);
        sb.append(splitter);
        StringBuilder str1 = serialize(root.left, sb);
        StringBuilder str2 = serialize(root.right, str1);
        
        return str2;	
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if (data == null)
    		return null;
    	
        String[] array = data.split(splitter);
        Deque<String> deque = new LinkedList<String>();
        deque.addAll(Arrays.asList(array));
        
        return deserialize(deque);
    }
    
    private TreeNode deserialize(Deque<String> deque) {
    	if (deque.isEmpty())
    		return null;
    	
    	String str = deque.pollFirst();
    	if (str.equals(nullChar)) 
    		return null;

    	TreeNode node = new TreeNode(Integer.valueOf(str));
    	node.left = deserialize(deque);
    	node.right = deserialize(deque);

    	return node;	        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
