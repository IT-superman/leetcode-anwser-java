package com.leetcode.easy;
/**
 * 83. Remove Duplicates from Sorted List  QuestionEditorial Solution  My Submissions
Total Accepted: 132350
Total Submissions: 351287
Difficulty: Easy
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 * @author samsung
 *
 */
public class RemoveDuplicatesFromSortedList83 {

	 public ListNode deleteDuplicates(ListNode head) {
	        
		 if (head==null) {
			return head;
		}
		 ListNode preNode = head;
		 ListNode curNode = preNode.next;
		 while (curNode!=null) {
			if (preNode.val!=curNode.val) {
				preNode.next = curNode;
				preNode = curNode;
				curNode = curNode.next;
			}else {
				if (preNode.val==curNode.val && curNode.next==null) {
					preNode.next=null;
					break;
				}
				curNode = curNode.next;
			}
			 
		}
		 
		 return  head;
		 
	    }
}

class ListNode {
	     int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	 }
