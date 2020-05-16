package Problems;

import java.util.Arrays;

public class AbstractModel {
	public static void main(String[] args) {
//		int[] numbers = {1,2,3,0,0};
//		System.out.println(AbstractModel.isContinuous(numbers));
		
//		int num = AbstractModel.LastRemaining_Solution(10, 4);
//		System.out.println(AbstractModel.Sum_Solution(10));
		int sum = AbstractModel.Add(5, 7);
		System.out.println(sum);
	}
	
	/**
	 * �˿���˳��
	 * @param numbers
	 * @return
	 */
	public static boolean isContinuous(int [] numbers) {
		int len = numbers.length;
		int count = 0;
		if(len < 5)
			return false;
		Arrays.sort(numbers);
		for(int num:numbers) {
			if(num==0)
				count++;
		}
		for(int i = count;i<len-1;i++) {
			if(numbers[i]==numbers[i+1])
				return false;
			count-=(numbers[i+1]-numbers[i]-1);
		}
		if(count>=0) {
			return true;
		}else {
			return false;
		}
    }
	/**
	 * Լɪ������
	 * @param n
	 * @param m
	 * @return
	 */
	public static int LastRemaining_Solution(int n, int m) {
		if (n == 0)     /* ��������Ĵ��� */
	        return -1;
	    if (n == 1)     /* �ݹ鷵������ */
	        return 0;
	    return (LastRemaining_Solution(n - 1, m) + m) % n;
    }
	
	/**
	 * ��ɢ˼ά
	 * @param n
	 * @return
	 */
	public static int Sum_Solution(int n) {
        int sum = n;
        boolean b = (n>0) && (sum += Sum_Solution(n-1))>0;
        return sum;
    }
	
	public static int Add(int num1,int num2) {
//		while (num2 != 0) {
//			int temp = num1 ^ num2;
//			num2 = (num1 & num2) << 1;
//			num1 = temp;
//		}
//		return num1;

		return num2 == 0 ? num1 : Add(num1 ^ num2, (num1 & num2) << 1);
    }
	
	/**
	 * ��һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯���� 
	 * ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0
	 * @param str ����һ���ַ���,����������ĸ����,����Ϊ��
	 * @return
	 */
	public static int StrToInt(String str) {
        return 0;
    }
}
