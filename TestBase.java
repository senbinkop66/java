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


public class TestBase{
	public static void main(String[] args){
		Employee[] staff=new Employee[3];

		staff[0]=new Employee("mane",20,1994,12,11);
		staff[1]=new Employee("Alison",23,1993,10,5);
		staff[2]=new Employee("Arnold",18,2000,4,12);

		for (Employee e:staff){
			System.out.println("name:"+e.getName()+",salary:"+e.getSalary()+",hireDay:"+e.getHireDay());
		}





	}
}