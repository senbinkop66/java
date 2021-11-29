import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


class TestFrame extends JFrame{
	private static final int DEFAULT_WIDTH=600;
	private static final int DEFAULT_HEIGHT=600;

	private static final int TEXTAREA_ROWS=8;
	private static final int TEXTAREA_COLUMNS=20;

	public TestFrame(){
		
		//setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		JTextField textField=new JTextField();
		JPasswordField passwordField=new JPasswordField();

		JPanel northPane=new JPanel();
		northPane.setLayout(new GridLayout(2,2));
		northPane.add(new JLabel("user name: ",SwingConstants.RIGHT));
		northPane.add(textField);
		northPane.add(new JLabel("Password: : ",SwingConstants.RIGHT));
		northPane.add(passwordField);

		add(northPane,BorderLayout.NORTH);

		JTextArea textarea=new JTextArea(TEXTAREA_ROWS,TEXTAREA_COLUMNS);
		JScrollPane scrollPane=new JScrollPane(textarea);  //创建一个滚动窗格， 用来显示指定组件的内容。 组件内容超过显示范围时， 滚动条会自动地出现。
		add(scrollPane,BorderLayout.CENTER);

		JPanel southPane=new JPanel();

		JButton insertButton=new JButton("Insert");
		southPane.add(insertButton);
		insertButton.addActionListener(event->{
			textarea.append("user name: "+textField.getText()+" Password: "+new String(passwordField.getPassword())+"\n");
		});

		add(southPane,BorderLayout.SOUTH);
		pack();
	}
}


public class TestApplet3{
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame=new TestFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("文本框");  //设置框架标题
			frame.setLocation(300,300);
			frame.setVisible(true);  //使其可见性
		});
	}
}