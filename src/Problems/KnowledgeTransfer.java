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
	 * ͳ��һ�����������������г��ֵĴ�����
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
	 * ����һ�ö����������������ȡ�
	 * �Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
	 * @param root
	 * @return
	 */
	public static int TreeDepth(TreeNode root) {
        if(root == null)
        	return 0;        
        return Math.max(1+TreeDepth(root.left), 1+TreeDepth(root.right));
    }
	
	/**
	 * ����һ�ö��������жϸö������Ƿ���ƽ���������
	 * ���������ֻ��Ҫ������ƽ���ԣ�����Ҫ�������ǲ������������
	 * ע:ƽ����������κ����������߶�������1
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
	 * һ�����������������������֮�⣬���������ֶ����������Ρ�
	 * ��д�����ҳ�������ֻ����һ�ε����֡�
	 * @param array
	 * @param num1
	 * @param num2
	 
	//num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
	//��num1[0],num2[0]����Ϊ���ؽ��
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
	        diff ^= num;//�ҵ���������ͬ���������
	    diff &= -diff;//��Ҫ��Ϊ���ҵ�һ������ͬ��λ�����������ұߵĵ�һλ
	    for (int num : nums) {
	        if ((num & diff) == 0)//�������ֱ��Ϊ�������֣���һ����һ��������ͬ��������Ϊ��ͬ������λ��һ����ͬ
	            num1[0] ^= num;
	        else
	            num2[0] ^= num;
	    }
	}
	
	/**
	 * ������к�ΪS�������������С������ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��
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
	 * ����һ����������������һ������S���������в�����������ʹ�����ǵĺ�������S��
	 * ����ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
	 * ��Ӧÿ�����԰����������������С���������
	 * @param array
	 * @param sum
	 * @return
	 */
	public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		ArrayList<Integer> list = new ArrayList<Integer>();
        int end = array.length-1;
        int start = 0;
        //���һ������д��ǰ��
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
	 * �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵�����
	 * �������ַ���ģ�����ָ���������������һ���������ַ�����S��
	 * �������ѭ������Kλ���������������磬�ַ�����S=��abcXYZdef��,
	 * Ҫ�����ѭ������3λ��Ľ��������XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨����
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
	 * ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�
	 * ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish������������ȴ������������˼��
	 * ���磬��student. a am I������������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ�
	 * ��ȷ�ľ���Ӧ���ǡ�I am a student.����Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
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
