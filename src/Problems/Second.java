package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import test.ListNode;
import test.RandomListNode;
import test.TreeNode;

public class Second {
	public static void main(String[] args) {
//		int[] se = {4,6,7,5};
//		System.out.println(Second.VerifySquenceOfBST(se));
		
//		TreeNode root = new TreeNode(10);
//		root.left = new TreeNode(5);
//		root.right = new TreeNode(12);
//		root.left.left = new TreeNode(4);
//		root.left.right = new TreeNode(7);
//		ArrayList<ArrayList<Integer>> findPath = Second.FindPath(root, 22);
//		for(Object list:findPath) {
//			System.out.println(list);
//		}
		
//		TreeNode convert = Second.Convert(root);
//		System.out.println(convert);
		
		ArrayList<String> lists = Second.Permutation1("abc");
		for(String list:lists) {
			System.out.println(list);
		}
//		Second.reverse("adblcda".toCharArray(), 2);
		
	}
	
	/**
	 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
	 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
	 * @param sequence
	 * @return
	 */
	//二叉搜索树的左子数值<节点值<右子树值
	public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0)
        	return false;
        return IsBTS(sequence,0,sequence.length-1);
    }
	public static boolean IsBTS(int[] sequece,int b,int e) {
		if (b == e) {
			return true;
		}
		int mid = b;
		while (sequece[mid++] < sequece[e] && mid < e);

		int tmp = mid;
		while (sequece[tmp++] > sequece[e] && tmp < e);
		if (tmp < e) {
			return false;
		}

		if (mid == b || mid == e) {
			return IsBTS(sequece, b, e - 1);
		} else {
			return (IsBTS(sequece, b, mid - 1) && IsBTS(sequece, mid, e - 1));
		}
	}
	
	/**
	 * ???
	 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
	 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
	 * (注意: 在返回值的list中，数组长度大的数组靠前)
	 * @param root
	 * @param target
	 * @return
	 */
	private static ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
	private static ArrayList<Integer> list = new ArrayList<Integer>();

	public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		if (root == null)
			return listAll;
		list.add(root.val);
		target -= root.val;
		if (target == 0 && root.left == null && root.right == null)
			listAll.add(new ArrayList<Integer>(list));
		FindPath(root.left, target);
		FindPath(root.right, target);
		list.remove(list.size() - 1);
		return listAll;
	}
	
	/**
	 * ??
	 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
	 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
	 * @param pHead
	 * @return
	 */
	public RandomListNode Clone(RandomListNode pHead) {

		if (pHead == null) {
			return null;
		}

		RandomListNode currentNode = pHead;
		// 1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
		while (currentNode != null) {
			RandomListNode cloneNode = new RandomListNode(currentNode.label);
			RandomListNode nextNode = currentNode.next;
			currentNode.next = cloneNode;
			cloneNode.next = nextNode;
			currentNode = nextNode;
		}

		currentNode = pHead;
		// 2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
		while (currentNode != null) {
			currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
			currentNode = currentNode.next.next;
		}

		// 3、拆分链表，将链表拆分为原链表和复制后的链表
		currentNode = pHead;
		RandomListNode pCloneHead = pHead.next;
		while (currentNode != null) {
			RandomListNode cloneNode = currentNode.next;
			currentNode.next = cloneNode.next;
			cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
			currentNode = currentNode.next;
		}

		return pCloneHead;
	}
	
	/**
	 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
	 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
	 * @param pRootOfTree
	 * @return
	 */
