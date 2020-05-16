package Sorts;

import java.util.Arrays;

public class MergeSort {
	public static int count;
	public static void sort(int[] arr) {
		int[] temp = new int[arr.length];
		sort(arr,0,arr.length-1,temp);
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
				//求逆序对，但是只能通过百分之五十用例
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
	
	public static void main(String[] args) {
		int[] arr = {1,2,5,7,4,0};
		MergeSort.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(count);
	}
}
