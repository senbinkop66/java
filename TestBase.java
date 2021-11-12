import java.util.*;
import java.math.*;

public class TestBase{
	public static void main(String[] args){
		if (args.length==0 || args[0].equals("-h")) {
			System.out.println("Hello,");
		}else if(args[0].equals("-g")){
			System.out.println("Goodbye,");
		}
		for (int i=1; i<args.length; i++) {
			System.out.println(" "+args[i]);
		}

		//java TestBase -g senbin 36
		//java TestBase -h senbin 36



	}
}
