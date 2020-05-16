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
	 * ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�
	 * ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
	 * @param pNode
	 * @return
	 */
	public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        //1.���������������ô��һ���Ϊ������������߽��
		//2.���û������������ô�Ҹ��ڵ㣬ֱ�����ڵ����������������������㣬���û�У��򷵻ؿ�
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
	 * ��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�
	 * ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
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
	 * ��ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ��
	 * �ڶ��㰴�մ��������˳���ӡ�������а��մ����ҵ�˳���ӡ���������Դ����ơ�
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
	 * ���ϵ��°����ӡ��������ͬһ����������������ÿһ�����һ�С�
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
	 * ���л��Ľ����һ���ַ��������л�ʱͨ�� ĳ�ַ��ű�ʾ�սڵ㣨#����
	 * �� �� ��ʾһ�����ֵ�Ľ�����value!����
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
	    //str.indexOf("!"),�±꣺2
	    //str.substring(0,2),���ұգ�10
	    //str.substring(3),�󿪣�Ϊ���Թ�"!"
	    if (node.equals("#"))
	        return null;
	    int val = Integer.valueOf(node);
	    TreeNode t = new TreeNode(val);
	    t.left = Deserialize();
	    t.right = Deserialize();
	    return t;
	}
}
