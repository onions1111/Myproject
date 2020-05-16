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
	 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
	 * ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
	 * ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
	 * @param array
	 * @return
	 */
	//������ֱ�ӵķ���
	//����˼���ǿ�������������ڵĻ����м��Ǹ���һ���ǣ�������ǰ���򣬽ⷨ�������ţ�
	//���ߡ�������ĸ���һ�����������������ܺ͡�
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
	 * ����n���������ҳ�������С��K������
	 * ��������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
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
	 * HZż������Щרҵ������������Щ�Ǽ����רҵ��ͬѧ��
	 * ��������鿪����,���ַ�����:�ڹ��ϵ�һάģʽʶ����,
	 * ������Ҫ��������������������,������ȫΪ������ʱ��,����ܺý����
	 * ����,��������а�������,�Ƿ�Ӧ�ð���ĳ������,�������Աߵ��������ֲ����أ�
	 * ����:{6,-3,-2,7,-15,1,2,2},����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)��
	 * ��һ�����飬��������������������еĺͣ���᲻�ᱻ������ס��(�������ĳ���������1)
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
	 * ���1~13��������1���ֵĴ���,�����100~1300��������1���ֵĴ�����
	 * Ϊ�����ر�����һ��1~13�а���1��������1��10��11��12��13
	 * ��˹�����6��,���Ƕ��ں�����������û���ˡ�
	 * ACMerϣ�����ǰ����,������������ձ黯,
	 * ���Ժܿ���������Ǹ�����������1���ֵĴ�������1 �� n ��1���ֵĴ�������
	 * @param n
	 * @return
	 
	public int NumberOf1Between1AndN_Solution(int n) {
		
	}*/
	
	/**
	 * ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
	 * ������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
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
