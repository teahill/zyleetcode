package com.leetcode.zyang;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author zyang
 * 
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * 
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * 
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * 
 * 
 * 
 */
public class L0095_UniqueBSTII {

	public L0095_UniqueBSTII() {
		// TODO Auto-generated constructor stub
	}
	
	// Divide & Conquer - F(i) = G(i-1) * G(n-i)
    public List<TreeNode> generateTrees(int n) {    
        List<TreeNode> list = generateTrees(1, n);
        return list;
    }

    public List<TreeNode> generateTrees(int start, int end) {
    	LinkedList<TreeNode> list = new LinkedList<TreeNode>();  	
    	if (start > end) {
    		list.add(null);
        	return list;
    	}
    		
        if (start ==  end) {
        	TreeNode root = new TreeNode(start);
        	list.add(root);
        	return list;
        }
        
        for (int i = start; i < end + 1; i++) {
        	List<TreeNode> listLeft = generateTrees(start, i - 1); 
        	List<TreeNode> listRight = generateTrees(i + 1, end); 	
        	for (TreeNode tl : listLeft) {
        		for (TreeNode tr : listRight) {
        			TreeNode node = new TreeNode(i);
        			node.left = tl;
        			node.right = tr;
        			list.add(node);
        		}
        	}        	        	
        }
        
        return list;        	
    }
    
    // Iterative Java solution, copied from leetcode discussion
    public List<TreeNode> generateTrees1(int n) {
        Map<Integer, List<TreeNode>> lists = new HashMap<Integer, List<TreeNode>>();

        List<TreeNode> list = new LinkedList<TreeNode>();
        list.add(null);
        if (n==0) return list;
        lists.put(0, list);

        list = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(1);
        list.add(root);
        lists.put(1, list);

        for (int i=2; i<=n; i++) {
            list = new LinkedList<TreeNode>();
            for (int j=1; j<=i; j++) {
                for (TreeNode left:lists.get(j-1)) {
                    for (TreeNode right:lists.get(i-j)) {
                        root = new TreeNode(j);
                        root.left = left;
                        root.right = greaterCopy(right, j);
                        list.add(root);
                    }
                }
            }
            lists.put(i, list);
        }
        return list;
    }

    private TreeNode greaterCopy(TreeNode node, int add) {
        if (node == null) return null;
        TreeNode copy = new TreeNode(node.val + add);
        copy.left = greaterCopy(node.left, add);
        copy.right = greaterCopy(node.right, add);
        return copy;
    }

    
}
