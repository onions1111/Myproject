package Sorts;

/*
 * ϣ�����򣬶�ֱ�Ӳ�������ĸĽ�/���Ǻ�����
 * ��������1�� 13-17-20-42-28 ���ò�������13-17-20-28-42. Number of swap:1;
 * ��������2�� 13-17-20-42-14 ���ò�������13-14-17-20-42. Number of swap:3;
 * ����������л�������ʹ�ò����������Ӹ�Ч��
 * �����iλ������i-1λ���ֱȽϣ���a[i]>a[i-1],���ü�����ǰ�ݹ飬��Ϊ�����ǰһλ����СС��һλ����
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

		       for(int k = 0;k<incre;k++){    //����������Ϊ����������

		           for(int i=k+incre;i<array.length;i+=incre){

		               for(int j=i;j>k;j-=incre){
		                   if(array[j]<array[j-incre]){
		                       temp = array[j-incre];
		                       array[j-incre] = array[j];
		                       array[j] = temp;
		                   }else{     //������轻����Ĭ��ǰ��������ȷ
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
