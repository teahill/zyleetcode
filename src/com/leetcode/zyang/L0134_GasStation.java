package com.leetcode.zyang;

/**
 * 
 * @author zyang
 *
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to 
 * travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * 
 * Note:
 * The solution is guaranteed to be unique.
 */
public class L0134_GasStation {

	public L0134_GasStation() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * 1. If car starts at A and can not reach B. Any station between A and B can not reach B.
	 * (B is the first station that A can not reach.)
	 * Proof to the first point: say there is a point C between A and B -- 
	 * that is A can reach C but cannot reach B. Since A cannot reach B, 
	 * the gas collected between A and B is short of the cost. Starting from A, 
	 * at the time when the car reaches C, it brings in gas >= 0, and the car still cannot reach B. 
	 * Thus if the car just starts from C, it definitely cannot reach B.
	 * 2. If the total number of gas is bigger than the total number of cost. There must be a solution.
	 */
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int index = 0;    	
    	int delta = 0;
    	int totalDelta = 0;
    	for (int i = 0; i < gas.length; i++) {
    		delta += gas[i] - cost[i];
    		if (delta < 0) {
    			index = i + 1;
    			totalDelta += delta;
    			delta = 0;    			
    		}
    	}

    	totalDelta += delta;
    	return (totalDelta >= 0) ? index : -1;
    }
}
