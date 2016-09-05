package com.acmcoder.exercise.stockgod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StreamTokenizer sc = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while (StreamTokenizer.TT_EOF!=sc.nextToken()) {
			int inputTimes = (int) sc.nval;
			int internAdd = 1;
			int currentAddIndex = 0;
			int stockVal = 1;
			for (int i = 1; i <= inputTimes-1; i++) {
				++currentAddIndex;
				if (currentAddIndex==internAdd+1) {
					--stockVal;
					currentAddIndex = 0;
					++internAdd;
				}else {
					++stockVal;
				}
			}
			System.out.println(stockVal);
			
		}
		
	}

	
	
}
