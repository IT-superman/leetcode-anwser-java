package com.acmcoder.jd.testtwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StreamTokenizer	sc = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while (StreamTokenizer.TT_EOF!=sc.nextToken()) {
			int dateNum = (int)sc.nval;
			sc.nextToken();
			int listNum = (int)sc.nval;
			sc.nextToken();
			int date = (int)sc.nval;
			sc.nextToken();
			int height = (int)sc.nval;
			boolean isAvailFlag = true;
			int isAvailLoopNum = 0;
			int maxHeight=0;
			for (int i = 1; i < listNum; i++) {
				sc.nextToken();
				int curDate = (int)sc.nval;
				sc.nextToken();
				int curHeight = (int)sc.nval;
				int interDate = curDate-date;
				int interHeight = curHeight-height;
				if (interHeight<0) {
					interHeight=(-interHeight);
				}
				if ((interDate-interHeight)<0){
					
					isAvailLoopNum = i;
					isAvailFlag = false;
					break;
				}
				int internDis = (interDate-interHeight)/2 ;
				int tempMax = height>curHeight?height:curHeight;
				if ((tempMax+internDis)>maxHeight) {
					maxHeight = tempMax+internDis;
				}
				
				date = curDate;
				height = curHeight;
						
				
			}
			
			if (isAvailFlag==false) {
				++isAvailLoopNum;
				for (; isAvailLoopNum < listNum; isAvailLoopNum++) {
					sc.nextToken();sc.nextToken();
				}
				System.out.println("IMPOSSIBLE");
			}else {
				System.out.println(maxHeight);
			}
			
			
		}
	}

}


/*
爬山
时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB
题目描述：
小B曾经酷爱网络游戏，整日通宵达旦的玩游戏，导致身体素质急剧下降，因此下决心痛改前非，远离一切电子产品，并通过远足爬山的方式改变生活方式并提高身体素质。由于担心对身体造成太大的负荷，他总是选择最平坦的路径，并记录每天的行程情况及达到的最高海拔，使得连续两天之间的海拔之差最多为一个单位。不幸的是，在行程结束时，他不小心掉进河里，造成部分记录信息遗失。他想知道自己行程中可能达到的最高海拔，你是否能够帮忙？
输入
输入有若干组，每组的第一行为空格分隔的两个整数n和m，1<=n<=10^8, 1<=m<=10^5，分别表示行程天数以及未遗失的记录数。随后紧跟m行，每行为空格分隔的两个整数d和h，1<=d<=n, 0<=h<=10^8，表示行程的第几天及当天达到的最高海拔。
输出
对每组输入，如果记录是可能的，则在单独的行中输出可能达到的最高海拔，否则输出字符串“IMPOSSIBLE”（不含引号）。

样例输入
8 2
2 0
7 0
8 3
2 0
7 0
8 3
样例输出
2
IMPOSSIBLE

Hint
第一天和最后一天的海拔可以是任何值。 
 */
