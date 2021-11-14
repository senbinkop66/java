import java.util.*;
import java.math.*;
import java.time.*;

class Employee{
	// instance fields
	private static int nextId=1;
	private int id;
	private String name;
	private double salary;
	private LocalDate hireDay;

	//constructor
	public Employee(String n,double s,int year,int month,int day){
		name=n;
		salary=s;
		id=0;
		hireDay=LocalDate.of(year,month,day);
	}

	//method
	public String getName(){
		return name;
	}
	public double getSalary(){
		return salary;
	}
	public int getId(){
		return id;
	}
	public void setId(){
		id=nextId;
		nextId++;
	}
	public static int getNextld(){
		//返回静态变量
		return nextId;
	}
	public LocalDate getHireDay(){
		return hireDay;
	}
	public void raiseSalary(double byPercent){
		double raise=salary*byPercent/100;
		salary+=raise;
	}
	
}

public class TestBase{
	public static void tripleValue(double x){
		x=3*x;
		System.out.println("end of method: x="+x);
	}
	public static void tripleSalary(Employee x){
		x.raiseSalary(200);
		System.out.println("end of method: salary="+x.getSalary());
	}
	public static void swap(Employee x,Employee y){
		Employee temp=x;
		x=y;
		y=temp;
		System.out.println("end of method: x="+x.getName());
		System.out.println("end of method: y="+y.getName());
	}

	public static void main(String[] args){
		Employee[] staff=new Employee[3];

		staff[0]=new Employee("mane",20,1994,12,11);
		staff[1]=new Employee("Alison",23,1993,10,5);
		staff[2]=new Employee("Arnold",18,2000,4,12);

		for (Employee e:staff){
			e.raiseSalary(5);
		}

		for (Employee e:staff){
			System.out.println("name:"+e.getName()+",salary:"+e.getSalary()+",hireDay:"+e.getHireDay());
		}

		System.out.println("方法不能修改一个基本数据类型的参数 ：");
		double percent=10;
		System.out.println("before: percent="+percent);
		tripleValue(percent);
		System.out.println("after: percent:"+percent);
		System.out.println();
		
		System.out.println("一个方法可以改变一个对象参数的状态:");
		Employee e1=new Employee("mmm",20,1994,12,11);
		System.out.println("before: salary:"+e1.getSalary());
		tripleSalary(e1);
		System.out.println("after: salary:"+e1.getSalary());
		System.out.println();
		
		System.out.println("一个方法不能让对象参数引用一个新的对象:");
		System.out.println("Test swap-->");
		Employee e2=new Employee("AAA",20,1994,12,11);
		Employee e3=new Employee("BBB",20,1994,12,11);
		System.out.println("before: e2="+e2.getName());
		System.out.println("before: e3="+e3.getName());
		swap(e2,e3);
		System.out.println("after: e2="+e2.getName());
		System.out.println("after: e3="+e3.getName());
		System.out.println();
		


	}
}
