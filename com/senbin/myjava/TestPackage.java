package com.senbin.myjava;

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

public class TestPackage{
	public static void main(String[] args) {
		System.out.println("test Package");
	}
}