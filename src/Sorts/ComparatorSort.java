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
		　* 升序排的话就是第一个参数.compareTo(第二个参数);
		　* 降序排的话就是第二个参数.compareTo(第一个参数);
		*/

		// 按首字母升序排
		return str1.compareTo(str2);
		// 按第二个字母升序排
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
	 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
	 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
	 */
	public static String PrintMinNumber(int [] numbers) {
        //数字的字符串拼接
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
