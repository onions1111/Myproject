package Sorts;

/*
 * ֱ�Ӳ�������
 * �ҵ�n������ʱ��Ĭ��ǰn-1�������򣬽����n�������뵽ǰn-1������
 */

public class InsertSort {
	public void insert(int[] array) {
		int temp;
		if(array.length == 0)
			System.out.println("wrong!");
//		for(int i = 0;i < array.length-1;i++) {
//			int index = i;
//			int temp = array[i+1]; //array[0]Ĭ��Ϊ���򣬴�array[1]��ʼ
//			while(index >= 0 && temp < array[index]) {
//				array[index+1] = array[index];
//				index--;
//			}
//			array[index+1] = temp;
//		}
		/**
		 * �Ľ������򵥵Ĵ��룬ÿ���Ƚϵ�ʱ����Ҫ����
		 */
		for(int i=0;i<array.length-1;i++){
		       for(int j=i+1;j>0;j--){
		           if(array[j] < array[j-1]){
		               temp = array[j-1];
		               array[j-1] = array[j];
		               array[j] = temp;
		           }else{         //����Ҫ����
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
