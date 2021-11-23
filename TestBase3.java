import java.util.*;
import java.lang.reflect.*;

//调用器类
class TraceHandler implements InvocationHandler{
	private Object target;

	public TraceHandler(Object t){
		target=t;
	}
	public Object invoke(Object proxy,Method m,Object[] args) throws Throwable{
		//打印出方法名和参数
		System.out.print(target);
		System.out.print("."+m.getName()+"(");
		if (args!=null) {
			for (int i=0; i<args.length; i++){
				System.out.print(args[i]);
				if (i<args.length-1) {
					System.out.print(", ");
				}
			}
		}
		System.out.println(")");
		return m.invoke(target,args);
	}
}

public class TestBase3{
	public static void main(String[] args){
		Object[] elements=new Object[1000];
		for (int i=0; i<elements.length; i++) {
			//代理填充数组
			Integer value=i+1;
			InvocationHandler handler = new TraceHandler(value);
			Object proxy=Proxy.newProxyInstance(null,new Class[]{Comparable.class},handler);
			//由于数组中填充了代理对象， 所以 compareTo 调用了 TraceHander 类中的 invoke 方法。
			elements[i]=proxy;
		}
		//构建一个随机整数
		Integer key=new Random().nextInt(elements.length)+1;
		//搜索key
		int result=Arrays.binarySearch(elements,key);
		//输出结果
		if (result>0) {
			System.out.println("key="+key+",result="+elements[result]);
		}

	}
}
/*
Compiling TestBase3.java......
------Output------
500.compareTo(971)
750.compareTo(971)
875.compareTo(971)
938.compareTo(971)
969.compareTo(971)
985.compareTo(971)
977.compareTo(971)
973.compareTo(971)
971.compareTo(971)
971.toString()
key=971,result=971
*/