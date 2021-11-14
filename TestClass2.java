
class Circle{
	double radius=1;

	public void setRadius(double r){
		radius=r;
	}
	public double getRadius(){
		return radius;
	}
	double getAreas(){
		return Math.PI*radius*radius;
	}

}

class Rectangle{
	int width=1;
	int heigth=1;

	public void setWidth(int w){
		width=w;
	}
	public void setHeight(int h){
		heigth=h;
	}
	public double getAreas(){
		return width*heigth;
	}
	public void printRectangle(){
		for (int i=0; i<width; i++) {
			for (int j=0; j<heigth; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}

}

class Student{
	int number;
	int state;
	int score;
	public void setStudentInfo(int n,int st,int sc){
		number=n;
		state=st;
		score=sc;
	}
	public String getStudentInfo(){
		return "学号:"+number+"\t年级:"+state+"\t分数:"+score;
	}
	
}

class TestOverload{
	public void mOL(int n){
		System.out.println(n*n);
	}
	public void mOL(int m,int n){
		System.out.println(m*n);
	}
	public void mOL(String s){
		System.out.println(s);
	}
	public int max(int a,int b){
		return a>b ? a :b;
	}
	public double max(double a,double b){
		return a>b ? a :b;
	}
	public double max(double a,double b,double c){
		double maxVal= a>b ? a :b;
		return maxVal>c ? maxVal:c;
	}
	public void test(String[] msg){
		System.out.println("含字符串数组参数的test方法");
	}
	public void test1(String book){
		System.out.println("与可变形参方法构成重载的test1方法");
	}
	public void test1(String ...books){
		System.out.println("形参长度可变的test1方法");
	}

}
class DataSwap{
	public int a;
	public int b;
}




public class TestClass2{
	public static void swap(DataSwap ds){
		int temp=ds.a;
		ds.a=ds.b;
		ds.b=temp;
		System.out.println("swap方法里，a Field的值是" + ds.a + ";b Field的值是" + ds.b);
	}
	public static void printAreas(Circle c,int time){
		System.out.println("Radius\t\tArea");
		for (int i=1; i<=time; i++) {
			c.setRadius(i);
			System.out.println(c.getRadius()+"\t\t"+c.getAreas());
		}
	}
	public static void main(String[] args){

		Circle c1=new Circle();
		printAreas(c1,5);
		/*
		DataSwap ds=new DataSwap();
		ds.a=26;
		ds.b=66;
		swap(ds);
		System.out.println("swap方法里，a Field的值是" + ds.a + ";b Field的值是" + ds.b);
		*/
		/*
		TestOverload tol1=new TestOverload();
		tol1.mOL(5);
		tol1.mOL(5,6);
		tol1.mOL("overload");
		System.out.println(tol1.max(3,8));
		System.out.println(tol1.max(5.33,5.38));
		System.out.println(tol1.max(3.2,4.5,2.9));
		tol1.test(new String[]{"msg"});
		tol1.test1("book1");
		tol1.test1("book1","book2");
		*/
		/*
		int num=20;
		Student[] students=new Student[num];
		for (int i=0; i<num; i++) {
			students[i]=new Student();
			int st=(int)Math.round(Math.random()*5)+1;
			int sc=(int)Math.round(Math.random()*90)+10;
			students[i].setStudentInfo(i+1,st,sc);
		}
		for (int i=0; i<num; i++) {
			if (students[i].state==3) {
				System.out.println(students[i].getStudentInfo());
			}
		}
		*/


		/*
		Circle c1=new Circle();
		c1.setRadius(5);
		System.out.println(c1.getAreas());
		*/
		/*
		Rectangle rect1=new Rectangle();
		rect1.setWidth(10);
		rect1.setHeight(80);
		System.out.println(rect1.getAreas());
		rect1.printRectangle();
		*/






	}
}