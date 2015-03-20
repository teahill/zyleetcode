package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author zyang
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 *   1
 *    \
 *     2
 *    /
 *   3
 * return [1,3,2].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 *
 *
 */
public class L0094_BinaryTreeInOrderTraversal {

	public L0094_BinaryTreeInOrderTraversal() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		L0094_BinaryTreeInOrderTraversal inOrderTraversal = new L0094_BinaryTreeInOrderTraversal();
		
		List<String> strs = new ArrayList<String>();		
		strs.add("1");
		strs.add("#");
		strs.add("2");
		strs.add("3");
		strs.add("#");
		strs.add("#");
		strs.add("#");
		/*
		strs.add("9");
		strs.add("#");
		strs.add("#");
		strs.add("20");
		strs.add("15");
		strs.add("#");
		strs.add("#");
		strs.add("7");
		strs.add("9");
		strs.add("#");
		strs.add("#");
		strs.add("#");
		*/
		
		System.out.println("Input = " + strs);
		
		TreeNode root = BinaryTreeSerializer.deserialize(strs);
		
		System.out.println("result = " + BinaryTreeSerializer.serialize(root));
		
		List<Integer> result = inOrderTraversal.inorderTraversal(root);
		
		System.out.println("result = " + result);

	}
	
	// Recursive
	public List<Integer> inorderTraversal(TreeNode root) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		if (root == null)
			return list;

		inorderTraversalRecursive(root, list);

		return list;
	}

	public void inorderTraversalRecursive(TreeNode node, LinkedList<Integer> list) {
		if (node == null)
			return;
		
		inorderTraversalRecursive(node.left, list);
		list.add(node.val);
		inorderTraversalRecursive(node.right, list);

		return;
	}
	
	// Iterative
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null) return list;
        while(root != null) {
            while(root.left != null) {
                stack.push(root);
                root = root.left;
            }
            list.add(root.val);
            while(root.right == null) {
                if(!stack.isEmpty()) {
                    root = stack.pop();
                    list.add(root.val);
                } else {
                    break;
                }
            }
            if(root.right != null) {
                root = root.right;
            } else if(stack.isEmpty()) {
                break;
            }
        }
        return list;
    }
    
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }

}
