import java.util.*;

class Item implements Comparable<Item>{
	private String description;
	private int partNumber;

	public Item(String d,int p){
		description=d;
		partNumber=p;
	}

	public String getDescription(){
		return description;
	}
	public String toString(){
		return "[description="+description+", partNumber="+partNumber+"]";
	}
	public boolean equals(Object otherObject){
		if (this==otherObject) return true;
		if (otherObject==null) return false;
		if (getClass()!=otherObject.getClass()) return false;
		Item other=(Item) otherObject;
		return Objects.equals(description,other.description) && partNumber==other.partNumber;
	}
	public int hashCode(){
		return Objects.hash(description,partNumber);
	}
	public int compareTo(Item other){
		int diff=Integer.compare(partNumber,other.partNumber);
		return diff!=0 ? diff : description.compareTo(other.description);
	}
}

public class TestBase7{
	public static void main(String[] args) {
		SortedSet<Item> sorter=new TreeSet<>();  //构造一个空树集。
		sorter.add(new Item("mane",10));
		sorter.add(new Item("Arnold",66));
		sorter.add(new Item("Alison",1));
		System.out.println(sorter);

		NavigableSet<Item> sortByDescription = new TreeSet<>(Comparator.comparing(Item::getDescription));
		//返回用于对元素进行排序的比较器。 如果元素用 Comparable 接口的 compareTo方法进行比较则返回 null。
		sortByDescription.addAll(sorter);
		System.out.println(sortByDescription);

	}
}

