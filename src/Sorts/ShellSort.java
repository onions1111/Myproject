package Sorts;

/*
 * 希尔排序，对直接插入排序的改进/不是很明白
 * 数据序列1： 13-17-20-42-28 利用插入排序，13-17-20-28-42. Number of swap:1;
 * 数据序列2： 13-17-20-42-14 利用插入排序，13-14-17-20-42. Number of swap:3;
 * 如果数据序列基本有序，使用插入排序会更加高效。
 * 如果第i位数字与i-1位数字比较，若a[i]>a[i-1],则不用继续向前递归，因为排序后前一位数字小小后一位数字
 * 
 */

public class ShellSort {
	public void shell(int[] array) {
//		int len = array.length;
//		int temp, gap = len / 2;
//		while(gap>0) {
//			for(int i = gap;i < len;i++) {
//				temp = array[i];
//				int preIndex = i - gap;
//				while (preIndex >= 0 && array[preIndex] > temp) {                    
//					array[preIndex + gap] = array[preIndex];                    
//					preIndex -= gap;                
//				}
//				array[preIndex + gap] = temp; 
//			}
//			gap /= 2;
//		}
		int temp = 0;
		   int incre = array.length;

		   while(true){
		       incre = incre/2;

		       for(int k = 0;k<incre;k++){    //根据增量分为若干子序列

		           for(int i=k+incre;i<array.length;i+=incre){

		               for(int j=i;j>k;j-=incre){
		                   if(array[j]<array[j-incre]){
		                       temp = array[j-incre];
		                       array[j-incre] = array[j];
		                       array[j] = temp;
		                   }else{     //如果不需交换，默认前面排序正确
		                       break;
		                   }
		               }
		           }
		       }

		       if(incre == 1){
		           break;
		       }
		   }
		   for(int e:array) {
				System.out.println(e);
			}
	}

	public static void main(String[] args) {
		ShellSort test = new ShellSort();
		int[] a = new int[] { 59, 20, 17, 13, 28, 14, 23, 83 };
		test.shell(a);

	}
}
