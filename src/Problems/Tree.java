package Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import test.TreeLinkNode;
import test.TreeNode;

public class Tree {
	public static void main(String[] args) {
		Tree tree = new Tree();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(2);
		root.right= new TreeNode(3);
		root.left.left= new TreeNode(4);
		//root.left.right= new TreeNode(6);
		root.right.right= new TreeNode(5);
//		System.out.println(tree.isSymmetrical(root));
		
//		ArrayList<ArrayList<Integer>> print = tree.ZPrint(root);
//		System.out.println(print);
		
		String str = tree.Serialize(root);
		System.out.println(str);
		tree.Deserialize(str);

	}
	/**
	 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
	 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
	 * @param pNode
	 * @return
	 */
	public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        //1.如果有右子树，那么下一结点为右子树的最左边结点
		//2.如果没有右子树，那么找父节点，直到父节点有左子树，输出左子数结点，如果没有，则返回空
		if(pNode.right!=null) {
			TreeLinkNode left = pNode.right;
			while(left.left!=null) {
				left=left.left;
			}
			return left;
		}else {
			while(pNode.next!=null) {
				TreeLinkNode parent = pNode.next;
			if(parent.left == pNode) {
				return parent;
			}
			pNode=pNode.next;
			}				
		}
		return null;
    }
	
	/**
	 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
	 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
	 * @param pRoot
	 * @return
	 */
	boolean isSymmetrical(TreeNode pRoot){
		if(pRoot==null)
			return true;
		return isSymmetricale(pRoot.left,pRoot.right);
    }
	boolean isSymmetricale(TreeNode p1,TreeNode p2){
		if(p1==null && p2 == null)
			return true;
		if(p1 == null || p2==null)
			return false;
		if(p1.val!=p2.val)
			return false;

		return isSymmetricale(p1.left,p2.right)&&isSymmetricale(p1.right,p2.left);
	}
	
	/**
	 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
	 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
	 * @param pRoot
	 * @return
	 */
	public ArrayList<ArrayList<Integer> > ZPrint(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> arraylist =  new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(pRoot);
		boolean reverse = false;
		while(!queue.isEmpty()) {
			ArrayList<Integer> list = new ArrayList<>();
			int size = queue.size();
			while(size-->0) {
				TreeNode temp = queue.poll();
				if(temp==null)
					continue;
				list.add(temp.val);
				queue.add(temp.left);
				queue.add(temp.right);
			}
			if(reverse)
				Collections.reverse(list);
			reverse = !reverse;
			if(list.size()>0)
				arraylist.add(list);
		}
	   	return arraylist;
    }
	
	/**
	 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
	 * @param pRoot
	 * @return
	 */
	ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> arraylist =  new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(pRoot);
		while(!queue.isEmpty()) {
			ArrayList<Integer> list = new ArrayList<>();
			int size = queue.size();
			while(size-->0) {
				TreeNode temp = queue.poll();
				if(temp==null)
					continue;
				list.add(temp.val);
				queue.add(temp.left);
				queue.add(temp.right);
			}
			if(list.size()>0)
				arraylist.add(list);
		}
	   	return arraylist;
    }

	/**
	 * 序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），
	 * 以 ！ 表示一个结点值的结束（value!）。
	 * @param root
	 * @return
	 */
	private String deserializeStr;
	String Serialize(TreeNode root) {
		if (root == null)
			return "#";
		return root.val + "!" + Serialize(root.left) + "!" + Serialize(root.right);
	}

	TreeNode Deserialize(String str) {
		 deserializeStr = str;
		 return Deserialize();
	}
	private TreeNode Deserialize() {
	    if (deserializeStr.length() == 0)
	        return null;
	    int index = deserializeStr.indexOf("!");
	    String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
	    deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
	    //str=10!2!4!#!#!#!3!#!5!#!#
	    //str.indexOf("!"),下标：2
	    //str.substring(0,2),左开右闭：10
	    //str.substring(3),左开，为了略过"!"
	    if (node.equals("#"))
	        return null;
	    int val = Integer.valueOf(node);
	    TreeNode t = new TreeNode(val);
	    t.left = Deserialize();
	    t.right = Deserialize();
	    return t;
	}
}
