import java.util.Date;
import java.util.Arrays;
import java.lang.Math;

//java比较器
class Goods implements Comparable{
	private String name;
	private double price;

	public Goods(String n,double p){
		this.name=n;
		this.price=p;
	}

	@Override
	public int compareTo(Object o){
		if (o instanceof Goods) {
			Goods other=(Goods) o;
			if (this.price>other.price) {
				return 1;
			}else if(this.price<other.price){
				return -1;
			}else{
				return 0;
			}
		}
		throw new RuntimeException("输入的数据类型不一致");
	}
}


public class TestSomeClass{
	public static void main(String[] args){

		System.out.println(System.getProperty("java.version"));
		System.out.println(System.getProperty("java.home"));
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("os.version"));
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("user.home"));
		System.out.println(System.getProperty("user.dir"));


		/*
		Goods[] all=new Goods[4];
		all[0]=new Goods("A",120);
		all[1]=new Goods("B",121);
		all[2]=new Goods("C",100);
		all[3]=new Goods("D",77);
		Arrays.sort(all);

		System.out.println(Arrays.toString(all));

		Arrays.sort(all,new Comparator(){
			@Override
			public int compare(Object o1,Object o2){
				Goods g1=(Goods) o1;
				Goods g2=(Goods) o2;
				return g1.getName().compareTo(g2.getName());
			}
		});
		System.out.println(Arrays.toString(all));
		*/
		/*
		String str1="abc";
		String str2="abc";
		String str3=new String("abc");
		String str4=new String("abc");
		System.out.println(str1==str2);
		System.out.println(str1==str3);
		System.out.println(str1==str4);
		System.out.println(str3==str4);
		String str5=str1.intern();
		System.out.println(str1==str5);
		String str6="> good evening 66 and go down|";
		System.out.println(str6.length());
		System.out.println(str6.charAt(5));
		System.out.println(str6.isEmpty());
		System.out.println(str6.toLowerCase());
		System.out.println(str6.toUpperCase());
		System.out.println(str6.trim());
		System.out.println(str6.equals("good"));
		System.out.println(str6.equalsIgnoreCase(str5));
		System.out.println(str3.concat(str4));
		System.out.println(str2.compareTo(str3));
		System.out.println(str6.substring(6));
		System.out.println(str6.substring(6,10));
		System.out.println(str6.endsWith("|"));
		System.out.println(str6.startsWith(">"));
		System.out.println(str6.startsWith("oo",3));
		System.out.println(str6.contains("d"));
		System.out.println(str6.indexOf("and"));
		System.out.println(str6.indexOf("and",16));
		System.out.println(str6.lastIndexOf("go"));
		System.out.println(str6.lastIndexOf("go",10));
		System.out.println(str6.replace("evening","morning"));
		System.out.println(str6.replaceAll("\\d+","[]"));
		System.out.println(str6.matches("\\d+"));
		String[] str6s=str6.split(" ");
		for (int i=0; i<str6s.length; i++) {
			System.out.println(str6s[i]);
		}
		
		String str1=new String("learn math");
		StringBuffer buf1=new StringBuffer("learn math");
		buf1.append(" difficult!");
		buf1.delete(3,5);
		System.out.println(buf1);
		*/
		/*
		//对比String、StringBuffer、StringBuilder
		long startTime=0L;
		long endTime=0L;
		String str1="";
		StringBuffer buf1=new StringBuffer("");
		StringBuilder bui1=new StringBuilder("");

		startTime=System.currentTimeMillis();
		for (int i=0; i<20000; i++) {
			buf1.append(String.valueOf(i));
		}
		endTime=System.currentTimeMillis();
		System.out.println("StringBuffer的执行时间为："+(endTime-startTime));

		startTime=System.currentTimeMillis();
		for (int i=0; i<20000; i++) {
			bui1.append(String.valueOf(i));
		}
		endTime=System.currentTimeMillis();
		System.out.println("StringBuilder的执行时间为："+(endTime-startTime));

		startTime=System.currentTimeMillis();
		for (int i=0; i<20000; i++) {
			str1=str1+i;
		}
		endTime=System.currentTimeMillis();
		System.out.println("String的执行时间为："+(endTime-startTime));
		*/
		/*
		String str=null;
		StringBuffer sb=new StringBuffer();
		sb.append(str);

		System.out.println(sb.length());
		System.out.println(sb);

		StringBuilder sb1=new StringBuilder(str);
		System.out.println(sb1);
		*/
		/*
		Date date=new Date();
		System.out.println(date);

		System.out.println(System.currentTimeMillis());
		System.out.println(date.getTime());

		Date date1=new Date(date.getTime());
		System.out.println(date1.getTime());
		System.out.println(date1.toString());
		*/




	}
}