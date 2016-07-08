package com.leetcode.easy;
/*
 * Given an integer, write a function to determine if it is a power of two.
 */
public class PowerOfTwo231 {

			public boolean isPowerOfTwo(int n) {
			        if(n<=0){
			        	return false;
			        }
			        double dVal = Math.log(n)/Math.log(2);
			        return n==Math.pow(2,Math.round(dVal));
			        
			    }
}
