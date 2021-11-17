package abstractClasses;

import java.time.*;

public class Employee extends Person{
	private double salary;
	private LocalDate hireDay;

	//constructor
	public Employee(String n,double s,int year,int month,int day){
		super(n);
		this.salary=s;
		hireDay=LocalDate.of(year,month,day);
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
	public String getDescription(){
		return String.format("an employee with a salary of $%.2f",salary);
	}

}