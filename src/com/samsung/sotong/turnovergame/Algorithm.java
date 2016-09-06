package com.samsung.sotong.turnovergame;
import java.io.*;
/**
 * score:65
 * @author samsung
 *
 */
class Algorithm {
	public static void main(String args[]) throws Exception	{
		//Scanner sc = new Scanner(System.in);
		//sc = new Scanner(new FileInputStream("input.txt"));
		StreamTokenizer sc = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
//		StreamTokenizer sc = new StreamTokenizer(new BufferedReader(new InputStreamReader(new FileInputStream("src/com/samsung/sotong/turnovergame/sample_input.txt"))));
		sc.nextToken();
		int T = (int)sc.nval;
		if (T>30 || T<0) {
			return;
		}
		
//		Map<Integer, Integer> availToTurnTimesMap = new HashMap<Integer,Integer>();
		
		int []availToTurnTimesMap = new int[65536];
		for (int k = 0; k < availToTurnTimesMap.length; k++) {
			availToTurnTimesMap[k] = -1;
		}
		int fullWhite = 0;
		int fullBlack = 65535;
		int []turnPosToVal = new int[16];
		turnPosToVal[0] = getIntegerValByStrBinary("1100100000000000");
		turnPosToVal[1] = getIntegerValByStrBinary("1110010000000000");
		turnPosToVal[2] = getIntegerValByStrBinary("0111001000000000");
		turnPosToVal[3] = getIntegerValByStrBinary("0011000100000000");
		turnPosToVal[4] = getIntegerValByStrBinary("1000110010000000");
		turnPosToVal[5] = getIntegerValByStrBinary("0100111001000000");
		turnPosToVal[6] = getIntegerValByStrBinary("0010011100100000");
		turnPosToVal[7] = getIntegerValByStrBinary("0001001100010000");
		turnPosToVal[8] = getIntegerValByStrBinary("0000100011001000");
		turnPosToVal[9] = getIntegerValByStrBinary("0000010011100100");
		turnPosToVal[10] = getIntegerValByStrBinary("0000001001110010");
		turnPosToVal[11] = getIntegerValByStrBinary("0000000100110001");
		turnPosToVal[12] = getIntegerValByStrBinary("0000000010001100");
		turnPosToVal[13] = getIntegerValByStrBinary("0000000001001110");
		turnPosToVal[14] = getIntegerValByStrBinary("0000000000100111");
		turnPosToVal[15] = getIntegerValByStrBinary("0000000000010011");
		int []statusTurnTimes = new int[16];
		for (int i = 0; i < statusTurnTimes.length; i++) {
			statusTurnTimes[i] = 0;
		}
		int []statusVal = new int[16];
		for (int i = 0; i < statusVal.length; i++) {
			statusVal[i]=fullWhite;
		}
		availToTurnTimesMap[0]=0;
		availToTurnTimesMap[65535]=0;
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j <= i; j++) {
				int tempXORVal = statusVal[j]^turnPosToVal[i];
				statusVal[j]=tempXORVal;
				++statusTurnTimes[j];
				if (availToTurnTimesMap[tempXORVal]==-1 || availToTurnTimesMap[tempXORVal]>statusTurnTimes[j]) {
					availToTurnTimesMap[tempXORVal] = statusTurnTimes[j];
				}
			}
		}
		
		for (int i = 0; i < statusTurnTimes.length; i++) {
			statusTurnTimes[i] = 0;
		}
		for (int i = 0; i < statusVal.length; i++) {
			statusVal[i]=fullBlack;
		}
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j <= i; j++) {
				int tempXORVal = statusVal[j]^turnPosToVal[i];
				statusVal[j]=tempXORVal;
				++statusTurnTimes[j];
				if (availToTurnTimesMap[tempXORVal]==-1 || availToTurnTimesMap[tempXORVal]>statusTurnTimes[j]) {
					availToTurnTimesMap[tempXORVal] = statusTurnTimes[j];
				}
			}
		}
		
		
//		for (int k = 0; k < availToTurnTimesMap.length; k++) {
//			if (availToTurnTimesMap[k]!=-1) {
//				System.out.println("==>"+k+"====>"+availToTurnTimesMap[k]);	
//			}
//			
//		}
		
		for(int tc = 0; tc < T; tc++) {
			
			/**********************************
			*  Implement your algorithm here. *
			***********************************/
			char []charArr = new char[16];
			int charIndex=0;
			for(int i=0;i<4;++i){
				sc.nextToken();
				String rowString = sc.sval;
				if (rowString.length()!=4) {
					return;
				}
				char[] rowCharSet = rowString.toCharArray();
				for (int j = 0; j < rowCharSet.length; j++) {
					char c = rowCharSet[j];
					if (c=='w') {
						charArr[charIndex] = '0';
					}else {
						charArr[charIndex] = '1';
					}
					++charIndex;
				}
				
			}
			int currentNum = 0;
			
			for (int i = charArr.length-1; i >=0; --i) {
				char c = charArr[i];
				int bit = c-'0';
				currentNum+=bit*Math.pow(2, (15-i));
			}
			
			
			int tempTimes = availToTurnTimesMap[currentNum];
			if (tempTimes==-1) {
				System.out.println("impossible");
			}else {
				System.out.println(tempTimes);	
			}
			// Print the answer to standard output(screen).
		}
	}
	
	private static int getIntegerValByStrBinary(String str){
		int currentNum = 0;
		char []charArr = str.toCharArray();
		for (int i = charArr.length-1; i >=0; --i) {
			char c = charArr[i];
			int bit = c-'0';
			currentNum+=bit*Math.pow(2, (15-i));
		}
		
		return currentNum;
	}
	
}
/*
Turn Over Game As in , there is a 4×4 sized table. In a grid of the table, there are white or black stones. When you choose a position of stone randomly, four stones adjacent to the up, down, left and right sides of the stone will turn to the opposite color like turning a white stone to a black & a black stone to a white. Let’s suppose this process as a calculation.﻿﻿



Using such a calculation, you want to change all the stones on the table into all whites or all blacks. Find out the minimum operation count at this time. 

Time limit: 1 second (java: 2 seconds)

[Input]
Several test cases can be included in the inputs. T, the number of cases is given in the first row of the inputs. After that, the test cases as many as T (T ≤ 30) are given in a row. 
Table info is given without blank over four rows per each test case. Colors are indicated like white for ‘w’ and black for ‘b’.

[Output]
Output the minimum operation count to change all colors as white or black on the first row per each test case. If not possible, output ‘impossible’.

[I/O Example]
Input
2
bwwb
bbwb
bwwb
bwww
bwbw
wwww
bbwb
bwwb

Output
4
impossible 
*/