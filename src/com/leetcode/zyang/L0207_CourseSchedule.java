package com.leetcode.zyang;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author zyang
 * 
 *         There are a total of n courses you have to take, labeled from 0 to n
 *         - 1.
 * 
 *         Some courses may have prerequisites, for example to take course 0 you
 *         have to first take course 1, which is expressed as a pair: [0,1]
 * 
 *         Given the total number of courses and a list of prerequisite pairs,
 *         is it possible for you to finish all courses?
 * 
 *         For example:
 * 
 *         2, [[1,0]] There are a total of 2 courses to take. To take course 1
 *         you should have finished course 0. So it is possible.
 * 
 *         2, [[1,0],[0,1]] There are a total of 2 courses to take. To take
 *         course 1 you should have finished course 0, and to take course 0 you
 *         should also have finished course 1. So it is impossible.
 * 
 *         Note: The input prerequisites is a graph represented by a list of
 *         edges, not adjacency matrices. Read more about how a graph is
 *         represented.
 *         
 *         Coursera Algorithm 
 *         
 *         https://class.coursera.org/algo-003/lecture
 *         
 *         Graph representation
 *         
 *         https://www.khanacademy.org/computing/computer-science/algorithms/graph-representation/a/representing-graphs
 *         
 */
public class L0207_CourseSchedule {
	
	// DFS
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        if (numCourses < 1 || prerequisites == null || prerequisites.length < 2)
        	return true;
        
        @SuppressWarnings("unchecked")
		Set<Integer>[] graph = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) 
        	graph[i] = new HashSet<Integer>();
        	
        for (int i = 0; i < prerequisites.length; i++) 
        	graph[prerequisites[i][1]].add(prerequisites[i][0]);
        
        int[] visited = new int[numCourses];
        int[] visiting = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
        	if (visited[i] == 0) {       	
	            boolean isCyclic = isCyclic(i, visited, visiting, graph);            
	            if (isCyclic) 
	            	return false;
        	}
        }

        return true;
    }
    
    private boolean isCyclic(int num, int[] visited, int[] visiting, Set<Integer>[] graph) {    	
    	if (visited[num] == 1)
        	return false;
        	
    	if (visiting[num] == 1)
    		return true;
    	
    	visiting[num] = 1;
    	for (int child : graph[num]) {
    		if (visited[child] == 0) {  			
    			if (isCyclic(child, visited, visiting, graph))
    				return true;    			
    		}
    	}
    	
    	visiting[num] = 0;
    	visited[num] = 1;
    	return false;
    }
    
    // BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 1 || prerequisites == null || prerequisites.length < 2)
        	return true;
        
        @SuppressWarnings("unchecked")
		List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
        	graph[i] = new ArrayList<Integer>();
        int[] indegree = new int[numCourses];
        
        for (int i = 0; i < prerequisites.length; i++) {
        	graph[prerequisites[i][1]].add(prerequisites[i][0]);
        	indegree[prerequisites[i][0]]++;
        }
        
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < numCourses; i++) {
        	if (indegree[i] == 0)
        		queue.offer(i);
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
        	int pre = queue.poll();
        	count++;
        	
        	for (int course : graph[pre]) {
        		indegree[course]--;
        		if (indegree[course] == 0) 
        			queue.offer(course);
        	}
        }
    
        return (count == numCourses);
    }
}
