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
	 * 扑克牌顺子
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
	 * 约瑟夫环问题
	 * @param n
	 * @param m
	 * @return
	 */
	public static int LastRemaining_Solution(int n, int m) {
		if (n == 0)     /* 特殊输入的处理 */
	        return -1;
	    if (n == 1)     /* 递归返回条件 */
	        return 0;
	    return (LastRemaining_Solution(n - 1, m) + m) % n;
    }
	
	/**
	 * 发散思维
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
	 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 
	 * 数值为0或者字符串不是一个合法的数值则返回0
	 * @param str 输入一个字符串,包括数字字母符号,可以为空
	 * @return
	 */
	public static int StrToInt(String str) {
        return 0;
    }
}
