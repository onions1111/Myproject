package Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import test.TreeNode;

public class KnowledgeTransfer {
	public static void main(String[] args) {
//		int [] array = {1, 2, 3, 3, 3, 3, 4, 6};
//		int n = KnowledgeTransfer.GetNumberOfK(array, 4);
//		System.out.println(n);
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(3);
//		int treeDepth = KnowledgeTransfer.TreeDepth(root);
//		System.out.println(treeDepth);
		
//		boolean boo = KnowledgeTransfer.IsBalanced_Solution(root);
//		System.out.println(boo);
		
//		int[] a = {1,1,5,2,5,3};
//		KnowledgeTransfer.FindNumsAppearOnce(a, new int[1], new int[1]);
//		ArrayList<ArrayList<Integer>> num = KnowledgeTransfer.FindContinuousSequence(100);
//		System.out.println(num);
		
//		int[] array = {2,4,5,6,7,8,9};
//		int[] a = {};
//		ArrayList<Integer> list = KnowledgeTransfer.FindNumbersWithSum(a,0);
//		System.out.println(list);
		
//		String str = KnowledgeTransfer.LeftRotateString("abcXYZdef", 12);
//		System.out.println(str);
		
		String str = "hello my world";
		String str1 = KnowledgeTransfer.ReverseSentence(str);
		System.out.println(str1);
	}
	
	/**
	 * 统计一个数字在排序数组中出现的次数。
	 * @param array
	 * @param k
	 * @return
	 
	public static int GetNumberOfK(int [] array , int k) {
		int len = array.length;
		int count = 0;
		if(len == 0)
			return 0;
		count = GetNumberOfK(array,0,len-1,k);
		return count;
    }
	public static int GetNumberOfK(int [] array , int left ,int right, int k) {
		if(left > right)
			return 0;
		int mid = (right-left) / 2;
		int count = 0;
		if(array[left+mid] < k) {
			return GetNumberOfK(array,left+mid+1,right,k);
		}else if(array[left+mid] > k) {
			return GetNumberOfK(array,left,left+mid,k);
		}else {
			for(int i = left;i <= right;i++) {
				if(array[i] == k)
					count++;
			}
			return count;
		}
    }*/
	public static int GetNumberOfK(int[] nums, int K) {
	    int first = binarySearch(nums, K);
	    int last = binarySearch(nums, K + 1);
	    return (first == nums.length || nums[first] != K) ? 0 : last - first;
	}

	private static int binarySearch(int[] nums, int K) {
	    int l = 0, h = nums.length;
	    while (l < h) {
	        int m = l + (h - l) / 2;
	        if (nums[m] >= K)
	            h = m;
	        else
	            l = m + 1;
	    }
	    return l;
	}
	
	/**
	 * 输入一棵二叉树，求该树的深度。
	 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
	 * @param root
	 * @return
	 */
	public static int TreeDepth(TreeNode root) {
        if(root == null)
        	return 0;        
        return Math.max(1+TreeDepth(root.left), 1+TreeDepth(root.right));
    }
	
	/**
	 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
	 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
	 * 注:平衡二叉树是任何左右子树高度相差不超过1
	 * @param root
	 * @return
	 */
	public static boolean IsBalanced_Solution(TreeNode root) {
        if(root == null)
        	return true;
        boolean left = IsBalanced_Solution(root.left);
        int l = TreeDepth(root.left);
        if(left == false)
        	return false;
        boolean right = IsBalanced_Solution(root.right);
        int r = TreeDepth(root.right);
        if(right == false)
        	return false;	
        if(Math.abs(l-r) > 1)
        	return false;
        return true;
    }
	
