/*
 * 
 * Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
 * */

package com.leetcode.easy;

import org.junit.Test;

import junit.*;

public class Solution344 {

	public String reverseString(String s) {

		if (s == null || "".equals(s))
			return "";
		char tempCharArr[] = s.toCharArray();
		char charOut[] = new char[tempCharArr.length];
		int j=0;
		for (int i = tempCharArr.length-1; i >= 0; i--) {
			char c = tempCharArr[i];
			charOut[j] = c;
			j++;
		}
		String resultStr = String.copyValueOf(charOut);
		return resultStr;
	}

	@Test
	public void reverseStringTest() {

		String resultStr = reverseString("abcdre");
System.out.println(resultStr);
	}

}
