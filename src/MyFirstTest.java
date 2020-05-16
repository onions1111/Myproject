import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.junit.jupiter.api.Test;

import test.ListNode;
import test.TreeNode;

public class MyFirstTest {

	public static void main(String[] args) {
//		int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//		boolean result = MyFirstTest.Find(16, array);
//		System.out.println(result);
//		String str1 = "we are happy";
//		StringBuffer bs = new StringBuffer();
//		bs.append("we are happy");
//		
//		System.out.println(replaceSpace(bs));

//		int[] a  = {2,3,1,0,2,5,3};
//		boolean flag = duplicate(a,7,new int[1]);
//		System.out.println(flag);

//		ListNode l = new ListNode(1);
//		ListNode m = new ListNode(2);
//		ListNode n = new ListNode(3);
//		l.next = m;
//		m.next = n;
//		ArrayList<Integer> array = new ArrayList<Integer>();
//		array = printListFromTailToHead(l);
//
//		for (Integer integer : array) {
//			System.out.println(integer);
//		}
		
//		int[] pre ={1,2,4,7,3,5,6,8};
//		int[] in ={4,7,2,1,5,3,8,6};
//		TreeNode root = reConstructBinaryTree(pre,in);
//		int[] copyOfRange = Arrays.copyOf(pre,3);
//		for (int i : copyOfRange) {
//			System.out.println(i);
//		}
		
//		int[] a = {2,2,1,1,2,2};
//		int min = minNumberInRotateArray(a);
//		System.out.println(min);
		
		int sum = Fibonacci(20);
		System.out.println(sum);

	}

	/**
	 * ��ѯ��ά�������Ƿ���target���� ��ά��������Ҵ��ϵ������ε���
	 */
	public static boolean Find(int target, int[][] array) {
		boolean flag = false;
		int row = array.length;
		int col = array[0].length;

		int i = 0, j = col - 1;
		while (i < row && i >= 0 && j >= 0 && j < col) {
			if (array[i][j] > target) {
				j--;
			} else if (array[i][j] < target) {
				i++;
			} else {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/**
	 * ��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20���� ���磬���ַ���ΪWe Are
	 * Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
	 */
	public static String replaceSpace(StringBuffer str) {
		// return str.toString().replaceAll(" ", "%20");
		if (str == null) {
			return null;
		}
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				str.replace(i, i + 1, "%20");
			}
		}
		String newstr = str.toString();
		return newstr;
	}

	/**
	 * 
	 * ��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�
	 * Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡�
	 * ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
	 * 
	 * @param numbers
	 * @param length
	 * @param duplication
	 * @return
	 */
	public static boolean duplicate(int numbers[], int length, int[] duplication) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < length; i++) {
			if (!map.containsKey(numbers[i])) {
				map.put(numbers[i], 1);
			} else {
				duplication[0] = numbers[i];
				System.out.println(numbers[i]);
				return false;
			}
		}
		return true;
	}

	/**
	 * ����һ�������������β��ͷ��˳�򷵻�һ��ArrayList��
	 */
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		ListNode p = listNode;
		int temp = 0;
		while (p != null) {
			array.add(p.val);
			p = p.next;
		}
		System.out.println(array.size());
		int i = 0;
		for (i = 0; i < (array.size() / 2); i++) {
			temp = array.get(i);
			array.set(i, array.get(array.size() - i - 1));
			array.set(array.size() - i - 1, temp);
		}

		return array;
	}
	
	/**
	 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö�������
	 * ���������ǰ���������������Ľ���ж������ظ������֡�
	 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
	 */

	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {

		if (pre.length == 0 || in.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(pre[0]);
		// ���������ҵ�ǰ��ĸ�
		for (int i = 0; i < in.length; i++) {
			if (in[i] == pre[0]) {
				// ��������ע�� copyOfRange ����������ҿ�
				root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
				// ��������ע�� copyOfRange ����������ҿ�
				root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length),
						Arrays.copyOfRange(in, i + 1, in.length));
				break;
			}
		}
		return root;
	}
	
	/**
	 * ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
	 */
	class sol {
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();

		public void push(int node) {
			stack1.push(node);
		}

		public int pop() {
			if (!stack2.empty()) {
				return stack2.pop();
			} else if (!stack1.empty()) {
				while (!stack1.empty())
				{
					stack2.push(stack1.peek());
					stack1.pop();
				}
				return stack2.pop();
			} else {
				System.out.println("error pop(),empty queue!");
				return 0;
			}
		}
	}
	
	/**
	 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
	 * ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
	 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
	 * NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
	 */
	public static int minNumberInRotateArray(int [] array) {
		if (array.length == 0)
			return 0;
		int low = 0, high = array.length - 1;

		while (array[low] == array[high] && low <= high) {
			++low;
			--high;
		}

		while (array[low] > array[high]) {
			int mid = low + (high - low) / 2;

			if (array[mid] >= array[low]) {
				low = mid + 1;
			} else if (array[mid] <= array[high]) {
				high = mid;
			}
		}

		return array[low];
    }

	/**
	 * 쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n���0��ʼ����0��Ϊ0����n<=39
	 * 
	 * @param n
	 * @return
	 */
	public static int Fibonacci(int n) {
		if(n==0) {
			return 0;
		}else if(n==1 || n==2) {
			return 1;
		}else {
			int sum=0,n1=1,n2=1;
			for(int i = 3;i<=n;i++) {
				sum=n1+n2;
				n1=n2;
				n2=sum;
			}
			return sum;
		}
		
	}

}
