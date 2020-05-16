package Problems;

public class GuangliandaTest {
	public static void main(String[] args) {
		GuangliandaTest sol = new GuangliandaTest();
		int[] num = new int[5];
		num = sol.count();
		System.out.println(num[4]);
		for (int i = 1000; i <= 2000; i++) {
			int numCoin = i;
			int numP = 5;
			boolean isTrue = true;
			while (numP-- > 0) {
				if ((numCoin % 4) == 0) {
					numCoin = numCoin * 5 / 4 - 1;
				} else {
					isTrue = false;
					break;
				}
			}
			if (isTrue) {
				System.out.println(i);
				int res = i / 4;
				System.out.println("1P have:" + res);
				res = (res * 5 - 1) / 4;
				System.out.println("2P have:" + res);
				res = (res * 5 - 1) / 4;
				System.out.println("3P have:" + res);
				res = (res * 5 - 1) / 4;
				System.out.println("4P have:" + res);
				res = (res * 5 - 1) / 4;
				System.out.println("5P have:" + res);
				break;
			}
		}
	}
	public int[] count() {
		int x5=0;
		for(int i = 250;i<=500;i++) {
			int x4 = 5*i -1;
			if(x4%5 == 4) {
				int x3 = 5*x4 -1;
				if(x3%5 == 4) {
					int x2 = 5*x3 -1;
					if(x2%5 == 4) {
						int x1 = 5*x2 -1;
						if(x1%5 == 4) {
							if(x1*5-1 == (x1+x2+x3+x4+i*5)/4-5)
							   x5 = i;
							
							System.out.println(x5);
						}
					}
				}
			}	
		}
		int[] num = new int[5];
		num[4] = x5;
		for(int i = 3;i>=0;i--) {
			num[i] = (num[i+1]*5 - 1)/4;
		}
		return num;
	}
	
}
