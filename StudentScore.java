

/**
 		项目一：统计学生成绩
 		@author senbin
 		@version 0.2
 */

import java.util.Scanner;

public class StudentScore{
	public static void main(String[] args){

		Scanner scanner=new Scanner(System.in);

		System.out.println("----------------欢迎使用学生成绩管理系统-----------------");
		System.out.print("请输入学生人数(1~10)：");
		
		int studentNumber=scanner.nextInt();
		if (studentNumber>0 && studentNumber<=10) {
			double[] scores=new double[studentNumber];
			for (int i=0; i<studentNumber;i++ ) {
				System.out.print("请选择学生"+(i+1)+"的分数(0~100)：");
				int score=scanner.nextInt();
				if (score>=0 && score<=100) {
					scores[i]=score;
				}
			}

			double maxScore=scores[0];
			for (int i=1; i<studentNumber;i++ ) {
				if (scores[i]>maxScore) {
					maxScore=scores[i];
				}
			}

			System.out.println("\n-----------------------------\n");


			for (int i=0; i<studentNumber;i++ ) {
				if (scores[i]>maxScore-10) {
					System.out.println("学生"+(i+1)+"的成绩是 "+scores[i]+",等级为 A");
				}else if(scores[i]>maxScore-20){
					System.out.println("学生"+(i+1)+"的成绩是 "+scores[i]+",等级为 B");
				}else if(scores[i]>maxScore-30){
					System.out.println("学生"+(i+1)+"的成绩是 "+scores[i]+",等级为 C");
				}else{
					System.out.println("学生"+(i+1)+"的成绩是 "+scores[i]+",等级为 D");
				}
			}

		}

		

		
	}
}