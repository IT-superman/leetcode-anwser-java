package com.samsung.sotong.rjlovesys;
/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/*
   As the name of the class should be Algorithm , using Algorithm.java as the filename is recommended.
   In any case, you can execute your program by running 'java Algorithm' command.
 */
class Algorithm {
	static List<String> AnswerStrList = new ArrayList<String>();
	
	public static void main(String args[]) throws Exception	{
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */		

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
		
		
		long startTime = new Date().getTime();
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		int T = sc.nextInt();
		if (T<1 || T>10) {
			return;
		}
		sc.nextLine();
		List<String> inputList = new ArrayList<String>();
		for(int test_case = 0; test_case < T; test_case++) {
			String anagram = sc.nextLine();
			inputList.add(anagram);
		}
		if (T!=inputList.size()) {
			return;
		}
		for(int test_case = 0; test_case < T; test_case++) {
			String anagram = inputList.get(test_case);
			char[] charSet = anagram.toCharArray();
			if (anagram.length()<1 || anagram.length()>7) {
				return;
			}
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////
			// Answer = 0;
			
			AnswerStrList.clear();

			getAllPermutation(charSet,0);
			
			int lengthTemp = AnswerStrList.size();
			for(int i=0;i<lengthTemp;++i){
				for(int j=0;j<lengthTemp-i-1;++j){
					if (AnswerStrList.get(j).compareTo(AnswerStrList.get(j+1))>0) {
						String tempStr = AnswerStrList.get(j);
						AnswerStrList.set(j, AnswerStrList.get(j+1));
						AnswerStrList.set(j+1, tempStr);
					}
				}
			}
			
			
			// Print the answer to standard output(screen).
			for(int i=0;i<AnswerStrList.size();++i){
				System.out.println(AnswerStrList.get(i));
			}
			System.out.println();
		}
		
		
		long endTime = new Date().getTime();
		long usedTimeSec = (endTime-startTime)/1000;
		System.out.println("used time :"+usedTimeSec);
	}
	
	private static void getAllPermutation(char []charSet,int index){
		
		if (index==charSet.length-1) {
			String strTemp = String.valueOf(charSet);
			AnswerStrList.add(strTemp);
			return;
		}
		
		for (int i = index; i < charSet.length; i++) {
			swap(charSet,index,i); 
			getAllPermutation(charSet,index+1);
			swap(charSet,index,i); 
		}
		
		
	}
	
	private static void swap(char []charSet,int i,int j){
		if (i<0 || i>=charSet.length || j<0 || j>=charSet.length) {
			return;
		}
		char tempChar = charSet[i];
		charSet[i]= charSet[j];
		charSet[j] = tempChar;
	}
	
}

