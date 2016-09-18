package com.samsung.sotong.vigneshandarrays;

public class Algorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
Vignesh and Arrays

Vignesh loves arrays a lot. That too, he likes subsets very much. He can solve almost every problem on arrays and subsets. His enemy Lakshmi has 

been waiting for a long time to take revenge on Vignesh. Fortunately for Lakshmi, he was given the task of setting questions for the ITRIX Onsite 

Programming Contest which offers an internship for the winner. Lakshmi doesn't want Vignesh to get an intern. So, he decides to set a difficult 

question on arrays. The question is "Given an array of size 'n'. You have to find the difference of the maximum and the minimum subset sum 

(excluding the null subset)". Vignesh needs your help. Can you help him get an internship ? 

Explanation:

An array of size 'n' has 2^n (2 to the power of n) subsets. In this problem, You have to find the sum of every subset (excluding null subset) and 

find the maximum and the minimum sum values. But you need to output only their difference (Maximum sum - Minimum sum).

Example:

Array: {1,2,3}

Subsets: {1}, {2}, {3}, {1,2}, {1,3}, {2,3}, {1,2,3}, {NULL}

Subset sums are : 1, 2, 3, 3, 4, 5, 6(Excluding null subset) 

{1} -> 1

{2} -> 2

{3} -> 3

{1,2} -> 1 + 2 = 3

{1,3} -> 1 + 3 = 4

{2,3} -> 2 + 3 = 5

{1,2,3} -> 1 + 2 + 3 = 6

Maximum subset sum: 6

Minimum subset sum: 1

Answer: Maximum - Minimum = 6 - 1 = 5

Input:

The first line consists of 't', the number of test cases.

Each testcase has two lines, the first line being 'n', the array size and the second line consists of the array.

Constraints:

1 <= t <= 100

1 <= n <= 50

-10^5 <= a[i] <= 10^5

Output:

For each testcase, output the required answer.

Example:

Input:

1

3

1 2 3

Output:

5

Vignesh loves arrays a lot. That too, he likes subsets very much. He can solve almost every problem on arrays and subsets. His enemy Lakshmi has been waiting for a long time to take revenge on Vignesh. Fortunately for Lakshmi, he was given the task of setting questions for the ITRIX Onsite Programming Contest which offers an internship for the winner. Lakshmi doesn't want Vignesh to get an intern. So, he decides to set a difficult question on arrays. The question is "Given an array of size 'n'. You have to find the difference of the maximum and the minimum subset sum (excluding the null subset)". Vignesh needs your help. Can you help him get an internship ? 




Explanation:

An array of size 'n' has 2^n (2 to the power of n) subsets. In this problem, You have to find the sum of every subset (excluding null subset) and find the maximum and the minimum sum values. But you need to output only their difference (Maximum sum - Minimum sum).




Example:

Array: {1,2,3}

Subsets: {1}, {2}, {3}, {1,2}, {1,3}, {2,3}, {1,2,3}, {NULL}

Subset sums are : 1, 2, 3, 3, 4, 5, 6(Excluding null subset) 

{1} -> 1

{2} -> 2

{3} -> 3

{1,2} -> 1 + 2 = 3

{1,3} -> 1 + 3 = 4

{2,3} -> 2 + 3 = 5

{1,2,3} -> 1 + 2 + 3 = 6




Maximum subset sum: 6

Minimum subset sum: 1

Answer: Maximum - Minimum = 6 - 1 = 5




Input:

The first line consists of 't', the number of test cases.

Each testcase has two lines, the first line being 'n', the array size and the second line consists of the array.




Constraints:

1 <= t <= 100

1 <= n <= 50

-10^5 <= a[i] <= 10^5




Output:

For each testcase, output the required answer in a new line.




Example:

Input:

1

3

1 2 3




Output:

5

*/