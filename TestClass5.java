import java.util.Date;

class Base{
	int count=10;
	public void display(){
		System.out.println(this.count);
	}
}
class Sub extends Base{
	int count=20;
	public void display(){
		System.out.println(this.count);
	}
}



public class TestClass5{
	public static void main(String[] args){
		Sub s=new Sub();
		System.out.println(s.count);
		s.display();
		Base b=s;
		System.out.println(b==s);
		System.out.println(b.count);
		b.display();
		System.out.println(s.equals(b));
		String str1=new String("hello");
		String str2=new String("hello");
		System.out.println(str1==str2);
		System.out.println(str1.equals(str2));

		Date now=new Date();
		System.out.println("now="+now);  //相当于
		System.out.println("now="+now.toString());
		char[] arr = new char[] { 'a', 'b', 'c' };
		System.out.println(arr);  //abc
		System.out.println(arr.toString());  //C@3d075dc0

		Float f=Float.parseFloat("12.1");
		System.out.println(f);
		String fstr=String.valueOf(3.54f);  //
		System.out.println(fstr);
		System.out.println(5 + "");



	}
}