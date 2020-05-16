package Problems;

import test.ListNode;

public class Listnode {
	public static void main(String[] args) {
		Listnode a = new Listnode();
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(1);
		head.next.next.next.next = new ListNode(1);
		head.next.next.next.next.next = new ListNode(1);
		head.next.next.next.next.next.next = new ListNode(5);
		ListNode listNode = a.deleteDuplication(head);
		while(listNode!=null) {
			System.out.println(listNode.val);
			listNode = listNode.next;
		}
		
	}
	
	/**
	 * ��һ�����������а����������ҳ�������Ļ�����ڽ�㣬�������null��
	 * @param pHead
	 * @return
	 */
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		ListNode fast = pHead;
		ListNode slow = pHead;
		//��Ϊfast�˶����죬Ӧ���ж�fast
		while(fast!=null && fast.next!=null) {
			fast=fast.next.next;
			slow = slow.next;
			if(fast==slow)
				break;
		}
		if(fast==null || fast.next==null)return null;
		fast = pHead;
		while(fast!=slow) {
			fast=fast.next;
			slow=slow.next;
		}
		return fast;        
    }
	
	/**
	 * ��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣 
	 * ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
	 * @param pHead
	 * @return
	 */
	public ListNode deleteDuplication(ListNode pHead)
    {
		if (pHead==null || pHead.next==null)return pHead;
		ListNode head = new ListNode(0);
		head.next=pHead;
		ListNode last = pHead;
		ListNode pre = head;
		while(last!=null) {
			if(last.next!=null && last.val==last.next.val) {
				while(last.next!=null && last.val==last.next.val) {
					last=last.next;
				}	
				pre.next=last.next;
				last=last.next;
			}else {
				last=last.next;
				pre=pre.next;
			}
		}
		return head.next;
    }
}
