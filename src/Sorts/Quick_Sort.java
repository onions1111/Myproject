package Sorts;

/**
 *  ��������
 * ѡȡ�м�������߷ű��м���С�����֣��ұ߷ű��м���������֣��ٵݹ�����
 */

public class Quick_Sort {

	public static void quick(int[] a, int low, int high) {
		if (low > high)
			return;
		int i = low, j = high, key = a[low];
		while (i < j) {
			while (i < j && a[j] > key) {
				j--;
			}
			if (i < j) {
				a[i] = a[j];
			}
			while (i < j && a[i] <= key) {  //=�ŵ�λ��ͬһ������λ�ÿ��ܻ����Ⱥ������
				                            //��������ͬ���������ԶԽ����Ӱ��
				i++;
			}
			if (i < j) {
				a[j] = a[i];
			}
		}
		a[i] = key;
		quick(a, low, i - 1);
		quick(a, i + 1, high);
	}

	public static void main(String[] args) {
		int[] a = new int[] { 72, 6, 57, 88, 60, 42, 83, 72, 48, 85 };
		Quick_Sort.quick(a, 0, 9);
		for (int e : a) {
			System.out.println(e);
		}
	}

}
