import java.util.*;

class Person{
	private String name;
	public Person(String n){
		name=n;
	}
	public String getName(){
		return name;
	}
}

public class TestBase6{
	public static void main(String[] args) {
		List<String> staff=new LinkedList<>();
		staff.add("mane");
		staff.add("Arnold");
		staff.add("Alison");

		List<String> sports=new LinkedList<>();
		sports.add("Robson");
		sports.add("Origin");
		sports.add("Hendson");
		sports.add("Milern");

		System.out.println("初始staff:"+staff);
		System.out.println("初始sport:"+sports);

		ListIterator<String> iter1=staff.listIterator();
		Iterator<String> iter2=sports.iterator();
		//合并
		while (iter2.hasNext()) {
			if (iter1.hasNext()) iter1.next();
			iter1.add(iter2.next());
		}
		System.out.println("合并sport到staff:"+staff);

		iter2=sports.iterator();
		while (iter2.hasNext()){
			iter2.next();  //跳过一个元素
			if (iter2.hasNext()) {
				iter2.next();
				iter2.remove();  //隔一个删一个
			}
		}
		System.out.println("从sport中隔一个删一个："+sports);

		staff.removeAll(sports);
		System.out.println("删除在staff中的sport:"+staff);
	}
}

