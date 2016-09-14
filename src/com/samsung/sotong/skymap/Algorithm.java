package com.samsung.sotong.skymap;
import java.io.FileInputStream;
import java.util.*;


public class Algorithm {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		//Scanner scanner = new Scanner(new FileInputStream("src/com/samsung/sotong/skymap/sample_input.txt"));

		int T = scanner.nextInt();
		while (T-->0) {
			
			int N = scanner.nextInt();
			int [][]mapMatrix = new int[N+2][N+2];
			int [][]isvisited = new int[N+2][N+2];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int isStar = scanner.nextInt();
					mapMatrix[i+1][j+1] = isStar;
				}
			}
			Deque<Node> collection = new ArrayDeque<Node>();
			int collectionCount = 0;
			int maxCollectionNum = 0;
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
				if (mapMatrix[i][j]==1 && isvisited[i][j]==0) {
					++collectionCount;
					int nodeCount = 0;
					Node node = new Node(i,j);
					collection.push(node);
					isvisited[node.x][node.y] = 1;
					++nodeCount;
					while (!collection.isEmpty()) {
						
						Node node2 = collection.pop();
						
						if (mapMatrix[node2.x-1][node2.y]==1 && isvisited[node2.x-1][node2.y]==0) {
							collection.push(new Node(node2.x-1,node2.y));
							isvisited[node2.x-1][node2.y] = 1;
							++nodeCount;
						}
						if (mapMatrix[node2.x][node2.y+1]==1 && isvisited[node2.x][node2.y+1]==0) {
							collection.push(new Node(node2.x,node2.y+1));
							isvisited[node2.x][node2.y+1] = 1;
							++nodeCount;
						}
						if (mapMatrix[node2.x+1][node2.y]==1 && isvisited[node2.x+1][node2.y]==0) {
							collection.push(new Node(node2.x+1,node2.y));
							isvisited[node2.x+1][node2.y] = 1;
							++nodeCount;
						}
						if (mapMatrix[node2.x][node2.y-1]==1 && isvisited[node2.x][node2.y-1]==0) {
							collection.push(new Node(node2.x,node2.y-1));
							isvisited[node2.x][node2.y-1] = 1;
							++nodeCount;
						}
						
					}
					if (nodeCount>maxCollectionNum) {
						maxCollectionNum = nodeCount;
					}
					
					
				}	
					
				}
				
			}
			
			System.out.println(collectionCount + " " + maxCollectionNum);
			
			
		}
		
	}

}
class Node{
	public Node() {
		// TODO Auto-generated constructor stub
		
	}
	public Node(int x1,int y1){
		x = x1;
		y = y1;
	}
	public int x = 0;
	public int y = 0;
}
/*
﻿You are making “sky map” to represent constellation (group of starts) in the sky. 

In each element, 1 means star, 0 means empty.
And in a constellation, each start should have at least one connection with others via left/right/up/bottom.  

If two starts are located via diagonal, then
the two stars are not connected (belong to different constellation.) 


How many constellations are in your sky map, and what is the number of starts in the greatest constellation?

[Input]
There can be more than one test case in the input. 

The first line has T, the number of test cases. 

Then the totally T test cases are provided in the following lines (T<=10)

In each test case, the first line has an integer N(5 ≤ N ≤ 25), the size of map. 

The map is a square, and is represented as N x N matrix.

For next N lines, each contains each raw of the matrix

[Output]

For each test case, you should print the number of constellation and the number of starts in the greatest constellation separated by blank.
﻿ 

[I/O Example] 
Input
2
7
0 1 1 0 0 0 0
0 1 1 0 1 0 0
1 1 1 0 1 0 1
0 0 0 0 1 1 1
1 0 0 0 0 0 0
0 1 1 1 1 1 0
0 1 0 1 1 0 0
5
0 1 0 0 0
0 1 0 0 0
0 1 0 0 0
0 0 0 0 0
0 0 0 0 0
﻿ 

Output 

4 8

﻿1 3﻿

*/
