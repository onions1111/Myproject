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
	 * ��ֻ����������2��3��5��������������Ugly Number����
	 * ����6��8���ǳ�������14���ǣ���Ϊ������������7�� 
	 * ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
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
	 * ��һ���ַ���(0<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,
	 * ����������λ��, ���û���򷵻� -1����Ҫ���ִ�Сд��.
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
	 * �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
	 * ����һ������,�����������е�����Ե�����P��
	 * ����P��1000000007ȡģ�Ľ������� �����P%1000000007
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
				//�����ⲽ���������ǹ鲢����
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
	 * �������������ҳ����ǵĵ�һ��������㡣
	 * ��ע����Ϊ�����������������Դ���������ݵ���ʾ����������ʽ��ʾ�ģ�
	 * ��֤������������ȷ�ģ�
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
