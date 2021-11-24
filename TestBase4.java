import java.util.*;
import java.io.*;
import java.util.logging.*;

public class TestBase4{

	public static int factorial(int n){
		System.out.println("factorial("+n+"):");
		Throwable t=new Throwable();
		StackTraceElement[] frames=t.getStackTrace();
		for (StackTraceElement f:frames) {
			System.out.println(f);
		}
		System.out.println();
		int r;
		if (n<1) r=1;
		else r=n*factorial(n-1);
		System.out.println("return "+r);
		return r;
	}
	public static void main(String[] args){
		factorial(3);
		Logger.getGlobal().info("File->Open menu item selected");
	}
}

private static final Logger myLogger=Logger.getLogger("com.mycompany.myapp");