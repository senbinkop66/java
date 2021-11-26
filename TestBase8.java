import java.util.*;
import java.time.*;

class Employee implements Cloneable,Comparable<Employee>{
	// instance fields
	private String name;
	private double salary;
	private LocalDate hireDay;

	//constructor
	public Employee(String n,double s,int year,int month,int day){
		name=n;
		salary=s;
		hireDay=LocalDate.of(year,month,day);
	}

	public int hashCode(){
		return Objects.hash(name,salary,hireDay);
	}

	public String toString(){
		return getClass().getName()+"[name="+name+",salary="+salary+",hireDay="+hireDay+"]";
	}

	//method
	public String getName(){
		return name;
	}
	public double getSalary(){
		return salary;
	}
	public LocalDate getHireDay(){
		return hireDay;
	}
	public void raiseSalary(double byPercent){
		double raise=salary*byPercent/100;
		salary+=raise;
	}
	public boolean equals(Object otherObject){
		if (this==otherObject) {
			return true;
		}
		if (otherObject==null) {
			return false;
		}
		if (getClass()!=otherObject.getClass()) {
			return false;
		}
		Employee other=(Employee) otherObject;
		return Objects.equals(name,other.name) && salary==other.salary && Objects.equals(hireDay,other.hireDay);
	}

	public int compareTo(Employee other){
		return Double.compare(salary,other.salary);
	}

}

public class TestBase8{
	public static <T extends Comparable> T max(Collection<T> c){
		if (c.isEmpty()) throw new NoSuchElementException();
		Iterator<T> iter=c.iterator();
		T largest=iter.next();
		while (iter.hasNext()){
			T next=iter.next();
			if (largest.compareTo(next)<0) {
				largest=next;
			}
		}
		return largest;
	}
	public static void main(String[] args) {
		/*
		Map<String,Employee> staff=new HashMap<>();
		Employee staff1=new Employee("mane",20,1994,12,11);
		Employee staff2=new Employee("Alison",23,1993,10,5);
		staff.put("10",staff1);
		staff.put("1",staff2);
		staff.put("66",new Employee("Arnold",18,2000,4,12));
		staff.put("11",new Employee("salah",40,2017,7,2));

		staff.forEach((k,v)->{
			System.out.print("key="+k);
			System.out.println("\tvalue:"+v.toString());
			});
		System.out.println(staff.get("10"));
		staff.remove("1");
		staff.put("10",new Employee("OOOO",29,2021,11,26));

		System.out.println(staff.get("10"));
		staff.forEach((k,v)->{
			System.out.print("key="+k);
			System.out.println("\tvalue:"+v.toString());
			});
		Card[] cardDeck=new Card[52];
		...
		//将数组传递给一个期望得到列表或集合参数的方法
		List<Card> cardlist=Arrays.asList(cardDeck);
		//可以接收可变数目的参数
		List<String> names=Arrays.asList("mane","Alison","Arnold");
		//创建一个包含100个字符串的List,每个串都被设置为“DEFAULT”：
		List<String> settings=Collections.nCopies(100,"DEFAULT");
		*/

		List<Integer> numbers=new ArrayList<>();
		for (int i=1;i<=50;i++){
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		List<Integer> sub6=numbers.subList(0,6);
		Collections.sort(sub6);
		System.out.println(sub6);
		sub6.sort(Comparator.reverseOrder());
		System.out.println(sub6);
		//[48, 29, 25, 9, 6, 2]
	}
}

