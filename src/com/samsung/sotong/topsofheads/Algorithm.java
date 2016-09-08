package com.samsung.sotong.topsofheads;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * score:90 time limit
 * @author samsung
 *
 */
public class Algorithm {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		//Scanner scanner = new Scanner(new FileInputStream("src/com/samsung/sotong/topsofheads/sample_input.txt"));
		int T = Integer.valueOf(scanner.next());
		for (int i = 0; i < T; i++) {
			int staffNum = scanner.nextInt();
			int sumTaller = 0;
			int []heightarr = new int[staffNum];
			for (int j = 0; j < staffNum; j++) {
				heightarr[j] = scanner.nextInt();
			}
			for (int j = 0; j < staffNum-1; j++) {
				int curHeight = heightarr[j];
				int loopIndex = j+1;
				int nextHeight = heightarr[loopIndex];
				int curTallerNum = 0;
				while (curHeight>nextHeight && loopIndex<staffNum) {
					++curTallerNum;
					++loopIndex;
					if (loopIndex<staffNum) {
						nextHeight = heightarr[loopIndex];
					}
					
				}
				sumTaller+=curTallerNum;
			}
			
			System.out.println(sumTaller);
			
		}
		
	}

}

/*
Tops of Heads 
N numbers of staffs stand in a row. Because everyone’s height is different, some staffs can see tops of heads of colleagues but other can’t. The same height can’t see each other tops of the heads.﻿





﻿ shows the different heights of 6 staffs. At this moment, when everyone stands watching the right side, No. 1 staff can see the tops of the heads of No. 2, 3, & 4 people but can’t for that of No. 6 staff even though No. 1 staff is taller than No.6 staff because of being hidden by No. 5 staff. In given heights of all staffs, figure out how many staffs can see the crowns of other heads.

Time limit: 1 second (jave: 2 seconds)

[Input]
Several test cases can be included in the inputs. T, the number of cases is given in the first row of the inputs. After that, the test cases as many as T (T ≤ 30) are given in a row. 
N, the number of staffs is given in the first row of each test case. (1 ≤ N ≤ 80000)
H, the height of each staff is given from the second row to the number of N. (1 ≤ H ≤ 1,000,000,000)

[Output]
Output the sum number of staffs who can see other staffs’ tops of heads in the first row of each test case. 

[I/O Example]

 Input 
2
6
10
3
7
4
12
2
10
999999999
2
999999999
2
999999999
2
999999999
2
999999999
2

Output
5
5 

*/