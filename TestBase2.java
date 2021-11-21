import java.util.*;
import java.lang.reflect.*;


public class TestBase2{
	public static void main(String[] args){
		//从命令行读取类名
		String name="java.lang.reflect.Method";
		
		try{
			//输出类名和超类名
			Class c1=Class.forName(name);
			Class superC1=c1.getSuperclass();
			String modifiers=Modifier.toString(c1.getModifiers());
			if (modifiers.length()>0) {
				System.out.print(modifiers+" ");
			}
			System.out.print("class "+name);
			if (superC1!=null && superC1!=Object.class) {
				System.out.print(" extends "+superC1.getName());
			}
			System.out.print("\n{\n");
			printConstructors(c1);
			
			System.out.println();
			printMethods(c1);
			
			System.out.println();
			printFields(c1);
			System.out.println("}");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		System.exit(0);
	}
	public static void printConstructors(Class c0){
		Constructor[] constructors=c0.getDeclaredConstructors();
		for (Constructor c:constructors){
			String name=c.getName();
			System.out.print("  ");
			String modifiers=Modifier.toString(c.getModifiers());
			if (modifiers.length()>0) {
				System.out.print(modifiers+" ");
			}
			System.out.print(name+"(");

			Class[] paramsTypes=c.getParameterTypes();
			for (int i=0; i<paramsTypes.length; i++) {
				if (i>0) {
					System.out.print(", ");
				}
				System.out.print(paramsTypes[i].getName());
			}
			System.out.print(");");
		}
	}
	public static void printMethods(Class c0){
		Method[] methods=c0.getDeclaredMethods();
		for (Method m:methods) {
			Class retType=m.getReturnType();
			String name=m.getName();
			System.out.print("  ");
			String modifiers=Modifier.toString(m.getModifiers());
			if (modifiers.length()>0) {
				System.out.print(modifiers+" ");
			}
			System.out.print(retType.getName()+" "+name+"(");
			Class[] paramsTypes=m.getParameterTypes();
			for (int j=0; j<paramsTypes.length; j++) {
				if (j>0) {
					System.out.print(", ");
					System.out.print(paramsTypes[j].getName());
				}
			}
			System.out.println(");");
		}
	}

	public static void printFields(Class c0){
		Field[] fields=c0.getDeclaredFields();
		for (Field f:fields) {
			Class type=f.getType();
			String name=f.getName();
			System.out.print("  ");
			String modifiers=Modifier.toString(f.getModifiers());
			if (modifiers.length()>0) {
				System.out.print(modifiers+" ");
			}
			System.out.println(type.getName()+" "+name+";");
		}
	}
}