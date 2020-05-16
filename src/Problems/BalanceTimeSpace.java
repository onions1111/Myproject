package Problems;

import test.ListNode;

public class BalanceTimeSpace {
	public static void main(String[] args) {
//		int num = BalanceTimeSpace.GetUglyNumber_Solution(10);
//		System.out.println(num);
		
		int num = BalanceTimeSpace.FirstNotRepeatingChar("aaabdlasi");
		System.out.println(num);
	}
	
	/**
	 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
	 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 
	 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
	 * @param index
	 * @return
	 */
	public static int GetUglyNumber_Solution(int index) {
		if(index < 7) return index;
		int[] arr = new int[index];
		arr[0] = 1;
		int p2 = 0, p3 = 0, p5 = 0;
		for(int i = 1;i < index;++i) {
			arr[i] = Math.min(arr[p2]*2,Math.min(arr[p3]*3,arr[p5]*5));
			if(arr[i] == arr[p2]*2)p2++;
			if(arr[i] == arr[p3]*3)p3++;
			if(arr[i] == arr[p5]*5)p5++;
		}
        return arr[index-1];
    }
	
	/**
	 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
	 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
	 * @param str
	 * @return
	 */
	public static int FirstNotRepeatingChar(String str) {
		if(str.length() == 0 || str == null)
			return -1;
		int[] strs = new int[258];
		for(int i = 0;i < str.length();i++) {
			strs[str.charAt(i)]++;
		}
		for(int i = 0;i < str.length();i++)
		{
			if(strs[str.charAt(i)] == 1)
				return (char)i;
		}
        return 0;
    }
	
	/**
	 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
	 * 输入一个数组,求出这个数组中的逆序对的总数P。
	 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
	 * @param array
	 * @return
	 */
	public static long count;
	public static int InversePairs(int[] array) {
		int[] temp = new int[array.length];
		sort(array,0,array.length-1,temp);
        return (int)(count%1000000007);
	}
	public static void sort(int[] arr,int left,int right,int[] temp) {
		if(left < right) {
			int mid = (left + right)/2;
			sort(arr,left,mid,temp);
			sort(arr,mid + 1,right,temp);
			merge(arr,left,mid,right,temp);
		}
	}
	public static void merge(int[] arr,int left,int mid,int right,int[] temp) {
		int i = mid;
		int j = right;
		int t = right;
		while(i>=left && j > mid) {
			if(arr[i] > arr[j]) {
				temp[t--] = arr[i--];
				//除了这步，其他就是归并排序
				count += j-mid; 
			}else {
				temp[t--] = arr[j--];
			}
		}
		while(i >= left) {
			temp[t--] = arr[i--];
			
		}
		while(j > mid) {
			temp[t--] = arr[j--];
			
		}
		for(int m = left;m <= right;m++) {
			arr[m] = temp[m];
		}
	}
	
	/**
	 * 输入两个链表，找出它们的第一个公共结点。
	 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，
	 * 保证传入数据是正确的）
	 * @param pHead1
	 * @param pHead2
	 * @return
	 */
	public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		 ListNode p1 = pHead1, p2 = pHead2;
	        while(p1 != p2){
	            p1 = (p1 == null)? pHead2:p1.next;
	            p2 = (p2 == null)? pHead1:p2.next;
	        }
	        return p1;
    }
}
