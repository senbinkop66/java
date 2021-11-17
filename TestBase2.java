import java.util.*;

public class TestBase2{
	public static void main(String[] args){
		//String 类使用下列算法计算散列码
		String[] names=new String[]{"good","bad","well"};
		int hash=0;
		for (int i=0; i<name.length; i++) {
			hash=31*hash+charAt(i);
		}

	}
}