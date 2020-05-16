package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import test.ListNode;
import test.TreeNode;

public class Solution {
	
	public static void main(String[] args) {
		
//		int floor = Solution.JumpFloor(6);
//		System.out.println(floor);
//		
//		System.out.println(Solution.JumpFloorII(2));
		
//		int[] a = {1,2,3,4,5,6,7};
//		Solution.reOrderArray(a);

//		ListNode head = new ListNode(1);
//		head.next=new ListNode(2);
//		head.next.next=new ListNode(3);
//		head.next.next.next=new ListNode(4);
//		ListNode findKthToTail = Solution.FindKthToTail(head, 5);
//		ListNode reverseList = Solution.ReverseList(head);
//		ListNode q = reverseList;
//		while(q!=null) {
//			System.out.println(q.val);
//			q=q.next;
//		}

//		ListNode head1 = new ListNode(1);
//		head1.next = new ListNode(2);
//		head1.next.next = new ListNode(5);
//		head1.next.next.next = new ListNode(7);
//
//		ListNode head2 = new ListNode(2);
//		head2.next = new ListNode(3);
//		head2.next.next = new ListNode(4);
//		head2.next.next.next = new ListNode(5);
//		head2.next.next.next.next = new ListNode(6);
//		ListNode insertList = Solution.Merge(head1, null);
//		ListNode q = insertList;
//		while (q != null) {
//			System.out.println(q.val);
//			q = q.next;
//		}
		
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.left.left = new TreeNode(3);
//		root.left.right = new TreeNode(4);
//		root.right = new TreeNode(3);
//		//TreeNode root2 = new TreeNode(1);
//		//System.out.println(Solution.HasSubtree(root, root2));
//		Solution.Mirror(root);
		
//		int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//		int[][] a = {{1,2},{3,4},{5,6},{7,8},{9,10}};
//		System.out.println(Solution.printMatrix(a));

//		Stack<Integer> stack = new Stack<Integer>();
//		stack.push(1);
//		System.out.println(stack.peek());
	
//		int[] a = {1,2,3,4,5};
//		int[] b = {4,3,5,2,1};
//		System.out.println(Solution.IsPopOrder(a, b));
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right =  new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		System.out.println(Solution.PrintFromTopToBottom(root));

	}
	
	/**
	 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2����
	 * �����������һ��n����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������
	 * @param target n��̨��
	 * @return һ���ж���������
	 */
	public static int JumpFloor(int target) {
		if(target==1) {
			return 1;
		}else if(target==2) {
			return 2;
		}else {
			int sum=0,n1=1,n2=2;
			for(int i=3;i<=target;i++) {
				sum=n1+n2;
				n1=n2;
				n2=sum;
			}
			return sum;
		}
	}
	
	/**
	 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n����
	 * �����������һ��n����̨���ܹ��ж�����������
	 * @param target
	 * @return
	 */
	public static int JumpFloorII(int target) {
		//�������һ��̨�ף�����̨�׶���ѡ�������߲���
		return (int) Math.pow(2, target-1);
        
    }
	
	/**
	 * ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
	 * ������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
     *����n=3ʱ��2*3�ľ��ο���3�ָ��Ƿ�����
	 */
	public static int RectCover(int target) {
        return JumpFloor(target);
    }
	
	/**
	 * ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
	 * @param n
	 * @return
	 */
	//@@�������ݶ����Զ����ƴ���ģ������ص�ת��
	public static int NumberOf1(int n) {
		int count=0;
		while(n!=0) {
			count++;
			n=n&(n-1);
		}
		return count;
    }
	public static StringBuffer ToBinary(int n) {
		StringBuffer s = new StringBuffer();
		int div=n;
		while(div!=0) {
			s.append(div%2);
			div=div/2;
		}
		return s.reverse();
	}
	
	/**
	 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��
	 * ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ������ĺ�벿�֣�
	 * ����֤������������ż����ż��֮������λ�ò��䡣
	 * @param array
	 */
	public static void reOrderArray(int[] array) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 1) {
				list.add(array[i]);
			}
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				list.add(array[i]);
			}
		}

		Integer[] a = new Integer[list.size()];
		list.toArray(a);
		array = Arrays.stream(a).mapToInt(Integer::valueOf).toArray();
		for (int i : array) {
			System.out.println(i);
		}
		// ����
