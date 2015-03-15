package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * 
 * Tree Depth-first Search
 * 
 */
public class L0100_SameTree {

	public L0100_SameTree() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L0100_SameTree sameTree = new L0100_SameTree();

		CreateBinarySearchTree t1 = new CreateBinarySearchTree();
		t1.add(1,2,3,4,5,6,7,8,9);
		
		CreateBinarySearchTree t2 = new CreateBinarySearchTree();
		t2.add(1,2,3,4,5,6,7,8);
		
		System.out.println( " t1 ->  " + t1.toString());
		System.out.println( " t2 ->  " + t2.toString());
		
		boolean result = sameTree.isSameTree(t1.root, t2.root);
		
		System.out.println("result = " + result);
	}

    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean result = false;
        
        
        if (p != null && q!= null ) {
        	if (p.val != q.val)
            	return false;
        	
        	result = isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } 
        else  if ((p != null && q == null) || (p == null && q!= null)) 
        	result = false; 
        else 
        	result = true;
              
        return result;
    }
}
