import java.time.*;
import java.util.*;

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
		
		//声明和构造一个保存 Employee 对象的数组列表
		ArrayList<Employee> staff2= new ArrayList<>(100);

		staff2.add(new Employee("mane",20,2015,6,11));
		staff2.add(new Employee("Arnold",18,2006,6,6));

		System.out.println(staff2.size());  // 2
		Manager boss1=new Manager("kloop",50,2015,10,10);
		staff2.add(1,boss1);
		System.out.println(staff2.size());  // 3

		Employee re=staff2.remove(1);
		System.out.println(staff2.size());  // 2

		for (Employee e:staff2){
			System.out.println(e.getName());
		}
		//相同的效果
		for (int i=0; i<staff2.size(); i++) {
			System.out.println(staff2.get(i).getName());
		}


		
		
	}
}