package Sorts;

/*
 * 冒泡排序,需要进行n-1趟排序即可，每次将最大的数的沉底（应该类似于每次把最小的数放到最高）
 * 优化：可设置flag位，若已排序成功就跳出循环，不需要进行n-1次
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
