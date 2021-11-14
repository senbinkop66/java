/**
 * 文档注释
	@author senbin 指定java程序的作者
	@version 0.1  指定源文件的版本
 */

public class HelloWorld{
	//Java应用程序的执行入口是main()方法
	public static void main(String[] args){
		/* 多行注释
			输出 hello world
		 */
		System.out.println("Hello World！");  //单行注释

	}
}

/*
注释内容可以被JDK提供的工具 javadoc 所解析，生成一套以网页文件形
式体现的该程序的说明文档。
	javadoc -encoding utf-8 -d mydoc -author -version  HelloWorld.java

*/
	//一个源文件中最多只能有一个public类。其它类的个数不限
class Person{

}
class Animal{

}