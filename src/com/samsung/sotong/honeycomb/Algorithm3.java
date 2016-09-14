package com.samsung.sotong.honeycomb;

import java.io.FileInputStream;
import java.util.Scanner;

public class Algorithm3 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//Scanner scanner = new Scanner(new FileInputStream("src/com/samsung/sotong/honeycomb/sample_input.txt"));
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while (T-->0) {
			int sizeLength = scanner.nextInt();
			int [][]originMatrix = new int[2*sizeLength-1][4*sizeLength-3];
			int [][]upToDownSum = new int[2*sizeLength-1][4*sizeLength-3];
			int [][]downToUpSum = new int[2*sizeLength-1][4*sizeLength-3];
			int []levelMaxVal = new int[2*sizeLength-1];
			int curValCount = sizeLength;
			for (int i = 0; i < 2*sizeLength-1; i++) {
				int step=0;
				int maxVal = 0;
				for (int j = 0; j < curValCount; j++) {
					int numTemp= scanner.nextInt();
					originMatrix[i][2*sizeLength-1-curValCount+step] = numTemp;
					
					//update up to down 
					if (i>0) {
						if (i<sizeLength) {
							int maxFatherVal = 0;
							if (j>0 && j<curValCount-1) {
								maxFatherVal = upToDownSum[i-1][2*sizeLength-2-curValCount+step]>upToDownSum[i-1][2*sizeLength-curValCount+step]?upToDownSum[i-1][2*sizeLength-2-curValCount+step]:upToDownSum[i-1][2*sizeLength-curValCount+step];
							}else if(j==0){
								maxFatherVal = upToDownSum[i-1][2*sizeLength-curValCount+step];
							}else {
								maxFatherVal = upToDownSum[i-1][2*sizeLength-2-curValCount+step];
							}
							upToDownSum[i][2*sizeLength-1-curValCount+step]=maxFatherVal+numTemp;
						}else {
							int maxFatherVal = upToDownSum[i-1][2*sizeLength-2-curValCount+step]>upToDownSum[i-1][2*sizeLength-curValCount+step]?upToDownSum[i-1][2*sizeLength-2-curValCount+step]:upToDownSum[i-1][2*sizeLength-curValCount+step];
							upToDownSum[i][2*sizeLength-1-curValCount+step]=maxFatherVal+numTemp;
						}
						
						
					}else {
						upToDownSum[i][2*sizeLength-1-curValCount+step] = numTemp;
					}
					if (numTemp>maxVal) {
						maxVal = numTemp;
					}
					step+=2;
					
				}
				
				levelMaxVal[i] = maxVal;
				if (i<sizeLength-1) {
					++curValCount;
				}else {
					--curValCount;
				}
				
			}
			
			curValCount = sizeLength;
			for (int i = 2*sizeLength-2; i>=0; --i) {
				int step=0;
				for (int j = 0; j < curValCount; j++) {
					int numTemp= originMatrix[i][2*sizeLength-1-curValCount+step];
					//update down to up 
					if (i<2*sizeLength-2) {
						if (i>=sizeLength-1) {
							int maxFatherVal = 0;
							if (j>0 && j<curValCount-1) {
								maxFatherVal = downToUpSum[i+1][2*sizeLength-2-curValCount+step]>downToUpSum[i+1][2*sizeLength-curValCount+step]?downToUpSum[i+1][2*sizeLength-2-curValCount+step]:downToUpSum[i+1][2*sizeLength-curValCount+step];
							}else if(j==0){
								maxFatherVal = downToUpSum[i+1][2*sizeLength-curValCount+step];
							}else {
								maxFatherVal = downToUpSum[i+1][2*sizeLength-2-curValCount+step];
							}
							downToUpSum[i][2*sizeLength-1-curValCount+step]=maxFatherVal+numTemp;
						}else {
							int maxFatherVal = downToUpSum[i+1][2*sizeLength-2-curValCount+step]>downToUpSum[i+1][2*sizeLength-curValCount+step]?downToUpSum[i+1][2*sizeLength-2-curValCount+step]:downToUpSum[i+1][2*sizeLength-curValCount+step];
							downToUpSum[i][2*sizeLength-1-curValCount+step]=maxFatherVal+numTemp;
						}
						
					}else {
						downToUpSum[i][2*sizeLength-1-curValCount+step] = numTemp;
					}
					step+=2;
					
				}
				
				if (i>sizeLength-1) {
					++curValCount;
				}else {
					--curValCount;
				}
			}
			
			int routeMaxSum = 0;
			curValCount = sizeLength;
			for (int i = 0; i < 2*sizeLength-1; i++) {
				int step=0;
				int levelMax = levelMaxVal[i];
				for (int j = 0; j < curValCount; j++) {
					//int numTemp= originMatrix[i][2*sizeLength-1-curValCount+step];
					int maxFatherTopVal = 0;
					int maxFatherDownVal = 0;
					if (i>0 && i<sizeLength-1) {
						
						if (j>0 && j<curValCount-1) {
							maxFatherTopVal = upToDownSum[i-1][2*sizeLength-2-curValCount+step]>upToDownSum[i-1][2*sizeLength-curValCount+step]?upToDownSum[i-1][2*sizeLength-2-curValCount+step]:upToDownSum[i-1][2*sizeLength-curValCount+step];
						}else if(j==0){
							maxFatherTopVal = upToDownSum[i-1][2*sizeLength-curValCount+step];
						}else {
							maxFatherTopVal = upToDownSum[i-1][2*sizeLength-2-curValCount+step];
						}
						maxFatherDownVal = downToUpSum[i+1][2*sizeLength-2-curValCount+step]>downToUpSum[i+1][2*sizeLength-curValCount+step]?downToUpSum[i+1][2*sizeLength-2-curValCount+step]:downToUpSum[i+1][2*sizeLength-curValCount+step];
					}else if(i>sizeLength-1 && i<2*sizeLength-2){
						if (j>0 && j<curValCount-1) {
							maxFatherDownVal = downToUpSum[i+1][2*sizeLength-2-curValCount+step]>downToUpSum[i+1][2*sizeLength-curValCount+step]?downToUpSum[i+1][2*sizeLength-2-curValCount+step]:downToUpSum[i+1][2*sizeLength-curValCount+step];
						}else if(j==0){
							maxFatherDownVal = downToUpSum[i+1][2*sizeLength-curValCount+step];
						}else {
							maxFatherDownVal = downToUpSum[i+1][2*sizeLength-2-curValCount+step];
						}
						maxFatherTopVal = upToDownSum[i-1][2*sizeLength-2-curValCount+step]>upToDownSum[i-1][2*sizeLength-curValCount+step]?upToDownSum[i-1][2*sizeLength-2-curValCount+step]:upToDownSum[i-1][2*sizeLength-curValCount+step];
						
					}else if(i==0){
						maxFatherDownVal = downToUpSum[i+1][2*sizeLength-2-curValCount+step]>downToUpSum[i+1][2*sizeLength-curValCount+step]?downToUpSum[i+1][2*sizeLength-2-curValCount+step]:downToUpSum[i+1][2*sizeLength-curValCount+step];
					}else if(i==sizeLength-1){
						if (j>0 && j<curValCount-1) {
							maxFatherTopVal = upToDownSum[i-1][2*sizeLength-2-curValCount+step]>upToDownSum[i-1][2*sizeLength-curValCount+step]?upToDownSum[i-1][2*sizeLength-2-curValCount+step]:upToDownSum[i-1][2*sizeLength-curValCount+step];
							maxFatherDownVal = downToUpSum[i+1][2*sizeLength-2-curValCount+step]>downToUpSum[i+1][2*sizeLength-curValCount+step]?downToUpSum[i+1][2*sizeLength-2-curValCount+step]:downToUpSum[i+1][2*sizeLength-curValCount+step];
						}else if(j==0){
							maxFatherTopVal = upToDownSum[i-1][2*sizeLength-curValCount+step];
							maxFatherDownVal = downToUpSum[i+1][2*sizeLength-curValCount+step];
						}else {
							maxFatherTopVal = upToDownSum[i-1][2*sizeLength-2-curValCount+step];
							maxFatherDownVal = downToUpSum[i+1][2*sizeLength-2-curValCount+step];
						}
					}else {
						maxFatherTopVal = upToDownSum[i-1][2*sizeLength-2-curValCount+step]>upToDownSum[i-1][2*sizeLength-curValCount+step]?upToDownSum[i-1][2*sizeLength-2-curValCount+step]:upToDownSum[i-1][2*sizeLength-curValCount+step];
					}
					
					if (maxFatherDownVal+maxFatherTopVal+levelMax>routeMaxSum) {
						routeMaxSum = maxFatherDownVal+maxFatherTopVal+levelMax;
					}
					
					step+=2;
				}
				if (i<sizeLength-1) {
					++curValCount;
				}else {
					--curValCount;
				}
			}
			System.out.println(routeMaxSum);
			
		}
		
		
	}

}


/**
 * solution
Here is an O(n) solution where n is the total number of points in the honeycomb matrix

First forget about the switching complication and  store two matrices ->
1st matrix (let us say "goDown") will store while we move from up to down row and updating current value if 
(value in original matrix + max parent value > current value in goDown   ) and similarly store another matrix " goUp" when we go down to up 

For example take 1st test case:
up To down matrix
      1      2     3 
   4     4     5     4

8     6   13    5    7 
  13   16   14   9
     19   17  18

down to up matrix

       17    18    19 
   15    16     16    10
12   10     14     6      9
   8       6       5      6
       3       1       4

Now to handle the switching in one row .. lets assume switch happens in kth row  and then we will vary k from 0 to R where R is no. of total rows 
Now we iterate over every element in kth  row and and update our answer only if a higher sum value is achieved by switching an element in kth row. our answer for that element "E"will be :   
(max of parents of E in upTo down matrix) + maximum value in Kth row + (max of child of E in down to Up matrix).

This simple approach will easily give 100/100 for this question 

 */
