class Person{
	public String name;
	public int age;
	public char sex;

	public Person(String name,char sex,int age){
		this.name=name;
		this.sex=sex;
		this.age=age;
	}
	public Person(String name,char sex){
		this(name,sex,22);
	}
	public Person(String name,int age){
		this(name,'男',age);
	}
	public Person(String name){
		this(name,'男',18);
	}

	public String getInfo(){
		return "姓名："+name+",性别："+sex+",年龄："+age;
	}

}
class Student extends Person{
	public long number;
	public int math;
	public int english;
	public int computer;
	public Student(String n,char s,int a,long k,int m,int e,int c){
		super(n,s,a);
		this.number=k;
		this.math=m;
		this.english=e;
		this.computer=c;
	}
	public double aver(){
		return (math+english+computer)/3;
	}
	public int max(){
		int maxVal;
		maxVal=math > english ? math :english;
		maxVal=maxVal > computer ? maxVal : computer;
		return maxVal;
	}
	public int min(){
		int minVal;
		minVal=math < english ? math :english;
		minVal=minVal < computer ? minVal : computer;
		return minVal;
	}
	public String getInfo(){
		//return "姓名："+name+",性别："+sex+",年龄："+age+",数学："+math+",英语："+english+"计算机："+computer;
		return super.getInfo()+",数学："+math+",英语："+english+"计算机："+computer;
	}
}


public class TestClass4{
	public static void main(String[] args){
		Student st1=new Student("mane",'男',28,10,80,88,69);
		System.out.println(st1.getInfo());
		Student st2=new Student("salah",'男',29,10,80,88,69);
		System.out.println(st2.getInfo());
		System.out.println(st2 instanceof Person);
		System.out.println(st2 instanceof Student);


	}
}