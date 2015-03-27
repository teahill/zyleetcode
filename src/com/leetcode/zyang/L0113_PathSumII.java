package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author zyang
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * return
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *  
 */
public class L0113_PathSumII {

	public L0113_PathSumII() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		L0113_PathSumII pathSum = new L0113_PathSumII();
		
		List<String> strs = new ArrayList<String>();
		
		
		strs.add("5");
		strs.add("4");
		strs.add("11");
		strs.add("7");
		strs.add("#");
		strs.add("#");
		strs.add("2");
		strs.add("#");
		strs.add("#");
		strs.add("#");
		strs.add("8");
		strs.add("13");
		strs.add("#");
		strs.add("#");
		strs.add("4");
		strs.add("#");
		strs.add("1");
		strs.add("#");
		strs.add("#");
		
		int sum = 22;
		
		
		/**
		strs.add("-2");
		strs.add("#");
		strs.add("-3");
		strs.add("#");
		strs.add("#");	

		int sum = -5;
		*/
		
		System.out.println("Input = " + strs);
		
		TreeNode root = BinaryTreeSerializer.deserialize(strs);
		
		System.out.println("result = " + BinaryTreeSerializer.serialize(root));
		
		List<List<Integer>> result = pathSum.pathSum(root, sum);
		
		System.out.println("result = " + result);
	}

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> allList = new LinkedList<List<Integer>>();
    	List<Integer> list = new LinkedList<Integer>();
    	
       	if (root == null)
       		return allList;

       	pathSum(root, sum, allList, list);
       	
    	return allList;   
    }
    
    //Recursive
    public void pathSum(TreeNode node, int sum, List<List<Integer>> allList, List<Integer> list) {
    	list.add(node.val);
    	
    	if (node.val == sum && node.left == null && node.right == null) {    		
    		allList.add(list);    		
    		return;
    	}
    	
    	int remainder = sum - node.val;
    	
    	if (node.left != null) {
    		pathSum(node.left, remainder, allList, new LinkedList<Integer>(list));
    	}
    	
    	if (node.right != null) {
    		pathSum(node.right, remainder, allList, new LinkedList<Integer>(list));
    	}
    	
    	list.remove(list.size() - 1);
    	
    	return;
    }
    
    //Iterative
    public List<List<Integer>> pathSum1(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<Integer> path = new LinkedList<Integer>();
        Stack<TreeNode> rights = new Stack<TreeNode>();
        Stack<Integer> steps = new Stack<Integer>();
        int psum = 0;
        int step = 0;

        while(root != null) {
            path.add(root.val);
            psum += root.val;

            // Save result if found
            if (root.left == null && root.right == null && psum == sum) {
                result.add(new LinkedList<Integer>(path));
            }

            // Stack right children and back steps
            // to next stacked right children
            if (root.right != null) {
                rights.push(root.right);
                steps.push(step);
                step = 0;
            }

            // Get TreeNode for next iteration
            root = root.left;
            if (root == null && !rights.isEmpty()) {
                root = rights.pop();
                for (int i=0; i<step; i++) {
                    int last = path.removeLast();
                    psum -= last;
                }
                step = steps.pop();
            }

            // We have to remeber steps we did after last
            // right children pushed to stack
            step++;
        }
        return result;
    }
}
