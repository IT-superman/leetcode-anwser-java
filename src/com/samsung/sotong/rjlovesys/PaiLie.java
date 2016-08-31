package com.samsung.sotong.rjlovesys;

import java.util.Date;

public class PaiLie {  
    
    public void runPermutation(int[] a){  
        getAllPermutation(a, 0);  
    }  
    /*index用于控制如上述分析中2加上13的所有全列的*/  
    public void getAllPermutation(int[] a,int index){  
  
        /*与a的元素个数相同则输出*/  
        if(index == a.length-1){  
            for(int i = 0; i < a.length; i++){  
                System.out.print(a[i] + " ");  
            }  
            System.out.println();  
            return;  
        }  
          
        for(int i = index; i < a.length; i++){  
              
            swap(a ,index, i);  
            getAllPermutation(a, index+1);  
            swap(a ,index, i);  
        }  
    }  
    public void swap(int[] a, int i, int j) {  
      
        int temp = a[i];  
        a[i] = a[j];  
        a[j] = temp;  
    }  
  
    public static void main(String[] args) {  
          
    	long startTime = new Date().getTime();
        PaiLie robot = new PaiLie();  
        int[] a = {3,2,1};  
        robot.runPermutation(a);  
        long endTime = new Date().getTime();
        long usedTime =  (endTime-startTime)/1000;
System.out.println("used Time ===>" + usedTime);        
    }  
}  