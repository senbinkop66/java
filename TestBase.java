import java.time.*;
import java.util.*;
import java.lang.reflect.*;

class Employee{
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
		
		Employee staff1=new Employee("name",20,2015,6,11);
		Employee staff2=new Employee("Arnold",18,2006,6,6);

		try{
			Class c1=staff1.getClass();
			Field f=c1.getDeclaredField("name");
			f.setAccessible(true);
			Object v=f.get(staff1);
			System.out.println(v);  //name
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
}