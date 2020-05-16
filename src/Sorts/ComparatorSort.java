package Sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorSort {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("beijing");
		list.add("shanghai");
		list.add("hangzhou");
		list.add("baidu");
		Collections.sort(list, new Comparator<String>() {
			public int compare(String str1, String str2) {

		/**
		��* �����ŵĻ����ǵ�һ������.compareTo(�ڶ�������);
		��* �����ŵĻ����ǵڶ�������.compareTo(��һ������);
		*/

		// ������ĸ������
		return str1.compareTo(str2);
		// ���ڶ�����ĸ������
//				char c1 = str1.charAt(1);
//				char c2 = str2.charAt(1);
//				return c1 - c2;
				}
		});
		System.out.println(list);
		
		int[] numbers = {3,32,321};
		String sortlist = ComparatorSort.PrintMinNumber(numbers);
		System.out.println(sortlist);
	}
	
	/*
	 * ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
	 * ������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
	 */
	public static String PrintMinNumber(int [] numbers) {
        //���ֵ��ַ���ƴ��
        ArrayList<Integer> list = new ArrayList<Integer>();
		if(numbers.length==0)
			return "";
		for(int i:numbers) {
			list.add(i);
		}
		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer str1,Integer str2){
				   String s1=str1+""+str2;
				   String s2=str2+""+str1;
				         return s1.compareTo(s2);
				     }
		});
		String num =list.get(0)+"";
		
		for(int i=1;i<list.size();i++) {
			num = num+""+list.get(i);
		}
		return num;
	}
}
