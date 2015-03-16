package com.leetcode.zyang;


public class CreateBinarySearchTree {

    public TreeNode root;

    public CreateBinarySearchTree() {
    }
    
    public void add(int... items) {
        for (int item : items) {
            add(item);
        }
    }
    
    public void add(int item) {
        if (root == null) {
            root = new TreeNode(null, item, null);
        } else {
            add(root, item);
        }
    }

    public void add(TreeNode node, int item) {
        if (item < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(null, item, null);
            } else {
                add(node.left, item);
            }
        } else if (item > node.val) {
            if (node.right == null) {
                node.right = new TreeNode(null, item, null);
            } else {
                add(node.right, item);
            }
        }
    }
    
    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(TreeNode node) {
        if (node == null) {
            return null;
        }
        return "[" + toString(node.left) + "," + node.val + "," + toString(node.right) + "]";
    }
    
    /**
    public void add(int item) {
        if (root == null) {
            root = new TreeNode(null, item, null);
            return;
        }

        TreeNode node = root;
        while (true) {
            if (item < node.val) {
                if (node.left == null) {
                    node.left = new TreeNode(null, item, null);
                    break;
                }
                node = node.left;
            } else if (item > node.val) {
                if (node.right == null) {
                    node.right = new TreeNode(null, item, null);
                    break;
                }
                node = node.right;
            } else {
                break;
            }
        }
    }
    */
    
    /**
     * Will create a BST imperative on order of elements in the array
     */
    /**
     * 
        private static class TreeNode {
        TreeNode left;
        int item;
        TreeNode right;

        TreeNode(TreeNode left, int item, TreeNode right) {
            this.left = left;
            this.right = right;
            this.item = item; 
        }
    }
    public CreateBinarySearchTree(int[] a) {
        this();
        for (int i : a) {
            add(i);
        }
    }
    */
}