public class PrintNumber{
	public static void main(String[] args){
		int n;
		n=6;
		int number1=n%10;
		int number2=n%100/10;
		int number3=n%1000/100;
		System.out.println("个位数："+number1);
		System.out.println("十位数："+number2);
		System.out.println("百位数："+number3);

	}
}