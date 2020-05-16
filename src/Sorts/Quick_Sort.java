package Sorts;

/**
 *  快速排序
 * 选取中间数，左边放比中间数小的数字，右边放比中间数大的数字，再递归排序
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
			while (i < j && a[i] <= key) {  //=放的位置同一个数的位置可能会有先后的区别，
				                            //但由于是同样的数所以对结果不影响
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
