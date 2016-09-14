package com.samsung.sotong.grid;

import java.io.FileInputStream;
import java.util.Scanner;


public class Algorithm {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		//Scanner scanner = new Scanner(new FileInputStream("src/com/samsung/sotong/grid/sample_input.txt"));

		int T = scanner.nextInt();
		
		while (T-->0) {
			int N = scanner.nextInt();
			int resultVal = 0;
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < i; j++) {
					if (myGcd(i,j)==1) {
						++resultVal;
					}
				}
			}
			
			System.out.println(2*resultVal+3);
			
			
		}
		
		
	}

	private static int myGcd(int m,int n){
		if (m<n) {
			int temp = m;
			m = n;
			n = temp;
		}
		while (m%n!=0) {
			int temp = m%n;
			m = n;
			n = temp;
		}
		
		return n;
	}
}

/*
Grid 




When there are (N+1)×(N+1) numbers of grid spots having integer coordinates from 0 to N as below, create a program that calculate the number of other grid spots (x, y) you can see from the starting point (0, 0).
The meaning of ‘you can see’ is that the line connecting (0, 0) and (x, y) does not pass other grid spots except the two spots. 



Time limit: 1 second (java; 2 seconds)

[Input] 
Several test cases can be included in the inputs. T, the number of cases is given in the first row of the inputs. After that, the test cases as many as T (T ≤ 30) are given in a row. 
The grid size, N is given on the first row per each test case. (1 ≤ N ≤1000)

[Output]
Output the number of grid points (x, y) that you can see from the starting point on the first row per each test case.

[I/O Example]

Input 
3
2
4
231

Output
5

13
32549 

*/

/**
Solution:
i from 1-> N+1

j from 1 - > i

 

if gcd(i,j) == 1 count ++

 

we calculate only upper triangle, because its symmetry multiply by 2 and add 3(diagonal, xaxis, yaxis)

 

count*2 +3 is the answer.

 * 
 */
