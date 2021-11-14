
public class TestSearch{
	public static void main(String[] args){

		//二分查找算法
		int [] arr2=new int[]{-100,-45,-26,-2,0,10,25,37,67,89,98,106,111,389};

		boolean isFlag=true;
		int number=111;

		int head=0;  //首索引位置
		int end=arr2.length-1;  //尾索引位置

		while(head<=end){
			int middle=(head+end)/2;
			if (arr2[middle]==number) {
				System.out.println("元素"+number+"的索引为:"+middle);
				isFlag=false;
				break;
			}else if(arr2[middle]>number){
				end=middle-1;
			}else{
				head=middle+1;
			}
		}
		if (isFlag) {
			System.out.println("元素"+number+"不在数组中");
		}




		
	}
}