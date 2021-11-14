public class TestDataType{
	public static void main(String[] args){
		byte byte1=100;
		System.out.println("byte1="+byte1);

		short short1=1000;
		System.out.println("short1="+short1);

		int int1=66;
		System.out.println("int1="+int1);

		long long1=10000l;
		System.out.println("long1="+long1);

		float float1=3.22f;
		System.out.println("float1="+float1);

		double double1=3.1223;
		System.out.println("double1="+double1);

		char char1='D';  //用单引号
		System.out.println("char1="+char1);
		char char2='你';
		System.out.println("char2="+char2);
		char char3='\u9999';  //直接使用 Unicode 值来表示字符型常量
		System.out.println("char3="+char3);  //char3=香

		boolean bool1=true;
		System.out.println("bool1="+bool1);

		String str1="hello";
		System.out.println("str1="+str1);
		System.out.println("str1+66="+(str1+66));

		String str2;
		str2=str1+"\t"+byte1+"\t"+short1+"\t"+int1;
		str2=str2+"\t"+float1+"\t"+double1+"\t";
		str2=str2+char1+"\t"+char2+"\t"+bool1;
		System.out.println("str2="+str2);
		System.out.println("a="+(1+'a'));

		String str3="66";
		int int3=Integer.parseInt(str3);
		System.out.println("int3="+int3);

		System.out.println(5%-2);

		int a=26;
		System.out.println("a="+a);
		int b;
		b=a++;
		System.out.println("a++="+b);
		b=++a;
		System.out.println("++a="+b);
		b=a--;
		System.out.println("a--="+b);
		b=--a;
		System.out.println("--a="+b);

		int x=3510;
		x=x/1000*1000;  //整数之间做除法时，只保留整数部分而舍弃小数部分
		System.out.println("x="+x);

		System.out.println("5+5="+5+5);

		System.out.println("my" instanceof String);

	}
}