import java.util.*;

public class TestBase2{
	public static void main(String[] args){
		
		int[] numbers={3,5,7,9,0,12};
		System.out.println(""+numbers);  //[I@8efb846  ,前缀 [I 表明是一个整型数组
		System.out.println(Arrays.toString(numbers));  //[3, 5, 7, 9, 0, 12]
		//要想打印多维数组（即， 数组的数组）则需要调用 Arrays.deepToString 方法。
		int [][] numbers2={{3,4,5,6},{2,3,4},{2,1}};
		System.out.println(Arrays.deepToString(numbers2));  //[[3, 4, 5, 6], [2, 3, 4], [2, 1]]

		void set(int index,E obj)
		//设置数组列表指定位置的元素值， 这个操作将覆盖这个位置的原有内容。
		E get(int index)
		//获得指定位置的元素值。
		void add(int index,E obj)
		//向后移动元素， 以便插入元素。
		E remove(int index)
		//删除一个元素，并将后面的元素向前移动。被删除的元素由返回值返回。

	}
}