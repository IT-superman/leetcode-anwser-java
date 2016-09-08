package com.samsung.sotong.topsofheads;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * score：60 time limit
 * @author samsung
 *
 */
public class Algorithm2 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		//Scanner scanner = new Scanner(new FileInputStream("src/com/samsung/sotong/topsofheads/sample_input.txt"));
		int T = Integer.valueOf(scanner.next());
		for (int i = 0; i < T; i++) {
			int staffNum = scanner.nextInt();
			int sumTaller = 0;
			int []heightarr = new int[staffNum];
			List<Integer> tallerHeight = new ArrayList<Integer>();
			for (int j = 0; j < staffNum; j++) {
				int tempHeight = scanner.nextInt();
				heightarr[j] = tempHeight;
				for (int k = 0; k < tallerHeight.size(); k++) {
					if (tallerHeight.get(k)>tempHeight) {
						++sumTaller;
					}
					else {
						tallerHeight.remove(k);
						--k;
					}
				}
				tallerHeight.add(tempHeight);
				
				
			}
			System.out.println(sumTaller);
			
		}
		
		
	}

}
