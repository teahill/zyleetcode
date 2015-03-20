package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeSerializer {

	public BinaryTreeSerializer() {
		// TODO Auto-generated constructor stub
	}
	
	//Pre-Order
	public static List<String> serialize(TreeNode root) {
		List<String> list = new ArrayList<String>();
		
		serializeRecursively(root, list);
		
		return list;
	}
	
	public static void serializeRecursively(TreeNode node, List<String> strs) {
		if (node == null) {
			strs.add("#");
			return;
		}
		
		strs.add(String.valueOf(node.val));
		
		serializeRecursively(node.left, strs);
		serializeRecursively(node.right, strs);
		
	}
	
	
	// Pre-Order
	public static TreeNode deserialize(List<String> strs) {
		if (strs == null || strs.isEmpty())			
			return null;
		
		Pair pair = deserializeRecursively(strs, 0);
		
		return pair.node;
	}
	
	private static Pair deserializeRecursively(List<String> strs, int startIndex) {
		if (startIndex >= strs.size())
			return new Pair (null, startIndex + 1);
		
		String str = strs.get(startIndex);
		
		if ( str == "#") {
			return new Pair (null, startIndex + 1);
		}
		
		TreeNode node = new TreeNode(Integer.valueOf(str));
		Pair pairLeft = deserializeRecursively(strs, startIndex + 1);
		if (node != null)
			node.left = pairLeft.node;
		
		Pair pairRight = deserializeRecursively(strs, pairLeft.startIndex);
		if (node != null)
			node.right = pairRight.node;
		
		return new Pair(node, pairRight.startIndex);
	}
	
	
	private static final class Pair {
		TreeNode node;
		int startIndex;
		
		private Pair (TreeNode node, int index) {
			this.node = node;
			this.startIndex = index;
		}
	}

}
