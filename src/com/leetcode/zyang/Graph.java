package com.leetcode.zyang;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 OJ's undirected graph serialization: Nodes are labeled uniquely.
 * 
 * We use # as a separator for each node, and , as a separator for node label
 * and each neighbor of the node. As an example, consider the serialized graph
 * {0,1,2#1,2#2,2}.
 * 
 * The graph has a total of three nodes, and therefore contains three parts as
 * separated by #.
 * 
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2. Second node
 * is labeled as 1. Connect node 1 to node 2. Third node is labeled as 2.
 * Connect node 2 to node 2 (itself), thus forming a self-cycle. Visually, the
 * graph looks like the following:
 * 
 *       1
 *      / \
 *     /   \
 *    0 --- 2
 *         / \
 *         \_/
 *         
 */
public class Graph {
	public static String serialize(UndirectedGraphNode node) {
		StringBuilder sb = new StringBuilder();
		if (node == null)
			return sb.toString();
		
		Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();		
		serialize(node, set, sb);
		
		return sb.toString();
	}

	private static void serialize(UndirectedGraphNode node, Set<UndirectedGraphNode> set, StringBuilder sb) {
		if (sb.length() > 0)
			sb.append("#");
		
		sb.append(node.label);
		for (UndirectedGraphNode neighbor : node.neighbors) {
			if (set.contains(neighbor))
				continue;
			
			sb.append(",").append(neighbor.label);
		}
		
		set.add(node);
		
		for (UndirectedGraphNode neighbor : node.neighbors) {
			if (set.contains(neighbor))
				continue;
			
			serialize(neighbor, set, sb);
		}
				
		return;
	}
	
	//{0,1,2#1,2#2,2}
	//{0,1,5#1,2,5#2,3#3,4,4#4,5,5#5} 
	public static UndirectedGraphNode deserialize(String str) {
		UndirectedGraphNode node = null;
		if (str == null || str.length() < 1)
			return node;
		
		Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
		String[] sList = str.split("#");
		for (String s : sList) {
			String[] tmp = s.split(",", 2);
			int label = Integer.valueOf(tmp[0]);		
			UndirectedGraphNode newNode = new UndirectedGraphNode(label);
			node = (node == null) ? newNode : node;
			map.put(label,  newNode);
		}
		
		for (String s : sList) {
			String[] tmp = s.split(",");
			UndirectedGraphNode nd = map.get(Integer.valueOf(tmp[0]));
			for (int i = 1; i < tmp.length; i++) 
				nd.neighbors.add(map.get(Integer.valueOf(tmp[i])));
		}
		
		return node;
	}
}

