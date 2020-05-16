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
	 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
	 * ����������Yes,�������No���������������������������ֶ�������ͬ��
	 * @param sequence
	 * @return
	 */
	//������������������ֵ<�ڵ�ֵ<������ֵ
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
	 * ����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
	 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
	 * (ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ)
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
	 * ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩��
	 * ���ؽ��Ϊ���ƺ��������head����ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
	 * @param pHead
	 * @return
	 */
	public RandomListNode Clone(RandomListNode pHead) {

		if (pHead == null) {
			return null;
		}

		RandomListNode currentNode = pHead;
		// 1������ÿ����㣬�縴�ƽ��A�õ�A1�������A1�嵽���A���棻
		while (currentNode != null) {
			RandomListNode cloneNode = new RandomListNode(currentNode.label);
			RandomListNode nextNode = currentNode.next;
			currentNode.next = cloneNode;
			cloneNode.next = nextNode;
			currentNode = nextNode;
		}

		currentNode = pHead;
		// 2�����±������������Ͻ������ָ����½�㣬��A1.random = A.random.next;
		while (currentNode != null) {
			currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
			currentNode = currentNode.next.next;
		}

		// 3�����������������Ϊԭ����͸��ƺ������
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
	 * ����һ�ö��������������ö���������ת����һ�������˫������
	 * Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
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
//		// 2.��λ��������˫�������һ���ڵ�
//		while (p != null && p.right != null) {
//			p = p.right;
//		}
//		// 3.�������������Ϊ�յĻ�������ǰroot׷�ӵ�����������
//		if (left != null) {
//			p.right = pRootOfTree;
//			pRootOfTree.left = p;
//		}
//		// 4.�������������˫��������������ͷ�ڵ�
//		TreeNode right = Convert(pRootOfTree.right);
//		// 5.�������������Ϊ�յĻ�����������׷�ӵ�root�ڵ�֮��
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
	 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С�
	 * ���������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
	 * @param str����һ���ַ���,���Ȳ�����9(�������ַ��ظ�),�ַ�ֻ������Сд��ĸ
	 * @return
	 */
	//��һ�֣�ȫ���з�ʽ
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
	//ֱ�Ӱ��ֵ�������
	//�㷨˼�룺�����ܳ���ǰ׺�������̵ܶĺ�׺����׺��Ϊ�ı䳤�Ⱦ����̣�
	//��ʱ��ѭ����
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
			// ����Ԫ��
//			char temp = chars[n];
//			chars[n] = chars[i];
//			chars[i] = temp;
			swap(chars,i,lens--);
		}
		//System.out.println(chars);
	}
	//�ٷ���
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
