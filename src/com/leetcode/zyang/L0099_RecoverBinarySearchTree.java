package com.leetcode.zyang;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant 
 * space solution?
 * 
 */
public class L0099_RecoverBinarySearchTree {

	public L0099_RecoverBinarySearchTree() {
		// TODO Auto-generated constructor stub
	}

	TreeNode firstNode = null;
	TreeNode secondNode = null;
	TreeNode prevNode = new TreeNode(Integer.MIN_VALUE); // To help with the smallest node
	
    public void recoverTree(TreeNode root) {
    	findNode(root);
    	
       	int temp = firstNode.val;
       	firstNode.val = secondNode.val;
       	secondNode.val = temp;
    }
    
    // Traverse BST in order, expecting value in ascending order
    private void findNode(TreeNode root) {
    	if (root == null)
    		return;
    	
    	findNode(root.left);
    	
    	// If two nodes are swapped by mistake, then the first wrong one 
    	// will be bigger than its next neighbor in sequence; the second 
    	// one will be smaller than its proceeding neighbor
    	if (root.val <= prevNode.val && firstNode == null)
   			firstNode = prevNode;
    	
    	if (root.val <= prevNode.val && firstNode != null)
    		secondNode = root;
    	
    	prevNode = root;
    	
    	findNode(root.right);
    }
    
    //http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
    //http://www.geeksforgeeks.org/morris-traversal-for-preorder/
    //http://stackoverflow.com/questions/6478063/how-is-the-complexity-of-morris-traversal-on
    //http://blog.csdn.net/wdq347/article/details/8853371
    //Data Structures and Algorithms in C++ by Adam Drozdek
    //https://en.wikipedia.org/wiki/Threaded_binary_tree
    // http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
    // https://leetcode.com/discuss/26310/detail-explain-about-morris-traversal-finds-incorrect-pointer
    public void recoverTree1(TreeNode root) {
        List<TreeNode> eNodes = new LinkedList<TreeNode>(); //error nodes
        if(root == null) return;
        TreeNode current = root;
        TreeNode pre;
        TreeNode previous = null;
        while(current != null){

            if(current.left == null){

                if(previous!=null && previous.val > current.val){
                    eNodes.add(previous);
                    eNodes.add(current);
                }
                previous = current;
                current = current.right;

            }else{
                pre = current.left;
                while(pre.right != null && pre.right.val != current.val){
                    pre = pre.right;
                }

                if(pre.right == null){
                    pre.right = current;
                    current = current.left;
                }else {
                    if(previous!=null && previous.val > current.val){
                        eNodes.add(previous);
                        eNodes.add(current);
                    }

                    pre.right = null;
                    previous = current;
                    current = current.right;
                }
            }
        }

        //this is redundant check
        //if(eNodes.size() == 0) return;

        if(eNodes.size() == 2){
            pre = eNodes.get(0);
            current = eNodes.get(1);
        }else{ //this case where eNodes.size()==4
            pre = eNodes.get(0);
            current = eNodes.get(3);
        }

        int temp = pre.val;
        pre.val = current.val;
        current.val = temp;
    }
}
