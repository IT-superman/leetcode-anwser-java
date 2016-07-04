package com.leetcode.easy;
/*
 * Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInteger_13 {

	public int getValByChar(char ch){
		switch (ch) {
		case 'I': return 1;
		case 'V': return 5;
		case 'X': return 10;
		case 'L': return 50;
		case 'C': return 100;
		case 'D': return 500;
		case 'M': return 1000;
		default:return 0;
		}
	}
	
	
public int romanToInt(String s) {
        
		if (s.isEmpty()) {
			return 0;
		}
		
		int subCh = getValByChar(s.charAt(0));
		int lastCh = subCh;
		int resultVal = 0;
		for (int i = 1; i < s.length(); i++) {
			
			int curCh = getValByChar(s.charAt(i));
			if (curCh == lastCh) {
				subCh+=curCh;
			} else if(curCh<lastCh){
				resultVal+=subCh;
				subCh = curCh;
			}else {
				subCh = curCh-subCh;
			}
			lastCh = curCh;
			
			
		}
		
		resultVal+=subCh;
		return resultVal;
		
    }
	
}
/*
Rule: 

从前往后扫描，用一个临时变量记录分段数字。

如果当前处理的字符对应的值和上一个字符一样，那么临时变量加上这个字符。比如III = 3
如果当前比前一个大，说明这一段的值应该是当前这个值减去前面记录下的临时变量中的值。比如IIV = 5 – 2
如果当前比前一个小，那么就可以先将临时变量的值加到结果中，然后开始下一段记录。比如VI = 5 + 1
*/