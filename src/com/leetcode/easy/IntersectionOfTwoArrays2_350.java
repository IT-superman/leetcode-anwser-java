package com.leetcode.easy;
/*Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 * */
public class IntersectionOfTwoArrays2_350 {
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
	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1.length==0) {
			return nums1;
		}
		if (nums2.length==0) {
			return nums2;
		}
		sortIntArr(nums1);
        sortIntArr(nums2);
        int i=0,j=0;
        int arr1Len = nums1.length;
        int arr2Len = nums2.length;
        int resultLen = arr1Len>arr2Len?arr2Len:arr1Len;
        int resultSet[] = new int[resultLen];
        int k = 0;
        while (i<arr1Len && j<arr2Len) {
			if (nums1[i]<nums2[j]) {
				++i;
			}else if (nums1[i]>nums2[j]) {
				++j;
			}else {
				
					resultSet[k] = nums1[i];
					++k;
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
