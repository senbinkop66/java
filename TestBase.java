import java.time.*;

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

}

class Manager extends Employee{
	//新增属性
	private double bonus;

	//子类构造器
	public Manager(String n,double s,int y,int m,int d){
		super(n,s,y,m,d);
		bonus=0;
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
}


public class TestBase{
	public static void main(String[] args){
		Employee[] staff=new Employee[4];

		staff[0]=new Employee("mane",20,2015,6,11);
		staff[1]=new Employee("Alison",23,2018,6,26);
		staff[2]=new Employee("Arnold",18,2006,6,6);
		Manager boss=new Manager("kloop",50,2015,10,10);
		boss.setBonus(1000);
		staff[3]=boss;
		
		for (Employee e:staff){
			e.raiseSalary(5);
		}

		for (Employee e:staff){
			System.out.println("name:"+e.getName()+",salary:"+e.getSalary()+",hireDay:"+e.getHireDay());
		}

	}
}