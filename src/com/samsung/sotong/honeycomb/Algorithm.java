package com.samsung.sotong.honeycomb;

public class Algorithm {

}

/*
shows a honeycomb with length 3 on a side. When it calls a figure-written circle a node, a method to move from the current node to the next is to move down left or down right diagonally. ﻿




Find the highest sum of nodes starting from the top node to the bottom node. There is a chance to change a figure only once in the same row while you go down. Using this chance, find out the maximum sum of routes from the top node to the bottom node.

Time limit: 1 second (java: 2 seconds)

[Input]
Several test cases can be included in the inputs. T, the number of cases is given in the first row of the inputs. After that, the test cases as many as T (T ≤ 30) are given in a row. 
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