package com.samsung.sotong.symmetricmatrix;

public class Algorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/*
Symmetric Matrix 


Symmetric Matrix In contemporary business administration, mathematical tools are frequently applied in order to develop the business theory. 
Numerical approaches are widely applied in the most of business characteristics because the business theories can be expressed in numerically. 
Of course, the most of business theories can be expressed by just normal terms like a conservative way. 
But, by using the mathematical methods, you may realize that more logical and clear process of theoretical development can be possible. 
So let’s enjoy the math by Symmetric matrix

By using the first line with given input data, please output the matrix that is equal to its transpose
For example, the given input data is A B C D, and the Symmetric Matrix is as below






Time limit: 1 second

[Input]
In the first line, Input T, number of test case (T <= 10 )
In the second line, size of the matrix” N” is given (4 ≤ N ≤ 128, N must be High-radix exponent of 2)
In the third line, Space is separately given by number of N characteristics that is same with first line information

[Output]
Across the line for a given input of N to the first row, output the matrix that is diagonally symmetric matrix. 
At this time, symmetric matrix must be same with the given example. 
Each line data must be output separately as a empty 

[I/O Example]
Input
2
4
B a & 2
8
1 2 3 4 A C B D

Output
B a & 2
a B 2 &
& 2 B a 
2 & a B 

1 2 3 4 A C B D 
2 1 4 3 C A D B 
3 4 1 2 B D A C 
4 3 2 1 D B C A 
A C B D 1 2 3 4 
C A D B 2 1 4 3 
B D A C 3 4 1 2 
D B C A 4 3 2 1 

*/