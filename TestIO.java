import java.io.*;
import java.util.regex.*;
import java.util.*;

public class TestIO{
	public static FilenameFilter filter(final String regex){
		//创建匿名内部类
		return new FilenameFilter(){
			private Pattern pattern=Pattern.compile(regex);
			public boolean accept(File dir,String name){
				return pattern.matcher(name).matches();
			}
		};
	}
	public static void main(String[] args) {
		File path=new File(".");
		String[] listFiles;
		if (args.length==0) {
			listFiles=path.list();
		}else{
			//list()会为每一个文件调用accept()方法
			listFiles=path.list(filter(args[0]));
		}
		//按字母顺序排序
		Arrays.sort(listFiles,String.CASE_INSENSITIVE_ORDER);
		for (String item:listFiles){
			System.out.println(item);
		}
	}
}
