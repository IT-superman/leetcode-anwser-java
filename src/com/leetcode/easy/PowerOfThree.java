package com.leetcode.easy;
/*
 * Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
 */
public class PowerOfThree {

public boolean isPowerOfThree(int n) {
    
	if(n<=0) return false;
	
        double dVal = Math.log(n)/Math.log(3);
        return n==Math.pow(3, Math.round(dVal));
		
		
    }
	
	
}
