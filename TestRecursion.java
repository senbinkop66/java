
public class TestRecursion{
	
	public static int factorial(int n){
		//计算n的阶乘
		if (n==1) {
			return n;
		}else{
			return n*factorial(n-1);
		}
	}

	public static int testF1(int n){
		//数列
		if (n==0) {
			return 1;
		}else if(n==1){
			return 4;
		}else{
			return 2*testF1(n-1)+testF1(n-2);
		}
	}

	public static void main(String[] args){
		int n=10;
		System.out.println(n+"!="+factorial(n));
		System.out.println("f("+n+")="+testF1(n));
		
	}
}