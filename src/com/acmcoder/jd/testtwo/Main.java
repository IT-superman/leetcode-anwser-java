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
��ɽ
ʱ�����ƣ�C/C++���� 1000MS���������� 3000MS
�ڴ����ƣ�C/C++���� 65536KB���������� 589824KB
��Ŀ������
СB�����ᰮ������Ϸ������ͨ���ﵩ������Ϸ�������������ʼ����½�������¾���ʹ��ǰ�ǣ�Զ��һ�е��Ӳ�Ʒ����ͨ��Զ����ɽ�ķ�ʽ�ı����ʽ������������ʡ����ڵ��Ķ��������̫��ĸ��ɣ�������ѡ����ƽ̹��·��������¼ÿ����г�������ﵽ����ߺ��Σ�ʹ����������֮��ĺ���֮�����Ϊһ����λ�����ҵ��ǣ����г̽���ʱ������С�ĵ��������ɲ��ּ�¼��Ϣ��ʧ������֪���Լ��г��п��ܴﵽ����ߺ��Σ����Ƿ��ܹ���æ��
����
�����������飬ÿ��ĵ�һ��Ϊ�ո�ָ�����������n��m��1<=n<=10^8, 1<=m<=10^5���ֱ��ʾ�г������Լ�δ��ʧ�ļ�¼����������m�У�ÿ��Ϊ�ո�ָ�����������d��h��1<=d<=n, 0<=h<=10^8����ʾ�г̵ĵڼ��켰����ﵽ����ߺ��Ρ�
���
��ÿ�����룬�����¼�ǿ��ܵģ����ڵ���������������ܴﵽ����ߺ��Σ���������ַ�����IMPOSSIBLE�����������ţ���

��������
8 2
2 0
7 0
8 3
2 0
7 0
8 3
�������
2
IMPOSSIBLE

Hint
��һ������һ��ĺ��ο������κ�ֵ�� 
 */
