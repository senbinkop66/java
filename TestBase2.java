import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class TestBase2{
	public static void main(String[] args){
		String[] names={"mane","Alison","Arnold","salah"};
		System.out.print("原始顺序：");
		System.out.println(Arrays.toString(names));
		System.out.println("按字典排序：");
		Arrays.sort(names);
		System.out.println(Arrays.toString(names));
		System.out.println("按长度排序");
		Arrays.sort(names,(first,second)->first.length()-second.length());
		System.out.println(Arrays.toString(names));

		//构造一个定时器， 每隔 interval 毫秒通告 listener—次 ，
		Timer t=new Timer(2000,event->{
			System.out.println("the time is "+new Date());
		});
		t.start();  //启动定时器一旦启动成功， 定时器将调用监听器的 actionPerformed。
		JOptionPane.showMessageDialog(null,"Quit program");  //显示一个包含一条消息和 OK 按钮的对话框。
		System.exit(0);
		

	}
}

