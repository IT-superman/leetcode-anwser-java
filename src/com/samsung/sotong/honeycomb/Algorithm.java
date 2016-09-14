package com.samsung.sotong.honeycomb;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * wrong :Time limit Exceeded
 * @author samsung
 *
 */
public class Algorithm {

	private static int maxRouteNum = 0;
	private static Graph memGraph = null; 
	public static void main(String[] args) throws Exception{
		
		Scanner scanner = new Scanner(System.in);
		//Scanner scanner = new Scanner(new FileInputStream("src/com/samsung/sotong/honeycomb/sample_input.txt"));
		int T = Integer.valueOf(scanner.nextLine());
		while(T-->0){
			Graph graph = new Graph();
			maxRouteNum = 0;
			int sideLength = Integer.valueOf(scanner.nextLine());
			graph.sizeLenth = sideLength;
			graph.topNodeArr = new Node[sideLength];
			graph.levelMaxNum = new int[2*sideLength-1];
			List<Node> lastLevelNode = new ArrayList<Node>();
			for (int i = 0; i < 2*sideLength-1; i++) {
				String[] numStrArr = scanner.nextLine().trim().split(" ");
				List<Node> curLevelNode = new ArrayList<Node>();
				int levelMaxNum = 0;
				for (int j = 0; j < numStrArr.length; j++) {
					int nodeVal = Integer.valueOf(numStrArr[j]);
					if (i==0) {
						Node node = new Node();
						node.value = nodeVal;
						node.levelIndex = i;
						graph.topNodeArr[j] = node;
						curLevelNode.add(node);
					}else {
						Node node = new Node();
						node.value = nodeVal;
						node.levelIndex = i;
						
						if (i<=sideLength-1) {
							if (j==0) {
								lastLevelNode.get(j).left=node;
							}else if(j==numStrArr.length-1){
								lastLevelNode.get(j-1).right=node;
							}else {
								lastLevelNode.get(j-1).right=node;
								lastLevelNode.get(j).left=node;
							}
						}else {
								lastLevelNode.get(j).right=node;
								lastLevelNode.get(j+1).left=node;
						}
						curLevelNode.add(node);
					}
					
					if (nodeVal>levelMaxNum) {
						levelMaxNum = nodeVal;
					}
					
				}
				graph.levelMaxNum[i] = levelMaxNum;
				lastLevelNode.clear();
				lastLevelNode = curLevelNode;
			}
			
			
			memGraph = graph;
			//caculateMaxNum();
			System.out.println(maxRouteNum);
				
		}
		
		
	}
	
	private static void caculateMaxNum(){
		
		
		for(int i=0;i<memGraph.topNodeArr.length;++i){
			Node TopNode = memGraph.topNodeArr[i];
			int[] scanedVal = new int[2*memGraph.sizeLenth-1];
			scanNode(TopNode,scanedVal,0);
			
		}
		
	}
	
	private static void scanNode(Node node,int[] scanedVal,int num){
		if (node==null) {
			return;
		}
		scanedVal[num] = node.value;
		++num;
		if (num==2*memGraph.sizeLenth-1) {
			//选择与最大值差值最大的节点做改变
			int maxSec = 0;
			int maxIndex = 0;
			for (int i = 0; i < num; i++) {
				int nodeVal = scanedVal[i];
				int levelMax = memGraph.levelMaxNum[i];
				if (levelMax-nodeVal>maxSec) {
					maxSec = levelMax-nodeVal;
					maxIndex = i;
				}
			}
			
			int maxSum = 0;
			for (int i = 0; i < num; i++) {
				int nodeVal = scanedVal[i];
				if (i==maxIndex) {
					int levelMax = memGraph.levelMaxNum[i];
					nodeVal = levelMax;
				}
				
				maxSum+=nodeVal;
				
			}
			
			if (maxSum>maxRouteNum) {
				maxRouteNum = maxSum;
			}
			return;
		}
		
		scanNode(node.left,scanedVal,num);
		scanNode(node.right,scanedVal,num);
		return;
	}
}

class Graph{
	public int sizeLenth = 0;
	public Node[] topNodeArr;
	public int[] levelMaxNum;
	
}

class Node{
	public int levelIndex = 0;
	public int value = 0;
	public Node left = null;
	public Node right = null;
}
/*
shows a honeycomb with length 3 on a side. When it calls a figure-written circle a node, a method to move from the current node to the next is to move down left or down right diagonally. 锘�




Find the highest sum of nodes starting from the top node to the bottom node. There is a chance to change a figure only once in the same row while you go down. Using this chance, find out the maximum sum of routes from the top node to the bottom node.

Time limit: 1 second (java: 2 seconds)

[Input]
Several test cases can be included in the inputs. T, the number of cases is given in the first row of the inputs. After that, the test cases as many as T (T 鈮� 30) are given in a row. 
A side length of a honeycomb, N is given on the first row per each test case. These figures are over 0 below 99. 

[Output]
After changing two figures of the same row on the first row only once per each test case, output the maximum sum of the routes from the top node to the bottom node.

[I/O Example]
Input 
2
3
1 2 3
3 2 2 1
4 2 8 0 3
5 3 1 2
3 1 4
2
53 14
27 2 31
85 30

Output
22
169

Explanation of example
The answer of  is 3+2+8+5+4=22 painted as gray color. At this time, the figure, 5 is changed with the third node from left on the same row, 1. 
*/