package Sorts;

/*
 * ��ѡ������
 * ÿ�˴�ʣ�µ������ҳ���С�������뵽��i��λ��
 * ��һ�ַ�ʽ����һ�˴ӵڶ�������ʼ��ѡ����С�����͵�һ�����Ƚϻ���н���
 * �ڶ��ַ�ʽ����һ��ֱ���ҳ�n����������ֵ  ??
 * 
 */

public class SelectSort {
	public int[] select(int[] array) {
		if (array.length == 0)
			return array;
		for (int i = 0; i < array.length - 1; i++) { // ���һλ���Բ����������ˣ�ֻʣ��һ����
			int minindex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[minindex] > array[j]) {
					minindex = j;
				}
			}
			if (minindex != i) {   //�����ظ���û������Ĳ���
				int temp = array[i];
				array[i] = array[minindex];
				array[minindex] = temp;
			}
		}
		return array;
	}

	public static void main(String[] args) {
		SelectSort test = new SelectSort();
		int[] a = new int[] { 2, 23, 3, 4, 46, 34, 12, 5 };
		int[] b = new int[8];
		b = test.select(a);
		for (int e : b) {
			System.out.println(e);
		}
	}
}
