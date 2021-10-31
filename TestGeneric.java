import java.util.*;

public class TestGeneric{
	public static void main(String[] args) {
		/*
		ArrayList<Integer> list=new ArrayList<>();  //类型推断
		list.add(26);
		list.add(36);
		list.add(46);
		list.add(56);

		//遍历方式一
		for (Integer i:list){
			//不需要强转
			System.out.println(i);
		}

		//遍历方式二
		Iterator<Integer> iterator=list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}

		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("A",1);
		map.put("B",2);
		map.put("C",3);

		Set<Entry<String,Integer>> entrySet=map.entrySet();
		Iterator<Entry<String,Integer>> iterator2=entrySet.iterator();
		while(iterator.hasNext()){
			Entry<String,Integer> entry=iterator2.next();
			System.out.println(entry.getKey()+"--->"+entry.getValue());
		}
		*/
		//通配符的使用
		List<?> list=null;

		list=new ArrayList<String>();
		list=new ArrayList<Double>();

		list.add(null);

		List<String>l1=new ArrayList<String>();
		List<Integer> l2=new ArrayList<Integer>();
		l1.add("fan test");
		l2.add(19);
		read(l1);
		read(l2);


	}
	public static void read(List<?> list){
		for (Object o:list) {
			System.out.println(o);
		}
	}
}