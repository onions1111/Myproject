package Sorts;

/*
 * 直接插入排序
 * 找第n个数字时，默认前n-1个数有序，将这第n个数插入到前n-1个数中
 */

public class InsertSort {
	public void insert(int[] array) {
		int temp;
		if(array.length == 0)
			System.out.println("wrong!");
//		for(int i = 0;i < array.length-1;i++) {
//			int index = i;
//			int temp = array[i+1]; //array[0]默认为有序，从array[1]开始
//			while(index >= 0 && temp < array[index]) {
//				array[index+1] = array[index];
//				index--;
//			}
//			array[index+1] = temp;
//		}
		/**
		 * 改进，更简单的代码，每步比较的时候都需要插入
		 */
		for(int i=0;i<array.length-1;i++){
		       for(int j=i+1;j>0;j--){
		           if(array[j] < array[j-1]){
		               temp = array[j-1];
		               array[j-1] = array[j];
		               array[j] = temp;
		           }else{         //不需要交换
		               break;
		           }
		       }
		   }
		for(int e:array) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		InsertSort test = new InsertSort();
		int[] a = new int[] {2,23,3,4,46,34,12,5};
		test.insert(a);
			
	}
}
