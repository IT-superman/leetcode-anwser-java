package com.samsung.sotong.turnovergame;
import java.io.*;

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



//////////////////////////////////
/*
 * 
import java.util.Scanner;

public class  Algorithm {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int nt=sc.nextInt();
		for(int i=0; i< nt; i++){
			char ch[]=new char[16];
			for(int j=0; j< 4; j++){
				char carr[]=sc.next().toCharArray();
				for(int k=0; k< carr.length; k++){
					ch[j*4 + k] = carr[k];
				}
			}
			int res = computeGame(ch, 0);
			if(res != 200){
				System.out.println(res);
			}else{
				System.out.println("impossible");
			}
			
		}
	}

	private static int computeGame(char[] ch, int pos) {
		int x = pos / 4;
		int y= pos % 4;
        if(isGameCompleted(ch)){
			return 0;
		}
		if(pos >=16){
			return 200;
		}
		
		
		int res1 = computeGame(ch, pos+1);
		change(ch, x, y);
		int res2 = computeGame(ch, pos+1)+1;
		change(ch, x, y);
		if(res1 > res2){
			res1 = res2;
		}
		return res1;
	}

	private static void change(char[] ch, int x, int y) {
		changeme(ch, x, y);
		changeme(ch, x-1, y);
		changeme(ch, x+1, y);
		changeme(ch, x, y-1);
		changeme(ch, x, y+1);
	}

	private static void changeme(char[] ch, int x, int y) {
		if(x < 0 || x > 3 || y < 0 || y > 3){
			return;
		}
		if(ch[x*4+y]=='b'){
			ch[x*4+y]='w';
		}else if(ch[x*4+y]=='w'){
			ch[x*4+y]='b';
		}
	}

	private static boolean isGameCompleted(char[] ch) {
		char c = ch[0];
		boolean flg = true;
		for(int i=1; i< 16; i++){
			if(ch[i] != c){
				flg = false;
				break;
			}
		}
		return flg;
	}

}

 */


/////////////////////////////////