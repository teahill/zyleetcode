package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author zyang
 * 
 * For a undirected graph with tree characteristics, we can choose any node as the root. 
 * The result graph is then a rooted tree. Among all possible rooted trees, 
 * those with minimum height are called minimum height trees (MHTs). Given such a graph, 
 * write a function to find all the MHTs and return a list of their root labels.
 * 
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n 
 * and a list of undirected edges (each edge is a pair of labels).
 * 
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, 
 * [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * 
 * Example 1:
 * 
 * Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 * 
 *         0
 *         |
 *         1
 *        / \
 *       2   3
 * return [1]
 * 
 * Example 2:
 * 
 * Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 * 
 *      0  1  2
 *       \ | /
 *         3
 *         |
 *         4
 *         |
 *         5
 * return [3, 4]
 */
public class L0310_MinHeightTree {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {       	
    	List<Integer> result = new ArrayList<Integer>();
    	
        if (edges == null)
        	return result;  
        
        if (n < 2) {
        	result.add(0);
        	return result;
        }
        	
        // Create neighbor list
        List<Set<Integer>> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) { 
        	Set<Integer> set = new HashSet<Integer>();
        	list.add(set);
        }
        
        // Build graph
        for (int i = 0; i < edges.length; i++) {
        	list.get(edges[i][0]).add(edges[i][1]);
        	list.get(edges[i][1]).add(edges[i][0]);
        }
        
        // If it is a leaf node, add to the queue
        List<Integer> nodes = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) { 
        	if (list.get(i).size() == 1)
        		nodes.add(i);
        }
        
        // Start outside in, remove leaf nodes level by level
        while (n > 2) {
        	n-= nodes.size();
        	
        	// Create a new leaf list
        	List<Integer> newNodes = new ArrayList<Integer>();
	        for (Integer node : nodes) {	
	        	Set<Integer> neighborSet = list.get(node);
	        	for (Integer neighbor : neighborSet) {
	        		//  Remove the node from its neighbor's neighboring set, reduce in-degree
	        		list.get(neighbor).remove(node);
	        		
	        		// Add the new leaf to the new leaf list 
	        		if (list.get(neighbor).size() == 1)
	        			newNodes.add(neighbor);
	        	}	        	
	        }	        
	        
	        // Process the new leaf list
	        nodes = newNodes;	        
        }   
        
        result.addAll(nodes);
        return result;
    }
}
