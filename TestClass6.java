class Person{
	private int id;
	public static int total=0;
	public Person(){
		total++;
		id=total;
	}
	public int getId(){
		return id;
	}
	public static int getTotalPerson(){
		return total;
	}
}
class Singleton{
	//私有化构造器
	private Singleton(){

	}
	//内部提供一个当前类的实例
	//此实例也必须静态化
	//private static Singleton single=new Singleton();   //饿汉式
	private static Singleton single;  //懒汉式
	//提供公共的静态的方法，返回当前类的对象
	public static Singleton getInstance(){
		if (single==null) {
			single=new Singleton();
		}
		return single;
	}
}
class Animal{
	public static int total;
	static {
		//static代码块通常用于初始化static的属性
		total=100;
		System.out.println("in static block!");
	}
}
final class A{
	//final标记的类不能被继承
	private final String SCHOOL="uestc";  //声明常量
	public final void print(){
		//final标记的方法不能被子类重写。
		System.out.println("A");
	}
}
public class TestClass6{
	
	public static void main(String[] args){
		/*
		//Person.total=66;  //不用创建对象就可以访问静态成员
		//System.out.println(Person.total);
		//没有创建对象也可以访问静态方法
		System.out.println("总人数："+Person.getTotalPerson());

		Person p1=new Person();
		System.out.println("p1.id="+p1.getId());
		//System.out.println(p1.total);
		System.out.println("总人数："+Person.getTotalPerson());

		System.out.println("total="+Animal.total);
		System.out.println("total="+Animal.total);
		*/

	}
}