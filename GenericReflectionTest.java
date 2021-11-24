import java.util.*;
import java.lang.reflect.*;

class Pair<T>{
	private T first;
	private T second;

	public Pair(){
		first=null;
		second=null;
	}
	public Pair(T first,T second){
		this.first=first;
		this.second=second;
	}
	public T getFirst(){
		return first;
	}
	public T getSecond(){
		return second;
	}
	public void setFirst(T newValue){
		first=newValue;
	}
	public void setSecond(T newValue){
		second=newValue;
	}
}
class ArrayAlg{
	public static boolean hasNulls(Pair<?> p){
		return p.getFirst()==null  || p.getSecond()==null;
	}
	public static void swap(Pair<?> p){swapHelper(p);}

	public static <T> void swapHelper(Pair<T> p){
		//swapHelper 是一个泛型方法， 而 swap 不是， 它具有固定的 Pair<?> 类型的参数。
		//在这种情况下，swapHelper 方法的参数 T 捕获通配符。
		T t=p.getFirst();
		p.setFirst(p.getSecond());
		p.setSecond(t);
	}
}


public class GenericReflectionTest{
	public static void printClass(Class<?> cl){
		System.out.print(cl);;
		//getTypeParameters() 如果这个类型被声明为泛型类型， 则获得泛型类型变量，否则获得一个长度为 0 的数组。
		printTypes(cl.getTypeParameters(),"<",", ",">",true);
		//getGenericSuperclass() 获得被声明为这一类型的超类的泛型类型； 如果这个类型是 Object 或不是一个类类型(class type), 则返回 null。
		Type sc=cl.getGenericSuperclass();
		if (sc!=null) {
			System.out.print(" extends");;
			printType(sc,false);
		}
		//getGenericInterfaces() 获得被声明为这个类型的接口的泛型类型（以声明的次序)， 否则， 如果这个类型没有实现接口，返回长度为 0 的数组。
		printTypes(cl.getGenericInterfaces()," implements ",", ","",false);
		System.out.println();
	}
	public static void printMethod(Method m){
		String name=m.getName();
		System.out.print(Modifier.toString(m.getModifiers()));
		System.out.print(" ");
		printTypes(m.getTypeParameters(),false);
		System.out.print(" ");
		System.out.print(name);
		System.out.print("(");
		printTypes(m.getGenericParameterTypes(),"",", ","",false);
		System.out.println(")");
	}
	public static void printTypes(Type[] types,String pre,String sep,String suf,boolean isDefinition){
		if (pre.equals(" extends ") && Arrays.equals(types,new Type[]{Object.class})) {
			return;
		}
		if (types.length>0) {
			System.out.print(pre);
		}
		for (int i=0; i<types.length; i++) {
			if (i>0) System.out.print(sep);
			printType(types[i],isDefinition);
		}
		if (types.length>0) System.out.print(suf);
	}
	public static void printType(Type type,boolean isDefinition){
		if (type instanceof Class) {
			Class<?> t=(Class<?>) type;
			System.out.print(t.getName());
		}else if (type instanceof TypeVariable) {
			TypeVariable<?> t=(TypeVariable<?>) type;
			System.out.print(t.getName());;
			if (isDefinition) {
				printTypes(t.getBounds()," extends ","& ","",false);
			}else if (type instanceof WildcardType) {
				WildcardType t=(WildcardType) type;
				System.out.print("?");
				printTypes(t.getUpperBound()," extends ","& ",""<false);
				printTypes(t.getLowerBound()," super ","& ","",false);
			}else if (type instanceof ParameterizedType){
				ParameterizedType t=(ParameterizedType) type;
				Type owner=t.getOwnerType();
				if (owner!=null) {
					printType(owner,false);
					System.out.print(".");
				}
				printType(t.getRawType(),false);
				printTypes(t.getActualTypeArguments(),"<",", ",">",false);
			}else if (type instanceof GenericArrayType){
				GenericArrayType t=(GenericArrayType) type;
				System.out.print("");
				printType(t.getGenericComponentType(),isDefinition);
				System.out.print("[]");
			}
		}
	}

	public static void main(String[] args) {
		String name="Pair";  //类名
		try{
			Class<?> cl=Class.forName(name);
			printClass(cl);
			for (Method m:cl.getDeclaredMethods()){
				printMethod(m);
			}
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}

	}
}