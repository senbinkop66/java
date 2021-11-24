import java.time.*;
import java.util.*;
import java.lang.reflect.*;

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

class Manager extends Employee{
	//新增属性
	private double bonus;

	//子类构造器
	public Manager(String n,double s,int y,int m,int d){
		super(n,s,y,m,d);
		bonus=0;
	}
	public String toString(){
		return super.toString()+",[bonus="+bonus+"]";
	}

	//新增方法
	public void setBonus(double bonus){
		this.bonus=bonus;
	}
	public double getBonus(){
		return bonus;
	}
	//覆盖方法
	public double getSalary(){
		//调用超类 Employee 中的 getSalary 方法
		double baseSalary=super.getSalary();
		return baseSalary+bonus;
	}
	public boolean equals(Object otherObject){
		if (!super.equals(otherObject)) {
			return false;
		}
		Manager other=(Manager) otherObject;
		return bonus==other.bonus;
	}
}

class Pair<T>{
	private T first;
	private T second;

	public Pair(){
		first=null;
		second=null;
	}
	public Pair(T first,T second){
		this.first=first;
		this.second=second;
	}
	public T getFirst(){
		return first;
	}
	public T getSecond(){
		return second;
	}
	public void setFirst(T newValue){
		first=newValue;
	}
	public void setSecond(T newValue){
		second=newValue;
	}
}
class ArrayAlg{
	public static boolean hasNulls(Pair<?> p){
		return p.getFirst()==null  || p.getSecond()==null;
	}
	public static void swap(Pair<?> p){swapHelper(p);}

	public static <T> void swapHelper(Pair<T> p){
		//swapHelper 是一个泛型方法， 而 swap 不是， 它具有固定的 Pair<?> 类型的参数。
		//在这种情况下，swapHelper 方法的参数 T 捕获通配符。
		T t=p.getFirst();
		p.setFirst(p.getSecond());
		p.setSecond(t);
	}
}

public class TestBase5{
	public static void printBuddies(Pair<? extends Employee> p){
		Employee first=p.getFirst();
		Employee second=p.getSecond();
		System.out.println(first.getName()+" and "+second.getName()+" are buddies");
	}
	public static void minmaxBonus(Manager[] a,Pair<? super Manager> result){
		if (a.length==0) return;
		Manager min=a[0];
		Manager max=a[0];
		for (int i=1; i<a.length; i++) {
			if (min.getBonus()>a[i].getBonus()) min=a[i];
			if (max.getBonus()<a[i].getBonus()) max=a[i];
		}
		result.setFirst(min);
		result.setSecond(max);
	}
	public static void maxminBonus(Manager[] a,Pair<? super Manager> result){
		minmaxBonus(a,result);
		ArrayAlg.swapHelper(result);
	}
	public static void main(String[] args){
		Manager ceo=new Manager("mane",20,1994,12,11);
		Manager cfo=new Manager("Alison",23,1993,10,5);

		Pair<Manager> buddies=new Pair<>(ceo,cfo);
		printBuddies(buddies);

		ceo.setBonus(100);
		cfo.setBonus(200);

		Manager[] managers={ceo,cfo};

		Pair<Employee> result=new Pair<>();
		minmaxBonus(managers,result);
		System.out.println("first: "+result.getFirst().getName()+", second: "+result.getSecond().getName());

		maxminBonus(managers,result);
		System.out.println("first: "+result.getFirst().getName()+", second: "+result.getSecond().getName());

	}
}
