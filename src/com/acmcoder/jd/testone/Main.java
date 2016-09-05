package com.acmcoder.jd.testone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;		
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		StreamTokenizer sc = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		sc.nextToken();
		int testCaseNum = (int)sc.nval;
		if (testCaseNum>1000) {
			return;
		}
		for (int i = 0; i < testCaseNum; i++) {
			sc.nextToken();
			long luckNum = (long)sc.nval;
			luckNum++;
			StringBuffer resultStrBuf = new StringBuffer();
			while(luckNum>1){
				if (luckNum%2!=0) {
					resultStrBuf.append("7");
				}else {
					resultStrBuf.append("4");
				}
				luckNum=luckNum/2;
			}
			resultStrBuf.reverse();
			String result = resultStrBuf.toString();
System.out.println(result);
			
			
		}
		
	}

}