	/**
	 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
	 * 请写程序找出这两个只出现一次的数字。
	 * @param array
	 * @param num1
	 * @param num2
	 
	//num1,num2分别为长度为1的数组。传出参数
	//将num1[0],num2[0]设置为返回结果
	public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int a:array) {
        	if(!map.containsKey(a)) {
        		map.put(a, 1);
        	}else {
        		map.put(a, 2);
        	}
        }
        Set<Integer> keySet = map.keySet();
        int a = 0;
        for(int key:keySet) {
        	if(map.get(key) == 1) {
        		if(a==0) {
        			num1[0]=key;
        			a++;
        		}else {
        			num2[0]=key;
        		}
        		
        	}
        }
    }
	*/
	public static void FindNumsAppearOnce(int[] nums, int num1[], int num2[]) {
	    int diff = 0;
	    for (int num : nums)
	        diff ^= num;//找到两个不相同数的异或结果
	    diff &= -diff;//主要是为了找到一个不相同的位，这里是最右边的第一位
	    for (int num : nums) {
	        if ((num & diff) == 0)//将对数分别分为两个部分，单一部分一定含有相同的数，因为相同的数的位数一定相同
	            num1[0] ^= num;
	        else
	            num2[0] ^= num;
	    }
	}
	
	/**
	 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
	 * 100 = 9-16/18-22
	 * @param sum
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> arraylist = new ArrayList<ArrayList<Integer>>();
		int start = 1,end =2;
		int cursum = 3;
		while(start < end) {
			if(cursum < sum) {
				end++;
				cursum += end;
			}else if(cursum > sum) {
				cursum-=start;
				start++;
			}else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				for(int i = start;i <= end;i++) {
					list.add(i);
				}
				arraylist.add(list);
				cursum-=start;
				start++;
				end++;
				cursum+=end;
			}
		}
		return arraylist;
    }
	
	/**
	 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
	 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
	 * 对应每个测试案例，输出两个数，小的先输出。
	 * @param array
	 * @param sum
	 * @return
	 */
	public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		ArrayList<Integer> list = new ArrayList<Integer>();
        int end = array.length-1;
        int start = 0;
        //最后一个不能写在前面
        if(array.length == 0 || sum == 0 || array[start] >= sum)
        	return list;
        while(start < end) {
        	int num = sum - array[start];
        	int other = start+1;
        	while(other <= end) {
            	if(num > array[other]) {
            		other++;
            	}else if(num < array[other]) {
            		start++;
            		break;
            	}else {
            		list.add(array[start]);
            		list.add(array[other]);
            		start++;
            		break;
            	}
        	}
        }
        if(list.size() > 2) {
        	int i = (list.size()-2)/2;
        	while(i!=0) {
				list.remove(3);
				list.remove(2);
				i--;
			}
        }
        return list;
    }
	
	/**
	 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
	 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
	 * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
	 * 要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
	 * @param str
	 * @param n
	 * @return
	 */
	public static String LeftRotateString(String str,int n) {
        int len = str.length();
        if(len == 0)
            return "";
        if(n < len) {
        	StringBuffer temp = new StringBuffer();
        	for(int i = n;i < len;i++) {
        		temp.append(str.charAt(i));
        	}
        	for(int j = 0;j < n;j++) {
        		temp.append(str.charAt(j));
        	}
        	return temp.toString();
        }else if(n > len) {
        	return LeftRotateString(str,n-len);
        }else {
        	return str;
        }
    }
	
	/**
	 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
	 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
	 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
	 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
	 * @param str
	 * @return
	 */
	//???
	public static String ReverseSentence(String str) {
		int n = str.length();
	    char[] chars = str.toCharArray();
	    int i = 0, j = 0;
	    while (j <= n) {
	        if (j == n || chars[j] == ' ') {
	            reverse(chars, i, j - 1);
	            i = j + 1;
	        }
	        j++;
	    }
	    reverse(chars, 0, n - 1);
	    return new String(chars);
    }
	private static void reverse(char[] c, int i, int j) {
	    while (i < j)
	        swap(c, i++, j--);
	}

	private static void swap(char[] c, int i, int j) {
	    char t = c[i];
	    c[i] = c[j];
	    c[j] = t;
	}
}
