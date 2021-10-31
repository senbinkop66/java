import java.util.*;

/*
private static class Node<E>{
	E item;
	Node<E> next;
	Node<E> prev;

	Node(Node<E> prev, E element,Node<E> next){
		this.item=element;
		this.next=next;
		this.prev=prev;
	}
}
*/

public class TestCollectionadnSet{
	public static void main(String[] args) {
		/*
		List list=new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		updateList(list);
		System.out.println(list);

		Set set=new LinkedHashSet();
		set.add(new String("AA"));
		set.add(345);
		set.add(345);

		Map map=new HashMap();
		map.put("A",1);
		map.put("B",2);
		map.put("C",3);

		System.out.println("map的所有key:");
		Set keys=map.keySet();
		for (Object key:keys) {
			System.out.println(key+"->"+map.get(key));
		}

		System.out.println("map的所有value:");
		Collection values=map.values();
		Iterator iter=values.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}

		System.out.println("map的所有的映射关系");
		Set mappings=map.entrySet();
		for (Object m:mappings) {
			Map.Entry entry=(Map.Entry) m;
			System.out.println("key是:"+entry.getKey()+",value是："+entry.getValue());
		}
		*/
		

	}
	private static void updateList(List list){
		list.remove(2);
	}
}