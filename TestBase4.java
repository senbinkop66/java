import java.util.*;
import java.io.*;

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
	}
}
/*
Compiling TestBase4.java......
------Output------
factorial(3):
TestBase4.factorial(TestBase4.java:8)
TestBase4.main(TestBase4.java:21)

factorial(2):
TestBase4.factorial(TestBase4.java:8)
TestBase4.factorial(TestBase4.java:16)
TestBase4.main(TestBase4.java:21)

factorial(1):
TestBase4.factorial(TestBase4.java:8)
TestBase4.factorial(TestBase4.java:16)
TestBase4.factorial(TestBase4.java:16)
TestBase4.main(TestBase4.java:21)

factorial(0):
TestBase4.factorial(TestBase4.java:8)
TestBase4.factorial(TestBase4.java:16)
TestBase4.factorial(TestBase4.java:16)
TestBase4.factorial(TestBase4.java:16)
TestBase4.main(TestBase4.java:21)

return 1
return 1
return 2
return 6
[Finished in 1.2s]
*/