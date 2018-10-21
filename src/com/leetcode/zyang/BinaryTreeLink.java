package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLink {

	public BinaryTreeLink() {
		// TODO Auto-generated constructor stub
	}

	public static List<String> serialize(TreeLinkNode root) {
		List<String> list = new ArrayList<String>();
		
		serializeRecursively(root, list);
		
		return list;
	}
	
	public static void serializeRecursively(TreeLinkNode node, List<String> strs) {
		if (node == null) {
			strs.add("#");
			return;
		}
		
		strs.add(String.valueOf(node.val));
		
		serializeRecursively(node.left, strs);
		serializeRecursively(node.right, strs);
		
	}
	
	
	public static List<String> printLinks(TreeLinkNode root) {
		List<String> list = new ArrayList<String>();
		if (root == null)
			return list;			
		
		while (root != null) {
			TreeLinkNode hNode = root;
			root = null;
			StringBuilder sb = new StringBuilder();
			while (hNode != null) {
				if (root == null && hNode.left != null)
					root = hNode.left;
				
				if (root == null && hNode.right != null)
					root = hNode.right;
				
				sb.append(hNode.val);
				sb.append(",");
				hNode = hNode.next;
			}
			
			list.add(sb.toString());
		}
		
		return list;
	}
	
	// Pre-Order
	public static TreeLinkNode deserialize(List<String> strs) {
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
		
		TreeLinkNode node = new TreeLinkNode(Integer.valueOf(str));
		Pair pairLeft = deserializeRecursively(strs, startIndex + 1);
		if (node != null)
			node.left = pairLeft.node;
		
		Pair pairRight = deserializeRecursively(strs, pairLeft.startIndex);
		if (node != null)
			node.right = pairRight.node;
		
		return new Pair(node, pairRight.startIndex);
	}
	
	private static final class Pair {
		TreeLinkNode node;
		int startIndex;
		
		private Pair (TreeLinkNode node, int index) {
			this.node = node;
			this.startIndex = index;
		}
	}
}