//	public static TreeNode Convert(TreeNode pRootOfTree) {
//        if(pRootOfTree == null)
//        	return null;
//        if(pRootOfTree.left == null && pRootOfTree.right == null)
//        	return pRootOfTree;
//        TreeNode left = Convert(pRootOfTree.left);
//
//		TreeNode p = left;
//		// 2.定位至左子树双链表最后一个节点
//		while (p != null && p.right != null) {
//			p = p.right;
//		}
//		// 3.如果左子树链表不为空的话，将当前root追加到左子树链表
//		if (left != null) {
//			p.right = pRootOfTree;
//			pRootOfTree.left = p;
//		}
//		// 4.将右子树构造成双链表，并返回链表头节点
//		TreeNode right = Convert(pRootOfTree.right);
//		// 5.如果右子树链表不为空的话，将该链表追加到root节点之后
//		if (right != null) {
//			right.left = pRootOfTree;
//			pRootOfTree.right = right;
//		}
//		return left != null ? left : pRootOfTree;
//    }
	public static TreeNode head = null;
	public static TreeNode realhead = null;
	public static TreeNode Convert(TreeNode pRootOfTree) {
        Convertsub(pRootOfTree);
        return realhead;
    }
	public static void Convertsub(TreeNode root) {
		if(root == null)
			return;
		Convertsub(root.left);
		if(head == null) {
			head = root;
			realhead = root;
		}else {
			head.right = root;
			root.left = head;
			head = root;
		}
		Convertsub(root.right);
	}
	
	/**
	 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
	 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
	 * @param str输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母
	 * @return
	 */
	//第一种：全排列方式
	public static ArrayList<String> Permutation(String str) {
		ArrayList<String> list = new ArrayList<String>();
		if(str != null && str.length() >0)
			Permuhelper(str.toCharArray(),0,list);
		Collections.sort(list);
		return list;
    }
	public static void Permuhelper(char[] chars,int i,ArrayList<String> list) {
		if(i == chars.length-1) {
			list.add(String.valueOf(chars));
		}else {
			Set<Character> set = new HashSet<Character>();
			for(int j = i;j < chars.length;++j) {
				if(j==i || !set.contains(chars[j])) {
					set.add(chars[j]);
					swap(chars,i,j);
					Permuhelper(chars,i+1,list);
					swap(chars,j,i);
				}
			}
		}
	}
	public static void swap(char[] chars,int i,int j) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
	}
	//直接按字典序排列
	//算法思想：尽可能长的前缀，尽可能短的后缀（后缀作为改变长度尽量短）
	//超时，循环简化
	public static ArrayList<String> Permutation1(String str){
		ArrayList<String> list = new ArrayList<String>();
		int len = str.length();
		if(str == null || len==0) {
			return list;
		}
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		list.add(String.valueOf(chars));
		int fore ;
		int last;
		while(true) {
//			for(fore = len-1;fore > 0;fore--) {
//				if(chars[fore-1] < chars[fore])
//					break;
//			}
			fore = len -1;
			while(fore >0 && chars[fore-1] >= chars[fore]) {
				fore--;
			}
			if (fore == 0)
				break;
//			for(last = fore; last < len;last++) {
//				if(chars[last]<chars[fore-1])
//					break;
//			}
			last = fore;
			while(last < len && chars[last] >= chars[fore-1]) {
				last++;
			}
			swap(chars,fore-1,last-1);
			reverse(chars,fore);
			list.add(String.valueOf(chars));	
		}
		return list;
	}
	public static void reverse(char[] chars,int m) {
		int lens = chars.length-1;
		int len = lens-m;
		for (int i = m; i <= m + len / 2; i++) {
			// 交换元素
//			char temp = chars[n];
//			chars[n] = chars[i];
//			chars[i] = temp;
			swap(chars,i,lens--);
		}
		//System.out.println(chars);
	}
	//官方答案
	public static ArrayList<String> Permutation2(String str) {
		ArrayList<String> list = new ArrayList<String>();
		if (str == null || str.length() == 0) {
			return list;
		}
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		list.add(String.valueOf(chars));
		int len = chars.length;
		while (true) {
			int lIndex = len - 1;
			int rIndex;
			while (lIndex >= 1 && chars[lIndex - 1] >= chars[lIndex]) {
				lIndex--;
			}
			if (lIndex == 0)
				break;
			rIndex = lIndex;
			while (rIndex < len && chars[rIndex] > chars[lIndex - 1]) {
				rIndex++;
			}
			swap(chars, lIndex - 1, rIndex - 1);
			reverse(chars, lIndex);

			list.add(String.valueOf(chars));
		}

		return list;
	}
}
