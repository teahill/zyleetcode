package com.leetcode.zyang;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author zyang
 * 
 *         Clone an undirected graph. Each node in the graph contains a label
 *         and a list of its neighbors.
 * 
 * 
 *         OJ's undirected graph serialization: Nodes are labeled uniquely.
 * 
 *         We use # as a separator for each node, and , as a separator for node
 *         label and each neighbor of the node. As an example, consider the
 *         serialized graph {0,1,2#1,2#2,2}.
 * 
 *         The graph has a total of three nodes, and therefore contains three
 *         parts as separated by #.
 * 
 *         First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 *         Second node is labeled as 1. Connect node 1 to node 2. Third node is
 *         labeled as 2. Connect node 2 to node 2 (itself), thus forming a
 *         self-cycle. Visually, the graph looks like the following:
 * 
 *      1
 *     / \
 *    /   \
 *   0 --- 2
 *        / \
 *        \_/
 *
 */

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class L0133_CloneGraph {
	private Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
	
	// DFS implementation
    public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
        if (node == null)
        	return null;
        
        UndirectedGraphNode clone = cloneNode(node);
        
        return clone;
    }
    
    private UndirectedGraphNode cloneNode(UndirectedGraphNode node) {
        if (node == null)
        	return null;

        if (map.containsKey(node.label))
        	return map.get(node.label);
        
        // Create and copy node
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);   
        map.put(newNode.label, newNode);
        
        List<UndirectedGraphNode> newNeighbors = newNode.neighbors;        
        // Clone neighbors and add to the new node
        for(UndirectedGraphNode neighbor : node.neighbors) 
        	newNeighbors.add(cloneNode(neighbor));
        
        return newNode; 
    }
    
    // BFS implementation
	//{0,1,2#1,2#2,2}
	//{0,1,5#1,2,5#2,3#3,4,4#4,5,5#5} 
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        UndirectedGraphNode clone = null;
        if (node == null)
        	return clone;

    	clone = new UndirectedGraphNode(node.label);
    	map.put(node.label, clone);
    	
        Queue<UndirectedGraphNode> queue = new ArrayDeque<UndirectedGraphNode>();
        queue.offer(node);
        while (!queue.isEmpty()) {
        	UndirectedGraphNode nd = queue.poll();        	
        	UndirectedGraphNode newNode = map.get(nd.label);
       	
        	for (UndirectedGraphNode neighbor : nd.neighbors) {
        		if (!map.containsKey(neighbor.label)) {
        			UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
        			map.put(neighbor.label, newNeighbor);
        			queue.offer(neighbor);
        		}  
        		
        		newNode.neighbors.add(map.get(neighbor.label));        		
        	}        	
        }
        
        return clone;
    }
}
