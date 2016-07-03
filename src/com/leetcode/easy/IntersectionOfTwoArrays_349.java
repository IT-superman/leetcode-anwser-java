package com.leetcode.easy;
/*
 * Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
 */
public class IntersectionOfTwoArrays_349 {

	public void sortIntArr(int [] arr){
		
		int arrLen = arr.length;
		for (int i = 0; i < arrLen; i++) {
			for (int j = 0; j < arrLen-i-1; j++) {
				if (arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
	}
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1.length==0) {
			return nums1;
		}
		if (nums2.length==0) {
			return nums2;
		}
        int resultSet[] = null;
        sortIntArr(nums1);
        sortIntArr(nums2);
        int i=0,j=0;
        int arr1Len = nums1.length;
        int arr2Len = nums2.length;
        int resultLen = arr1Len>arr2Len?arr2Len:arr1Len;
        resultSet = new int[resultLen];
        int k = 0;
        while (i<arr1Len && j<arr2Len) {
			if (nums1[i]<nums2[j]) {
				++i;
			}else if (nums1[i]>nums2[j]) {
				++j;
			}else {
				if (k==0 || resultSet[k-1]!=nums1[i]) {
					resultSet[k] = nums1[i];
					++k;
					
				}
				++i;
				++j;
			}
        	
        	
		}
      
        
        int outArr[] = new int[k];
        for (int m = 0; m < k; m++) {
        	outArr[m]  = resultSet[m];
		}
        
        
        return outArr;
    }
}
