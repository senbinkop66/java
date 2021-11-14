public final class TestFinal{
	//final标记的类不能被继承
	public static int totalNumber=5;
	public final int ID;
	public TestFinal(){
		ID=++totalNumber;  //可在构造器中给final修饰的“变量”赋值
	}
	public static void main(String[] args){
		TestFinal tf=new TestFinal();
		System.out.println(tf.ID);
		final int I=10;
		final int J;
		J=66;
		System.out.println(I+J);
	}
}