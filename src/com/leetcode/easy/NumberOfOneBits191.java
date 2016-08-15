package com.leetcode.easy;

import java.util.Stack;

import org.junit.Test;

/*
 * 191. Number of 1 Bits  QuestionEditorial Solution  My Submissions
Total Accepted: 106612
Total Submissions: 282327
Difficulty: Easy
Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */
public class NumberOfOneBits191 {
/**************参考了网上的答案之后写的*************************/
	// you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (0!=n) {
			n = n&(n-1);
			++count;
		}
    	return count;
    }
    
    @Test
    public void testCase(){
    	int num = 0x1011;
    	int result = hammingWeight(num);
    	System.out.println(result);
    }
}
