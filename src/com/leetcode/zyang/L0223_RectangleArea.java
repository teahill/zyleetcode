package com.leetcode.zyang;

/**
 * 
 * @author zyang
 *
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * 
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * 
 * Rectangle Area
 * Assume that the total area is never beyond the maximum possible value of int.
 * 
 */
public class L0223_RectangleArea {

	public L0223_RectangleArea() {
		// TODO Auto-generated constructor stub
	}

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int total = 0;
        
        // compute rec 1
        total = total + Math.abs(C - A) * Math.abs(D - B);
        
        // compute rec 2
        total = total + Math.abs(G - E) * Math.abs(H - F);
        
        // remove any overlap
        if (E > C || G < A || H < B || F > D)
        	return total;
        
        int leftX = (E > A) ? E : A;
        int leftY = (F > B) ? F : B;
        int rightX = (G > C) ? C : G;
        int rightY = (H > D) ? D : H;
      
        total = total - Math.abs(rightX - leftX) * Math.abs(rightY - leftY);
        
        return total;
    }
}
