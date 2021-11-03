import java.util.*;
import java.io.*;


interface MyInterface{
	void normalInterfaceMethod();
	default void methodDefault1(){
		init();
	}
	public default void methodDefault2(){
		init();
	}
	private void init(){
		System.out.println("默认方法中的通用操作");
	}
}

class MyInterfaceImpl implements MyInterface {
	@Override
	public void normalInterfaceMethod(){
		System.out.println("实现接口的方法");
	}
}

public class TestJava9{

	public static void main(String[] args) {
		/*
		MyInterfaceImpl impl=new MyInterfaceImpl();
		impl.methodDefault1();
		//impl.init();//不能调用

		List<String> namesList=new ArrayList <>();
		namesList.add("AAA");
		namesList.add("BBB");
		namesList.add("CCC");
		namesList=Collections.unmodifiableList(namesList);
		System.out.println(namesList);
	}
	*/
	/*
	List<String> list=Collections.unmodifiableList(Arrays.asList("a","b","c"));
	Set<String> set=Collections.unmodifiableSet(new HashSet<>(Arrays.asList("a","b","c")));
	*/
	/*
	Map<String,Integer> map=Collections.unmodifiableMap(new HashMap<>() {
		{
			put("a",1);
			put("b",2);
			put("c",3);
		}
	});
	map.forEach((k,v)->System.out.println(k+":"+v));
	*/
	/*
	List<String> list1=List.of("a","b","c");
	Set<String> set1=Set.of("a","b","c");
	Map<String,Integer> map1=Map.of("a",10,"b",20,"c",30);
	Map<String,Integer> map2=Map.ofEntries(Map.entry("a",10),Map.entry("b",20),Map.entry("c",30));
	*/
	/*
	List<Integer>list2=Arrays.asList(23,44,57,54,21,89,65,90);
	list2.stream().takeWhile(x->x<70).forEach(System.out::println);
	System.out.println();
	list2.stream().dropWhile(x->x>50).forEach(System.out::println);

	Stream<Object> stream1=Stream.ofNullable(null);
	System.out.println(stream1.count());
	Stream<Object> stream2=Stream.ofNullable("hello");
	System.out.println(stream2.count());
	//原来的控制终止方式
	Stream.iterate(1,i->i+1).limit(10).forEach(System.out::println);
	//现在的终止方式
	Stream.iterate(1,i->i<100,i->i+1).forEach(System.out::println);
	*/
	



	}
}
