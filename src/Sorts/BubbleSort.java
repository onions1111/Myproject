package Sorts;

/*
 * ð������,��Ҫ����n-1�����򼴿ɣ�ÿ�ν��������ĳ��ף�Ӧ��������ÿ�ΰ���С�����ŵ���ߣ�
 * �Ż���������flagλ����������ɹ�������ѭ��������Ҫ����n-1��
 * 
 */

public class BubbleSort {
	public int[] BuSort(int[] array) {
		if(array.length == 0) 
			return array;
		for(int i = 0;i < array.length-1;i++) {
			for(int j = 0;j < array.length-1;j++) {
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		return array;
	}
	public static void main(String[] args) {
		BubbleSort test = new BubbleSort();
		int[] a = new int[] {2,23,3,4,46,34,12,5};
		int[] b = new int[8];
		b = test.BuSort(a);
		for(int e:b) {
			System.out.println(e);
		}
		
	}
}
