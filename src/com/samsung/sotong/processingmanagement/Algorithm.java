package com.samsung.sotong.processingmanagement;

public class Algorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/*
Processing Management 
﻿



Assistant Manager Lee is on a visit to a factory run by a partner company. 

A machine is cutting steel plates that are different in length and width. 

However, a closer look found that the machine keeps operating only when the length and width of the steel plate it is cutting are equal or larger than those of the previous plate. 

Otherwise, he found it takes one minute to prepare the machine working again. 
After looking at the length and width of the steel plate ordered, time required for preparing the machine restarting if the order by which steel plate are cut is set could be reduced. 

To help the partner company, he immediately starts writing a program that sets the order of cutting steel plates to minimize the time required for the restart of the machine. How did he write? 

The steel plate cannot rotate and be mindful of the fact that when cutting a steel plate, it takes one minute to operate for the first time.






Time Limit : 2 sec (Java : 4 sec)




[Input]
There can be more than one test case in the input file. The first line has T, the number of test cases. 
Then the totally T test cases are provided in the following lines (T <= 10 )


In each test case, the first line has an integer N(1 ≤ N ≤ 5,000), the number of steel plate ordered.
In the second line, information on each steel plate Li, Wi is given. 
Li is the length of i-th steel plate, and Wi is the width of i-th steel plate. (1 ≤ Li, Wi ≤ 10,000)




[Output]

In the each line, output minimum time required for the machine to make all steel plates ordered. 




[I/O Example]

Input

2
5
4 9 5 2 2 1 3 5 1 4 
3
1 3 2 2 3 1




Output

2

3

*/