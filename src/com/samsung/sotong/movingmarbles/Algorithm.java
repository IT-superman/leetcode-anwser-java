package com.samsung.sotong.movingmarbles;
/**
 * Moving Marbles There are several pockets containing marbles. Each pocket has different numbers of marbles. How many times you move to make every pocket with the equal number of marbles by the minimum movement? Create a program to solve this problem.

Time limit: 1 second (java: 2 seconds)

[Input]
Several test cases can be included in the inputs. T, the number of cases is given in the first row of the inputs. After that, the test cases as many as T (T ≤ 30) are given in a row. 
The number of pockets, N is given on the first row per each test case. (2 ≤ N ≤ 32000)
The number of marbles containing each pocket is given from the second row to the row of N numbers. The maximum number of marbles is 32,000 in each pocket. 

[Output]
Output the minimum number of moving marbles to make the number of marbles in several pockets equal on the first row of each test case. If you cannot equalize the number of marbles in all pockets, output -1. 

[I/O Example]
Input
2
5
1
1
1
1
6
2
1
3

Output
4
1 
 * @author samsung
 *
 */
//In Practice, You should use the statndard input/output
//in order to receive a score properly.
//Do not use file input and output. Please be very careful. 

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Algorithm {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("src/com/samsung/sotong/movingmarbles/sample_input.txt"));

		int T = sc.nextInt();
		if (T>30 || T<=0) {
			return;
		}
		List<Integer> resultVal = new ArrayList<Integer>();
		for(int tc = 0; tc < T; tc++) {
			
			int pocketsNum = sc.nextInt();
			if (pocketsNum<2 || pocketsNum>32000) {
				return;
			}
			int sumMables = 0;
			List<Integer> mablesVal = new ArrayList<Integer>();
			for (int i = 0; i < pocketsNum; i++) {
				int mablesNum = sc.nextInt();
				if (mablesNum>32000 || mablesNum<0) {
					return;
				}
				mablesVal.add(mablesNum);
				sumMables+=mablesNum;
			}
			int restNum = sumMables%pocketsNum;
			if (restNum==0) {
				int equalNum = sumMables/pocketsNum;
				int sumMovingTimes = 0;
				for(int i=0;i<pocketsNum;i++){
					int mables = mablesVal.get(i);
					if(mables>equalNum){
						sumMovingTimes+=(mables-equalNum);
					}
				}
				resultVal.add(sumMovingTimes);
			}else{
				resultVal.add(-1);
			}
			
			/**********************************
			*  Implement your algorithm here. *
			***********************************/
			
			// Print the answer to standard output(screen).

		}
		
		for(int tc = 0; tc < T; tc++) {
			System.out.println(resultVal.get(tc));
		
		}
		
	}
}

