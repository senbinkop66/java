import java.util.Scanner;

public class TestExample1{
	public static void main(String[] args){
		

		/*
		int x=1;
		int y=1;
		if (x++==2 & ++y==2) {
			x=7;
		}
		System.out.println("x="+x+"\ny="+y);
		*/
		/*
		if (x++==1 & ++y==1) {
			x=7;
		}
		System.out.println("x="+x+"\ny="+y);
		*/
		/*
		if (++y==2 & ++y==2) {
			x=7;
		}
		System.out.println("x="+x+"\ny="+y);
		*/
		/*
		for (int i=1; i<=100; i++) {
			if (i%11==0) {
				System.out.println("i="+i);
			}
		}
		*/

		/*
		//打印1~100之间所有是7的倍数的整数的个数及总和
		int number1=0;
		int result=0;
		for (int i=1; i<=100; i++) {
			if (i%7==0) {
				number1++;
				result+=i;
			}
		}
		System.out.println("1~100之间所有是7的倍数的整数的个数:"+number1+",总和:"+result);
		*/

		/*
		//输出所有的水仙花数，所谓水仙花数是指一个3位数，其各个位上数字立方和等于其本身。
		int number1=0;
		int number2=0;
		int number3=0;
		int result=0;
		for (int i=100; i<1000; i++) {
			number1=i%10;
			number2=i%100/10;
			number3=i%1000/100;
			result=number1*number1*number1+number2*number2*number2+number3*number3*number3;
			if (i==result) {
				System.out.println(i+"="+number3+"^3+"+number2+"^3+"+number1+"^3");
			}
		}
		*/

		/*
		//从键盘读入个数不确定的整数，并判断读入的正数和负数的个数，输入为0时结束程序。
		Scanner scanner=new Scanner(System.in);
		int number1=0;
		int number2=0;
		while (true) {
			System.out.println("请输入一个整数：");
			int x=scanner.nextInt();
			if (x>0) {
				number1++;
			}else if(x<0){
				number2++;
			}else{
				break;
			}
		}
		System.out.println("正数："+number1+",负数："+number2);
		*/

		/*
		//九九乘法表
		for (int i=1; i<10; i++) {
			for (int j=1; j<10; j++) {
				if (i>=j) {
					System.out.print(i*j+"\t");
				}
			}
			System.out.print("\n");
		}
		*/
		/*
		//使用二维数组打印一个 10 行杨辉三角。
		int n=20;
		int[][] yanghui=new int [n][];
		yanghui[0]=new int[]{1};
		yanghui[1]=new int[]{1,1};
		System.out.println(yanghui[0][0]);
		System.out.println(yanghui[1][0]+"\t"+yanghui[1][1]);
		for (int i=2; i<n; i++) {
			yanghui[i]=new int[i+1];
			for (int j=0; j<=i; j++) {
				if (j==0) {
					yanghui[i][j]=1;
					System.out.print(yanghui[i][j]+"\t");
				}else if(j==i){
					yanghui[i][j]=1;
					System.out.print(yanghui[i][j]);
				}else{
					yanghui[i][j]=yanghui[i-1][j-1]+yanghui[i-1][j];
					System.out.print(yanghui[i][j]+"\t");
				}
			}
			System.out.print("\n");
		}
		*/
		/*
		//定义一个int型的一维数组，包含10个元素，分别赋一些随机整数
		int arr1[]=new int [10];
		for (int i=0;i<10;i++){
			arr1[i]=(int)(Math.random()*90+10);
			System.out.print(arr1[i]+"\t");
		}
		System.out.println();
		*/

		







	}
}