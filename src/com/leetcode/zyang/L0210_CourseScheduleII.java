package com.leetcode.zyang;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author zyang
 * 
 *         There are a total of n courses you have to take, labeled from 0 to n
 *         - 1.
 * 
 *         Some courses may have prerequisites, for example to take course 0 you
 *         have to first take course 1, which is expressed as a pair: [0,1]
 * 
 *         Given the total number of courses and a list of prerequisite pairs,
 *         return the ordering of courses you should take to finish all courses.
 * 
 *         There may be multiple correct orders, you just need to return one of
 *         them. If it is impossible to finish all courses, return an empty
 *         array.
 * 
 *         For example:
 * 
 *         2, [[1,0]] There are a total of 2 courses to take. To take course 1
 *         you should have finished course 0. So the correct course order is
 *         [0,1]
 * 
 *         4, [[1,0],[2,0],[3,1],[3,2]] There are a total of 4 courses to take.
 *         To take course 3 you should have finished both courses 1 and 2. Both
 *         courses 1 and 2 should be taken after you finished course 0. So one
 *         correct course order is [0,1,2,3]. Another correct ordering
 *         is[0,2,1,3].
 * 
 *         Note: The input prerequisites is a graph represented by a list of
 *         edges, not adjacency matrices. Read more about how a graph is
 *         represented.
 * 
 * 
 * 
 */
public class L0210_CourseScheduleII {
	int curLevel;
	// DFS
    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        if (numCourses < 1)
        	return order;
        
        if (prerequisites == null || prerequisites.length < 1) {
        	for (int i = 0; i < numCourses; i++) 
            	order[i] = i;
        	return order;
        }
        
        curLevel = numCourses - 1;
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
	            boolean isCyclic = assignOrder(i, visited, visiting, graph, order);            
	            if (isCyclic) {
	            	return new int[0];
	            }
        	}
        }

        return order;
    }
    
    private boolean assignOrder(int num, int[] visited, int[] visiting, Set<Integer>[] graph, int[] order) {    	
    	if (visited[num] == 1)
        	return false;
        	
    	if (visiting[num] == 1)
    		return true;
    	
    	visiting[num] = 1;
    	for (int child : graph[num]) {
    		if (visited[child] == 0) {  			
    			if (assignOrder(child, visited, visiting, graph, order))
    				return true;      			
    		}
    	}
    	
    	order[curLevel--] = num;
    	visiting[num] = 0;
    	visited[num] = 1;
    	return false;
    }
    
    // BFS
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        if (numCourses < 1)
        	return order;
        
        if (prerequisites == null || prerequisites.length < 1) {
        	for (int i = 0; i < numCourses; i++) 
            	order[i] = i;
        	return order;
        }
        
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
        	order[count++] = pre;
        	
        	for (int course : graph[pre]) {
        		indegree[course]--;
        		if (indegree[course] == 0) 
        			queue.offer(course);
        	}
        }
    
        if (count == numCourses)
        	return order;
        else
        	return new int[0];
    }
}