//      Object[] array1 = list.toArray();
//        for (int i = 0; i < array1.length; i++) {
//			array[i]=(int)array1[i];
//		}       
	}
	
	/**
	 * ����һ����������������е�����k����㡣
	 * @param head
	 * @param k
	 * @return
	 */
	public static ListNode FindKthToTail(ListNode head, int k) {
		ListNode p = head;
		int count = 0;
		while (p != null) {
			p = p.next;
			count++;
		}
		if (k > count)
			return null;
		int n = count - k;
		p = head;
		while (n != 0) {
			p = p.next;
			n--;
		}
		return p;
	}
	
	/**
	 * ����һ��������ת��������������ı�ͷ��
	 * @param head
	 * @return
	 */
	public static ListNode ReverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode q;// ���ڲ�����ת�Ľڵ�
		ListNode p;// ���ڴ洢��ת�ڵ����һ���ڵ�
		ListNode r;// ���ڴ洢��ת�������ͷ
		q = r = head;
		p = head.next;

		while (p != null) {
			q = p;
			p = p.next;
			q.next = r;
			r = q;

		}
		head.next = null;// ��������������ͻ���ѭ������
		return r;
    }
	
	/**
	 * ���������������������������������ϳɺ������
	 * ��Ȼ������Ҫ�ϳɺ���������㵥����������
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static ListNode Merge(ListNode list1,ListNode list2) {
		if(list1 == null && list2 != null) {
			return list2;
		}
		if(list2 == null && list1 != null) {
			return list1;
		}
		if(list1 == null && list2 == null) {
			return null;
		}
		ListNode m = list1;
		ListNode n = list2;
		while (m.next != null) {
			m = m.next;
		}
		while(n.next != null) {
			n = n.next;
		}
		int l1 = list1.val;
		int h1 = m.val;
		int l2 = list2.val;
		int h2 = n.val;
		//System.out.println("l1"+low1+" h1"+high1+" l2"+low2+" h2"+high2);
		
		if(h1 <= l2) {
			m.next = list2;
			return list1;
		}else if(h2 <= l1) {
			n.next = list1;
			return list2;
		}else if(l1 <= l2){
			return InsertList(list1,list2);
		}else if(l2 < l1) {
			return InsertList(list2,list1);
		}else {
			return null;
		}
    }
	//����������list2����list1����list1.val<list2.val
	public static ListNode InsertList(ListNode list1,ListNode list2) {
		ListNode p = list1;
		ListNode q = list2;
		ListNode r = null;
		while(true) {
			if(p.next == null) {
				p.next = r;
				break;
			}else {
				if(q.val > p.next.val) {
					p = p.next;
				}else {
					r = q.next;
					q.next = p.next;
					p.next = q;
					q = r;
				}
				if(q == null)
					break;
			}
		}
		return list1;
	}
	
	/**
	 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ��
	 * ��ps������Լ��������������һ�������ӽṹ��
	 * @param root1
	 * @param root2
	 * @return
	 */
	public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
		boolean flag = false;
		if (root1 != null && root2 != null) {
			if (root1.val == root2.val) {
				flag = compareTree(root1, root2);
			}
			if (!flag) {
				flag = compareTree(root1.left, root2);
			}
			if (!flag) {
				flag = compareTree(root1.right, root2);
			}
		}

		return flag;
    }
	//�Ӹ��ڵ�Ƚ��������Ƿ����
	public static boolean compareTree(TreeNode root1,TreeNode root2) {
		if(root2 == null)
			return true;
		if(root1 == null)
			return false;
		if(root1.val != root2.val) {
			return false;
		}
		return compareTree(root1.left,root2.left) && compareTree(root1.right,root2.right);
	}
	
	/**
	 * ���������
	 * @param root
	 */
	public static void Mirror(TreeNode root) {
        if(root == null)
        	return;
        TreeNode temp = null;
        if(root.left != null || root.right != null) {
        	temp = root.left;
        	root.left = root.right;
        	root.right = temp;
        	Mirror(root.left);
        	Mirror(root.right);
        }
    }

	/**
	 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣�
	 * ���磬�����������4 X 4���� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
	 * �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
	 * @param matrix
	 * @return
	 */
	public static ArrayList<Integer> printMatrix(int [][] matrix) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (matrix.length == 0) {
			return null;
		}
		//����һά��������
		if(matrix.length==1) {
			if(matrix[0].length==0) {
				return list;
			}else {
				for (Integer integer : matrix[0]) {
					list.add(integer);
				}
				return list;
			}
		}
		
		if(matrix.length!=1 && matrix[0].length==1) {
			for (int i = 0;i < matrix.length;i++) {
				list.add(matrix[i][0]);
			}
			return list;
		}
		//ȷ��һ�����ϽǺ����½�����ľ��Σ�������˳ʱ���ӡ
		int[] m = { 0, 0 };
		int[] n = { matrix.length - 1, matrix[0].length - 1 };
		//�����˷����matrix.length>matrix[0].length�����
		while (m[0] < n[0] && m[1] < n[1]) {
			int i = m[0];
			int j = m[1];
			while (j < n[1]) {
				list.add(matrix[i][j++]);
			}
			while (i < n[0]) {
				list.add(matrix[i++][j]);
			}
			while (j > m[1]) {
				list.add(matrix[i][j--]);
			}
			while (i > m[0]) {
				list.add(matrix[i--][j]);
			}
			i++;
			m[0]++;
			m[1]++;
			n[0]--;
			n[1]--;
		}
		//matrix.length<matrix[0].length�����
		//��Ҫ����nΪ����ʱ��n*n�����
		if (m[0] == n[0]) {
			if (m[1] == n[1]) {
				list.add(matrix[m[0]][m[1]]);
			} else {
				for (int i = m[1]; i <= n[1]; i++) {
					list.add(matrix[m[0]][i]);
				}
			}
		}
		return list;
    }
	
	/**
	 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ����Ϊ��ջ�ĵ���˳��
	 * ����ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳��
	 * ����4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С�
	 * ��ע�⣺���������еĳ�������ȵ�)
	 * @param pushA
	 * @param popA
	 * @return
	 */
	public static boolean IsPopOrder(int [] pushA,int [] popA) {
		Stack<Integer> stack = new Stack<Integer>();
		int index = 0;
		int index2 = 0;
		while(index2 < pushA.length) {
			stack.push(pushA[index2++]);
			while(!stack.empty() && stack.peek() == popA[index]) {
				stack.pop();
				index++;
			}
		}
		if(stack.empty()) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * �������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
	 * @param root
	 * @return
	 */
	public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        if(root == null)
			return list;
        queue.add(root);
        while(queue.size() != 0) {
        	TreeNode temp = queue.remove(0);
        	if(temp.left != null)
        		queue.add(temp.left);
        	if(temp.right != null)
        		queue.add(temp.right);
        	list.add(temp.val);
        }
        
        return list;
    }
	
	/**
	 * ???
	 * ����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],
	 * ����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]������ʹ�ó�����
	 * ��ע�⣺�涨B[0] = A[1] * A[2] * ... * A[n-1]��
	 * B[n-1] = A[0] * A[1] * ... * A[n-2];��
	 * @param A
	 * @return
	 */
	public static int[] multiply(int[] A) {
		int[] B = new int[A.length];
		if(A.length != 0) {
			B[0] = 1;
			for(int i = 1;i < A.length;i++) {
				B[i] = B[i-1] * A[i-1];
			}
			int temp = 1;
			for(int j = A.length-2; j >=0;j--) {
				temp *= A[j+1];
				B[j] *= temp;
			}
		}
		return B;
	}
	
	/**
	 * ???
	 * ��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��
	 * ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ���
	 *  �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ��
	 *  ���磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��
	 * @param str
	 * @param pattern
	 * @return
	
	public boolean match(char[] str, char[] pattern) {

	} */
	
	/**
	 * ��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С������
	 * ���磬�ַ���"+100","5e2","-123","3.1416"��"-1E-16"����ʾ��ֵ��
	 * ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
	 * @param str
	 * @return
	 
	public boolean isNumeric(char[] str) {
		//���������
		//e����E����������
		//С����ֻ����һ�����Ҳ�����e��
		//+ - �ڿ�ͷ����Ҫ����E��e��
		//����Ҫ��0-9֮�ڵĺϷ��ַ�
		boolean hasE = false, demical = false, sign = false;
		for(int i = 0;i < str.length; i++) {
			if(str[i] == 'e' || str[i] == 'E') {
				if(i)
			}
		}
		return true;
	}*/
}
