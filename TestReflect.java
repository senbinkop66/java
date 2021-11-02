

public class TestReflect{
	public static void main(String[] args) {
		/*
		//test4.Person是test4包下的Person类
		String str="test4.Person";
		Class clazz=Class.forName(str);
		Object obj=clazz.newInstance();
		Field field=clazz.getField("name");
		field.set(obj,"mane");
		Object name=field.get(obj);
		System.out.println(name);
		*/
		/*
		Class c1=Object.class;
		Class c2=Comparable.class;
		Class c3=String[].class;
		Class c4=int[][].class;
		//Class c5=ElementType.class;
		Class c6=Override.class;
		Class c7=int.class;
		Class c8=void.class;
		Class c9=Class.class;

		int[] a=new int[10];
		int[] b=new int[100];
		Class c10=a.getClass();
		Class c11=b.getClass();
		//只要元素类型与维度一样，就是同一个Class
		System.out.println(c10==c11);
		*/
		//测试类的加载
		//主动引用：一定会导致A和Father的初始化
		//A a=new A();
		//System.out.println(A.m);

		//被动引用
		//A[] array=new A[5];  //不会导致A和Father的初始化
		//System.out.println(A.b);  //只会初始化Father
		//System.out.println(A.M);  //不会导致A和Father的初始化

		/*
		//获取一个系统类加载器
		ClassLoader classLoader=ClassLoader.getSystemClassLoader();
		System.out.println(classLoader);
		//获取系统类加载器的父类加载器，即扩展类加载器
		classLoader=classLoader.getParent();
		System.out.println(classLoader);
		//获取扩展类加载器的父类加载器，即引导类加载器
		classLoader=classLoader.getParent();
		System.out.println(classLoader);
		//测试JDK提供的Object类由哪个类加载器加载
		//classLoader=Class.forName("java.lang.Object").getClassLoader();
		//System.out.println(classLoader);
		//获取类路径下的指定文件的输入流
		InputStream in=null;
		in=this.getClass().getClassLoader().getResourceAsStream("A.properties");
		System.out.println(in);
		*/
		/*
		//根据全类名获取对应的Class对象
		String name="project.java.Person";
		Class clazz=null;
		clazz=Class.forName(name);
		//调用指定参数结构的构造器，生成Constructor的实例
		Constructor con=clazz.getConstructor(String.class,Integer.class);
		//通过Constructor的实例创建对应类的对象，并初始化类属性
		Person p2=(Person)con.newInstance("mane",28);
		System.out.println(p2);
		*/
		
	}
	/*
	static {
		System.out.println("main所在的类");
	}
	*/
}
class Father{
	static int b=2;
	static {
		System.out.println("父类被加载");
	}
}
class A extends Father{
	static {
		System.out.println("子类被加载");
		m=300;
	}
	static int m=100;
	static final int M=1;
}