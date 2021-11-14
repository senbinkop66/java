
class Animal{
	private int legs;
	private String name;
	public Animal(){
		// 构造器
		name="dog";
		legs=4;
	}
	public void setLegs(int i){
		if (i!=0 && i!=2 && i!=4) {
			System.out.println("The number of legs is wrong!");
			return;
		}
		legs=i;
	}
	public int getLegs(){
		return legs;
	}
}

class Person{
	private String name;
	private int age;
	private String sex;
	public Person(){
		//无参构造器
		System.out.println("新对象实例化");
	}
	public Person(String n){
		this();  //调用本类中的无参构造器
		name=n;
		age=22;
	}
	public Person(String n,int a,String s){
		this.name=n;
		this.age=a;
		this.sex=s;
	}
	public Person(String n,int a){
		//构造器重载
		name=n;
		age=a;
	}
	public Person(String n,String s){
		this(n);  //调用有一个参数的构造器
		name=n;
		sex=s;
	}
	
	public String getInfo(){
		this.speak();
		return "姓名:"+name+",年龄:"+age+",性别:"+sex;
	}
	public void speak(){
		System.out.println("输出"+this.name+"的信息...");
	}
	public boolean compare(Person p){
		return this.name==p.name;
	}
}

public class TestClass3{
	
	public static void main(String[] args){
		Person p1=new Person("mane",28,"男");
		Person p2=new Person("salah",29);
		Person p3=new Person("Alison","男");
		Person p4=new Person("Arnold");
		System.out.println(p1.getInfo());
		System.out.println(p2.getInfo());
		System.out.println(p3.getInfo());
		System.out.println(p4.getInfo());
		System.out.println(p1.compare(p2));





		/*
		Animal animal1=new Animal();
		animal1.setLegs(2);
		//animal1.legs=2;  legs 在 Animal 中是 private 访问控制
		System.out.println(animal1.getLegs());
		*/
	}
}