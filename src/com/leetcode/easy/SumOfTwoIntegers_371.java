package com.leetcode.easy;

import org.junit.Test;

/*
 * 371. Sum of Two Integers 

Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.


 * 
 * */
public class SumOfTwoIntegers_371 {

	 public int getSum(int a, int b) {
	        
		 
		 while (b != 0) {
	            int c = a ^ b;
	            b = (a & b) << 1;
	            a = c;
	        }
	        return a;
	    }
	
	 @Test
	 public void getSumTest(){
		 
		 int sum = getSum(15, 28);
		 
		 System.out.println(sum);
	 }
	 
}


/*
 * 解题思路：

解法I 位运算（Bit Manipulation）异或 + 移位

参考：http://www.geeksforgeeks.org/add-two-numbers-without-using-arithmetic-operators/

Java代码：

public class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int c = a ^ b;
            b = (a & b) << 1;
            a = c;
        }
        return a;
    }
}
解法II 位运算（Bit Manipulation) 模拟加法

Java代码：

public class Solution {
    public int getSum(int a, int b) {
        int r = 0, c = 0, p = 1;
        while ((a | b | c) != 0) {
            if (((a ^ b ^ c) & 1) != 0)
                r |= p;
            p <<= 1;
            c = (a & b | b & c | a & c) & 1;
            a >>>= 1;
            b >>>= 1;
        }
        return r;
    }
}
*/
 