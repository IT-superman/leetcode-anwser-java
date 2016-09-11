package com.samsung.sotong.linecross;

import java.io.FileInputStream;
import java.util.Scanner;
/**
 * score:60
 * @author samsung
 *
 */
public class Algorithm {

	public static void main (String[] args) throws Exception{
		// TODO Auto-generated method stub
		//Scanner scanner = new Scanner(System.in);
		Scanner scanner = new Scanner(new FileInputStream("src/com/samsung/sotong/linecross/sample_input.txt"));
		int T = scanner.nextInt();
		for (int i = 0; i < T; i++) {
			double [][]position = new double[3][4];
			for (int j = 0; j < 3; j++) {
				for (int j2 = 0; j2 < 4; j2++) {
					position[j][j2]= scanner.nextDouble();
				}
			}
			double []A = position[0];
			double []B = position[1];
			double []C = position[2];
			if (isIntersect(A,B)&& !isIntersect(A,C) && !isIntersect(B,C)) {
				System.out.println("AB");
			}else if (isIntersect(B,C)&& !isIntersect(B,A) && !isIntersect(C,A)) {
				System.out.println("BC");
			}else if (isIntersect(A,C)&& !isIntersect(A,B) && !isIntersect(C,B)) {
				System.out.println("AC");
			}else if(!isIntersect(A,B) && !isIntersect(A,C) && !isIntersect(B,C)){
				System.out.println("X");
			}else {
				System.out.println("ABC");
			}
		}
		
	}

	private static boolean isIntersect(double []A,double []B){
		
		if (A[0]-A[2]==0) {
			if (B[0]-B[2]==0 && B[0]!=A[0]) {
				return false;
			}else if(B[0]-B[2]==0 && B[0]==A[0]){
				double minAY = Math.min(A[1], A[3]);
				double maxAY = Math.max(A[1], A[3]);
				double minBY = Math.min(B[1], B[3]);
				double maxBY = Math.max(B[1], B[3]);
				if (minAY>maxBY || minBY>maxAY) {
					return false;
				}else {
					return true;
				}
			}else {
				if ((A[1]-B[1]+(double)(B[1]-B[3])/(B[0]-B[2])*(B[0]-A[0]))*(A[3]-B[1]+(double)(B[1]-B[3])/(B[0]-B[2])*(B[0]-A[2]))<=0) {
					double minBX = Math.min(B[0], B[2]);
					double maxBX = Math.max(B[0], B[2]);
					if (A[0]>=minBX && A[0]<=maxBX) {
						return true;
					}else {
						return false;
					}
				}else {
					return false;
				}
			}
			
			
		}else if(B[0]-B[2]==0){
			if (A[0]-A[2]==0 && A[0]!=B[0]) {
				return false;
			}else if(A[0]-A[2]==0 && A[0]==B[0]){
				double minAY = Math.min(A[1], A[3]);
				double maxAY = Math.max(A[1], A[3]);
				double minBY = Math.min(B[1], B[3]);
				double maxBY = Math.max(B[1], B[3]);
				if (minAY>maxBY || minBY>maxAY) {
					return false;
				}else {
					return true;
				}
			}else {
				if ((B[1]-A[1]+(double)(A[1]-A[3])/(A[0]-A[2])*(A[0]-B[0]))*(B[3]-A[1]+(double)(A[1]-A[3])/(A[0]-A[2])*(A[0]-B[2]))<=0) {
					double minAX = Math.min(A[0], A[2]);
					double maxAX = Math.max(A[0], A[2]);
					if (B[0]>=minAX && B[0]<=maxAX) {
						return true;
					}else {
						return false;
					}
				}else {
					return false;
				}
			}
			
		}else if ((B[1]-A[1]+(double)(A[1]-A[3])/(A[0]-A[2])*(A[0]-B[0]))*(B[3]-A[1]+(double)(A[1]-A[3])/(A[0]-A[2])*(A[0]-B[2]))<=0) {
			if ((A[1]-B[1]+(double)(B[1]-B[3])/(B[0]-B[2])*(B[0]-A[0]))*(A[3]-B[1]+(double)(B[1]-B[3])/(B[0]-B[2])*(B[0]-A[2]))<=0) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
		
		
	}
}


/*
Line Cross 
 In given coordinates of three lines, A, B and C, create a program that finds out whether these lines are connected or not. Let’s suppose the lines are crossed when two lines are touched or crossed each other.

Time limit: 1 second (java: 2 seconds)

[Input]
Several test cases can be included in the inputs. T, the number of cases is given in the first row of the inputs. After that, the test cases as many as T (T ≤ 30) are given in a row. 
The starting points (x1, y1) & arriving points (x2, y2) of the line A are given on the first row per each test case.
The starting points (x1, y1) & arriving points (x2, y2) of the line B are given on the second row. 
The starting points (x1, y1) & arriving points (x2, y2) of the line C are given on the third row. 

[Output]
Output one of X, AB or BC depending on whether lines are connected or not on the first row of each test case. 



[I/O Example] 
Input
2
2 3 7 8
2 7 7 5
4 2 9 4
5 7 17 13
1 9 6 2
9 12 14 18

Output

AB

X


*/