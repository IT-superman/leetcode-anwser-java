package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/*202. Happy Number  QuestionEditorial Solution  My Submissions
Total Accepted: 83473
Total Submissions: 220931
Difficulty: Easy
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 * */

public class HappyNumber202 {

	public boolean isHappy(int n) {
		if (n<=0) {
			return false;
		}
        if (n==1) {
			return true;
		}
        Set<Integer> hasVisitedVal =  new HashSet<Integer>();
        int currentVal = n;
        while(currentVal!=1){
        	if (hasVisitedVal.contains(currentVal)) {
        		return false;
			}
        	hasVisitedVal.add(currentVal);
        	String currentStr = String.valueOf(currentVal);
        	currentVal = 0;
        	for (int i = 0; i < currentStr.length(); i++) {
        		char ch = currentStr.charAt(i);
        		int tempInt = Integer.parseInt(String.valueOf(currentStr.charAt(i)));
        		currentVal+=Math.pow(tempInt, 2);
			}
        	
        }
		
        if (currentVal==1) {
			return true;
		}else {
			return false;
		}
        
        
    }

	@Test
	public void testCase(){
		isHappy(7);
		
	}
	
}
