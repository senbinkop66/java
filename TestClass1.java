class Person{
	String name;  //属性，或成员变量
	int age;
	int sex;

	//构造器
	public Person(){}
	public Person(String n,int a,int s){
		name=n;
		age=a;
		sex=s;
	}

	public int showAge(){
		return age;
	}
	public void setAge(int a){
		age=a;
	}
	public void addAge(){
		age+=2;
	}
	public void walk(){
		//方法或函数
		System.out.println("走路...");
	}
	public String display(){
		return "姓名："+name+",年龄："+age;
	}
	public void study(){
		System.out.println("studying");
	}
}


public class TestClass1{
	public static void main(String[] args){
		Person p1=new Person("mane",28,1);
		p1.walk();
		System.out.println(p1.display());
		p1.age=29;
		System.out.println(p1.display());
		
		Person p2=new Person();
		p2.name="Alison";
		p2.setAge(30);
		p2.sex=1;
		p2.study();
		System.out.println(p2.showAge());
		p2.addAge();
		System.out.println(p2.showAge());


		new Person("salah",29,1).walk();  //匿名对象
		//




	}
}