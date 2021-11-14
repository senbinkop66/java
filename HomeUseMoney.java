/**
 		项目一：家庭收支记账软件
 		@author senbin
 		@version 0.2
 */

import java.util.Scanner;

public class HomeUseMoney{
	public static void main(String[] args){
		System.out.println("----------------欢迎使用家庭收支记账软件-----------------");
		System.out.println("                     1  收支明细                         ");
		System.out.println("                     2  登记收入                         ");
		System.out.println("                     3  登记支出                         ");
		System.out.println("                     4  退    出                         ");

		double detail=0;
		double income=0;
		double spending=0;
		Scanner scanner=new Scanner(System.in);

		for (; ; ) {
			System.out.print("                   请选择（1-4）:");
			int x=scanner.nextInt();
			if (x>0 && x<5) {
				if (x==1) {
					System.out.println("收支明细"+detail);
				}else if(x==2){
					System.out.println("登记收入"+income);
				}else if(x==3){
					System.out.println("登记支出"+spending);
				}else{
					System.out.println("感谢使用,good bye!");
					break;
				}
			}
		}
	}
}