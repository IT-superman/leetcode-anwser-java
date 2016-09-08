package com.samsung.sotong.topsofheads;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;
/**
 * score:100
 * @author samsung
 *
 */
public class Algorithm3 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		//Scanner scanner = new Scanner(new FileInputStream("src/com/samsung/sotong/topsofheads/sample_input.txt"));
		int T = scanner.nextInt();
		for (int i = 0; i < T; i++) {
			int staffNum = scanner.nextInt();
			int sumTaller = 0;
			Stack<Integer> tallerStack = new Stack<Integer>();
			for (int j = 0; j < staffNum; j++) {
				int tempHeight = scanner.nextInt();
				while (!(tallerStack.isEmpty()) && tallerStack.peek()<=tempHeight) {
					tallerStack.pop();
				}
				sumTaller+=tallerStack.size();
				tallerStack.push(tempHeight);
			}
			System.out.println(sumTaller);
		}
	}

}
