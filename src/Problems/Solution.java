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
	 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
	 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
	 * @param target n级台阶
	 * @return 一共有多少种跳法
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
	 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
	 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
	 * @param target
	 * @return
	 */
	public static int JumpFloorII(int target) {
		//除了最后一级台阶，其他台阶都是选择跳或者不跳
		return (int) Math.pow(2, target-1);
        
    }
	
	/**
	 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
	 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     *比如n=3时，2*3的矩形块有3种覆盖方法：
	 */
	public static int RectCover(int target) {
        return JumpFloor(target);
    }
	
	/**
	 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
	 * @param n
	 * @return
	 */
	//@@所有数据都是以二进制传输的，不用特地转换
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
	 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
	 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
	 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
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
		// 或者
//      Object[] array1 = list.toArray();
//        for (int i = 0; i < array1.length; i++) {
//			array[i]=(int)array1[i];
//		}       
	}
	
	/**
	 * 输入一个链表，输出该链表中倒数第k个结点。
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
	 * 输入一个链表，反转链表后，输出新链表的表头。
	 * @param head
	 * @return
	 */
	public static ListNode ReverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode q;// 用于操作反转的节点
		ListNode p;// 用于存储反转节点的下一个节点
		ListNode r;// 用于存储反转后的链表头
		q = r = head;
		p = head.next;

		while (p != null) {
			q = p;
			p = p.next;
			q.next = r;
			r = q;

		}
		head.next = null;// 如果不加这个步骤就会变成循环链表
		return r;
    }
	
	/**
	 * 输入两个单调递增的链表，输出两个链表合成后的链表，
	 * 当然我们需要合成后的链表满足单调不减规则。
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
	//插入链表，把list2插入list1，即list1.val<list2.val
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
	 * 输入两棵二叉树A，B，判断B是不是A的子结构。
	 * （ps：我们约定空树不是任意一个树的子结构）
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
	//从根节点比较两颗树是否想等
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
	 * 镜像二叉树
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
	 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
	 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
	 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
	 * @param matrix
	 * @return
	 */
	public static ArrayList<Integer> printMatrix(int [][] matrix) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (matrix.length == 0) {
			return null;
		}
		//考虑一维数组的情况
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
		//确定一个左上角和右下角坐标的矩形，将矩形顺时针打印
		int[] m = { 0, 0 };
		int[] n = { matrix.length - 1, matrix[0].length - 1 };
		//包含了方针和matrix.length>matrix[0].length的情况
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
		//matrix.length<matrix[0].length的情况
		//还要考虑n为奇数时，n*n的情况
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
	 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
	 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
	 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
	 * （注意：这两个序列的长度是相等的)
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
	 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
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
	 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
	 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
	 * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，
	 * B[n-1] = A[0] * A[1] * ... * A[n-2];）
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
	 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
	 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
	 *  在本题中，匹配是指字符串的所有字符匹配整个模式。
	 *  例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
	 * @param str
	 * @param pattern
	 * @return
	
	public boolean match(char[] str, char[] pattern) {

	} */
	
	/**
	 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
	 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
	 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
	 * @param str
	 * @return
	 
	public boolean isNumeric(char[] str) {
		//合理的数字
		//e或者E后必须接数字
		//小数点只能有一个，且不能在e后
		//+ - 在开头或是要紧跟E或e后
		//数字要是0-9之内的合法字符
		boolean hasE = false, demical = false, sign = false;
		for(int i = 0;i < str.length; i++) {
			if(str[i] == 'e' || str[i] == 'E') {
				if(i)
			}
		}
		return true;
	}*/
}
