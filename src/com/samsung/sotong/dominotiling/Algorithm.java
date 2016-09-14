package com.samsung.sotong.dominotiling;

public class Algorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/*
Domino Tiling

A domino means a shape in which sides of two unit rectangles are put together to each other. 

Domino tilting means to make a mosaic by filling a certain area of a flat plate with dominoes, leaving no empty space.

You are going to put 2x1 or 2x2 dominoes into an 2×N rectangle-shaped frame. 

Find the number of cases of how dominoes can be put into. 

Since the number of cases is too many, output the remainder after dividing by a given number M.




The following figure is an example of domino tiling in an 2x8 frame.﻿












Time limit : 2 second (Java : 4 sec)




[Input]

There can be more than one test case in the input file. The first line has T, the number of test cases. 
Then the totally T test cases are provided in the following lines (T ≤ 10)
In each test case, the first line has an integer N(1 ≤ N ≤ 100,000), the length of the width of the rectangle frame.
The next line, a number M (1 ≤ M ≤ 40000) is given for the mod operation.




[Output]
In the each line, output the remainder found after dividing the number of cases by.




[I/OExample]

Input
1
8
100




Output

71

*/