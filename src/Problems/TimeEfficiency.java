package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

public class TimeEfficiency {
	public static void main(String[] args) {
//		int[] a = {1,2,3,2,3,3,5,3,3};
//		int num = TimeEfficiency.MoreThanHalfNum_Solution(a);
//		System.out.println(num);
		
//		int[] input = {4,5,1,6,2,7,3,8};
//		ArrayList<Integer> list = TimeEfficiency.GetLeastNumbers_Solution(input, 10);
//		System.out.println(list);
		
//		int[] a = {6,-3,-2,7,-15,1,2,2};
//		int max = TimeEfficiency.FindGreatestSumOfSubArray(a);
//		System.out.println(max);
		
		int a = 4;
		int b =33;
		String sa = String.valueOf(a);
		String sb = String.valueOf(b);
		String num = TimeEfficiency.PrintMinNumber(new int[]{});
		System.out.println(num);
	}
	/**
	 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
	 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
	 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
	 * @param array
	 * @return
	 */
	//这是最直接的方法
	//还有思想是可先排序，如果存在的话，中间那个数一定是（但是提前排序，解法不是最优）
	//或者“这个数的个数一定超过其他个数的总和”
	public static int MoreThanHalfNum_Solution(int [] array) {
        int len = array.length;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i:array) {
        	if(!map.containsKey(i)) {
        		map.put(i,1);
        	}else {
        		int temp = map.get(i);
        		map.put(i, temp+1);
        	}
        }
        Set<Integer> keys = map.keySet();
        for(int key:keys) {
        	if(map.get(key) > len/2)
        		return key;
        }
        
        return 0;
    }
	
	/**
	 * 输入n个整数，找出其中最小的K个数。
	 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
	 * @param input
	 * @param k
	 * @return
	 */
	public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(input.length == 0 || k > input.length)
			return list;
		Arrays.sort(input);
		for(int i = 0;i < k;i++) {
			list.add(input[i]);
		}
		return list;
	}
	
	/**
	 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
	 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,
	 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
	 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
	 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
	 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
	 * @param array
	 * @return
	 */
	public static int FindGreatestSumOfSubArray(int[] array) {
        int Max = array[0];
        int sum = 0;
        for(int num : array) {
        	if(sum < 0) {
        		sum = num;
        	}else {
        		sum += num;
        	}
        	Max = Math.max(sum, Max);
        }
        return Max;
    }
	
	/**
	 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
	 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13
	 * 因此共出现6次,但是对于后面问题他就没辙了。
	 * ACMer希望你们帮帮他,并把问题更加普遍化,
	 * 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
	 * @param n
	 * @return
	 
	public int NumberOf1Between1AndN_Solution(int n) {
		
	}*/
	
	/**
	 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
	 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
	 * @param numbers
	 * @return
	 */
	public static String PrintMinNumber(int [] numbers) {
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
