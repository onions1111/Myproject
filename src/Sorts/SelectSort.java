package Sorts;

/*
 * 简单选择排序
 * 每趟从剩下的数中找出最小的数插入到第i个位置
 * 第一种方式：第一趟从第二个数开始，选出最小的数和第一个数比较或进行交换
 * 第二种方式：第一趟直接找出n个数的最下值  ??
 * 
 */

public class SelectSort {
	public int[] select(int[] array) {
		if (array.length == 0)
			return array;
		for (int i = 0; i < array.length - 1; i++) { // 最后一位可以不用再排序了，只剩下一个数
			int minindex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[minindex] > array[j]) {
					minindex = j;
				}
			}
			if (minindex != i) {   //避免重复，没有意义的操作
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
