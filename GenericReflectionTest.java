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
		//getTypeParameters()  如果这个方法被声明为泛型方法， 则获得泛型类型变量，否则返回长度为 0 的数组。
		printTypes(m.getTypeParameters(),"<",", ","> ",false);
		//getGenericReturnType()  获得这个方法被声明的泛型返回类型。
		printType(m.getGenericReturnType(),false);
		System.out.print(" ");
		System.out.print(name);
		System.out.print("(");
		//getGenericParameterTypes()  获得这个方法被声明的泛型参数类型。 如果这个方法没有参数， 返回长度为 0 的数组。
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
			//getName()  获得类型变量的名字。
			System.out.print(t.getName());
		}else if (type instanceof TypeVariable) {
			TypeVariable<?> t=(TypeVariable<?>) type;
			System.out.print(t.getName());;
			if (isDefinition) {
				//getBounds()  获得类型变量的子类限定，否则， 如果该变量无限定， 则返回长度为 0 的数组。
				printTypes(t.getBounds()," extends ","& ","",false);
			}
		}else if (type instanceof WildcardType) {
			WildcardType t=(WildcardType) type;
			System.out.print("?");
			//getUpperBounds()  获得这个类型变量的子类 ( extends) 限定，否则， 如果没有子类限定，则返回长度为0 的数组。
			printTypes(t.getUpperBounds()," extends ","& ","",false);
			//getLowerBounds()  获得这个类型变量的超类（super) 限定，否则， 如果没有超类限定， 则返回长度为 0的数组。
			printTypes(t.getLowerBounds()," super ","& ","",false);
		}else if (type instanceof ParameterizedType){
			ParameterizedType t=(ParameterizedType) type;
			//getOwnerType()  如果是内部类型， 则返回其外部类型， 如果是一个顶级类型， 则返回 null。
			Type owner=t.getOwnerType();
			if (owner!=null) {
				printType(owner,false);
				System.out.print(".");
			}
			//getRawType()  获得这个参数化类型的原始类型。
			printType(t.getRawType(),false);
			//getActualTypeArguments()  获得这个参数化类型声明时所使用的类型参数。
			printTypes(t.getActualTypeArguments(),"<",", ",">",false);
		}else if (type instanceof GenericArrayType){
			GenericArrayType t=(GenericArrayType) type;
			System.out.print("");
			//getGenericComponentType()  获得声明该数组类型的泛型组件类型。
			printType(t.getGenericComponentType(),isDefinition);
			System.out.print("[]");
		}
	}

	public static void main(String[] args) {
		//类名
		String name="Pair";
		try{
			Class<?> cl=Class.forName(name);
			printClass(cl);
			for (Method m:cl.getDeclaredMethods()){
				printMethod(m);
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}
/*
Compiling GenericReflectionTest.java......
------Output------
class Pair<T> extendsjava.lang.Object
public T getFirst()
public T getSecond()
public void setSecond(T)
public void setFirst(T)
*/