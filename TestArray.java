
import java.util.Arrays;
public class TestArray{
	public static void main(String[] args){
		/*
		int size=10;
		double[] mylist=new double[size];  //动态初始化
		for (int i=0; i<size; i++) {
			mylist[i]=i+1;
		}

		double total=0;
		for (int i=0; i<size; i++) {
			total+=mylist[i];
		}
		System.out.println("total="+total);

		double[] mylist2={2,4,7,9,18};  //静态初始化
		for (int i=0; i<mylist2.length; i++) {
			System.out.println(mylist2[i]+" ");
		}

		double max=mylist2[0];
		for (int i=0; i<mylist2.length; i++) {
			if (mylist2[i]>max) max=mylist2[i];
		}
		System.out.println("max="+max);

		for (double element:mylist2) {
			System.out.println(element);
		}
		System.out.println("数组长度："+mylist2.length);
		
		*/

		/*
		//多维数组
		int[][] arr1=new int[2][3];  //动态初始化
		arr1[1][1]=66;
		for (int i=0; i<2; i++) {
			for (int j=0; j<3; j++){
				System.out.println(arr1[i][j]);
			}
		}
		
		int[][] arr2=new int[][]{{1,2,3},{3,4},{4,5,6,7}};  //动态初始化
		for (int i=0; i<arr2.length; i++) {
			for (int j=0; j<arr2[i].length; j++){
				System.out.println(arr2[i][j]);
			}
		}

		int[][] arr3=new int[3][];
		arr3[0]=new int[]{3,5,8};
		arr3[1]=new int[]{12,9};
		arr3[2]=new int[]{7,0,6,4};
		int result=0;
		for (int i=0; i<arr3.length; i++) {
			for (int j=0; j<arr3[i].length; j++){
				result+=arr3[i][j];
			}
		}
		System.out.println("result="+result);
		*/

		//数组排序
		int[] numbers={3,43,25,67,89,45,21,56,90,100,3,4};
		Arrays.sort(numbers);
		for (int i=0;i<numbers.length;i++){
			System.out.print(numbers[i]+"\t");
		}
		System.out.print("\n");

	}
}