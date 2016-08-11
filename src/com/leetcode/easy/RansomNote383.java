/*
 * Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters from  all  the  magazines,  write  a  function  that  will  return  true  if  the  ransom   note  can  be  constructed  from  the  magazines ;  otherwise,  it  will  return  false.   

Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
 */
package com.leetcode.easy;

public class RansomNote383 {
	public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.isEmpty()) {
			return true;
		}
		if (magazine.isEmpty()) {
			return false;
		}
        char[] ransomNodeChar = ransomNote.toCharArray();
        char[] magazineChar = magazine.toCharArray();
        int [] visited = new int[magazineChar.length];
        for (int i = 0; i < visited.length; i++) {
			visited[i] = 0;
		}
        for(char ransomChar:ransomNodeChar){
        	boolean flag = false;
        	for (int i = 0; i < magazineChar.length; i++) {
				char tempChar = magazineChar[i];
				if (tempChar==ransomChar && visited[i]==0) {
					flag = true;
					visited[i]=1;
					break;
				}
			}
        	
        	if (flag==false) {
				return false;
			}
        	
        }
		return true;
    }
}
