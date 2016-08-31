package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree  QuestionEditorial Solution  My Submissions
Total Accepted: 85541
Total Submissions: 227378
Difficulty: Easy
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * @author samsung
 *
 */
public class LowestCommonAncestorBinarySearchTree235 {


	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> nodePAncesArr = new ArrayList<TreeNode>();
        List<TreeNode> nodeQAncesArr = new ArrayList<TreeNode>();
        if (root==null) {
			return null;
		}
        TreeNode tempNode = root;
        while(tempNode.val!=p.val && tempNode!=null){
        	nodePAncesArr.add(tempNode);
        	if (p.val<tempNode.val) {
				tempNode = tempNode.left;
			}else if (p.val>tempNode.val) {
				tempNode = tempNode.right;
			}
        	
        }
        if (tempNode!=null) {
        	nodePAncesArr.add(tempNode);
		}
        
        TreeNode tempNode2 = root;
        while(tempNode2.val!=q.val && tempNode2!=null){
        	nodeQAncesArr.add(tempNode2);
        	if (q.val<tempNode2.val) {
        		tempNode2 = tempNode2.left;
			}else if (q.val>tempNode2.val) {
				tempNode2 = tempNode2.right;
			}
        	
        }
        if (tempNode2!=null) {
        	nodeQAncesArr.add(tempNode2);
		}
		
        int arr1Len = nodePAncesArr.size();
        int arr2Len = nodeQAncesArr.size();
        int length = arr1Len<arr2Len?arr1Len:arr2Len;
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < length; i++) {
			if (nodePAncesArr.get(i).val!=nodeQAncesArr.get(i).val) {
				index= i-1;
				flag = true;
				break;
			}
			
		}
        
        if (flag) {
        	if (index<0) {
        		index=0;
			}
			return nodePAncesArr.get(index);
		}else {
			return nodePAncesArr.get(length-1);
		}
        
    }
}
class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }