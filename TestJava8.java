import java.util.*;

public class TestJava8{
	public String toUpperString(MyFunc<String> mf,String str){
		return mf.getValue(str);
	}
	public void test1(){
		Boy b=new Boy("mane");
		Optional<Girl> opt=Optional.ofNullable(b.getGirlFriend());
		opt.ifPresent(System.out::println);

	}
	
	public static void main(String[] args) {
		
		//Lambda 表达式：语法
		//语法格式一：无参，无返回值
		Runnable r1=()->{System.out.println("无参，无返回值");};
		//语法格式二：Lambda 需要一个参数，但是没有返回值。
		Consumer<String> con=(String str)->{System.out.println("一个参数"+str);};
		//语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
		Consumer<String> con=(str)->{System.out.println(str);};
		//语法格式四：Lambda 若只需要一个参数时，参数的小括号可以省略
		Consumer<String> con=str->{System.out.println("一个参数可以省略小括号"+str);};
		//语法格式五：Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
		Comparator<Integer> com=(x,y)->{
			System.out.println("两个以上参数");
			return Integer.compare(x,y);
		};
		//语法格式六：当 Lambda 体只有一条语句时，return 与大括号若有，都可以省略
		Comparator<Integer> com=(x,y)->Integer.compare(x,y);

		//作为参数传递 Lambda 表达式
		String newStr=toUpperString((str)->str.toUpperCase(),"computer games");
		System.out.println(newStr);
		
		

	}
}