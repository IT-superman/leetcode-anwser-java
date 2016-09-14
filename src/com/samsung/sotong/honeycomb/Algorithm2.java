package com.samsung.sotong.honeycomb;

import java.io.FileInputStream;
import java.util.*;

public class Algorithm2 {

	private static int maxRouteNodeCountValue = 0;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new FileInputStream("src/com/samsung/sotong/honeycomb/sample_input.txt"));

		//Scanner scanner = new Scanner(System.in);
		int T = Integer.valueOf(scanner.nextLine().trim());
		while(T-->0){
			int combLength = Integer.valueOf(scanner.nextLine().trim());
			int[][] combArr = new int[2*combLength-1][2*combLength-1];
			int [] levelMaxNum = new int[2*combLength-1];
			int [] levelNumCount = new int[2*combLength-1];
			for (int i = 0; i < 2*combLength-1; i++) {
				String[] numStrArr = scanner.nextLine().trim().split(" ");
				levelNumCount[i] = numStrArr.length;
				int maxNum = 0;
				for (int j = 0; j < numStrArr.length; j++) {
					int intVal = Integer.valueOf(numStrArr[j]);
					combArr[i][j] = intVal;
					if (intVal>maxNum) {
						maxNum = intVal;
					}
				}
				levelMaxNum[i] = maxNum;
				
				
				
			}
			System.out.println("struct finished！");
			maxRouteNodeCountValue = 0;
			for (int i = 0; i < levelNumCount[0]; i++) {
				
				caculateMutiRoute(combArr,levelMaxNum,levelNumCount,0,i,0,0);
				
			}
			System.out.println(maxRouteNodeCountValue);
			
		}
		
		
	}

	private static void caculateMutiRoute(int [][]comb,int []levelMaxNum,int [] levelNumCount,int curIndexRow,int curIndexCol,int nodeValSum,int maxSub){
		if (curIndexRow>=levelNumCount.length) {
			return;
		}
		if (curIndexCol<0 || curIndexCol>=levelNumCount[curIndexRow]) {
			return;
		}
		int curNodeVal = comb[curIndexRow][curIndexCol];
		nodeValSum+=curNodeVal;
		if (levelMaxNum[curIndexRow]-curNodeVal>maxSub) {
			maxSub = levelMaxNum[curIndexRow]-curNodeVal;
		}
		
		if (curIndexRow==levelNumCount.length-1) {
			nodeValSum+=maxSub;
			if (nodeValSum>maxRouteNodeCountValue) {
				maxRouteNodeCountValue = nodeValSum;
				System.out.println("==>"+maxRouteNodeCountValue);
			}
			
			return;
		}
		
		
		caculateMutiRoute(comb,levelMaxNum,levelNumCount,curIndexRow+1,curIndexCol,nodeValSum,maxSub);
		if (curIndexRow<levelNumCount.length/2) {
			caculateMutiRoute(comb,levelMaxNum,levelNumCount,curIndexRow+1,curIndexCol+1,nodeValSum,maxSub);
		}else {
			caculateMutiRoute(comb,levelMaxNum,levelNumCount,curIndexRow+1,curIndexCol-1,nodeValSum,maxSub);
		}
		
		
	}
	
	
}
