abstract class A{
	//用abstract关键字来修饰一个类，这个类叫做抽象类
	abstract void m1();  //用abstract来修饰一个方法，该方法叫做抽象方法
	public void m2(){
		System.out.println("A类中定义的m2方法");
	}
}

class B extends A{
	//抽象类是用来被继承的，抽象类的子类必须重写父类的抽象方法，并提供方法体
	void m1(){
		System.out.println("B类中定义的m1方法");
	}
}

abstract class Template{
	public final void getTime(){
		long start=System.currentTimeMillis();
		code();
		long end=System.currentTimeMillis();
		System.out.println("执行的时间是："+(end-start));
	}
	public abstract void code();
}

class SubTemplate extends Template{
	public void code(){
		for (int i=0; i<10000; i++) {
			System.out.println(i);
		}
	}
}


public class TestAbstract{
	
	public static void main(String[] args){
		/*
		A a=new B();
		a.m1();
		a.m2();
		*/
		Template t1=new SubTemplate();
		t1.code();
	}
}