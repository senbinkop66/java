import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class TestFrame extends JFrame{
	private static final int DEFAULT_WIDTH=600;
	private static final int DEFAULT_HEIGHT=400;

	public TestFrame(){
		//构造器将框架大小设置为 300 x 200 像素。
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		CalculatorPanel panel1=new CalculatorPanel();
		add(panel1);
		pack();
	}

}


class CalculatorPanel extends JPanel{
	private JButton display;
	private JPanel panel;
	private double result;
	private String lastCommand;
	private boolean start;

	public CalculatorPanel(){
		setLayout(new BorderLayout());
		result=0;
		lastCommand="=";
		start=true;

		display=new JButton("0");
		display.setEnabled(false);
		add(display,BorderLayout.NORTH);

		ActionListener insert=new InsertAction();
		ActionListener command=new CommandAction();

		panel=new JPanel();
		panel.setLayout(new GridLayout(4,4));

		addButton("7",insert);
		addButton("8",insert);
		addButton("9",insert);
		addButton("/",command);
		addButton("4",insert);
		addButton("5",insert);
		addButton("6",insert);
		addButton("*",command);
		addButton("1",insert);
		addButton("2",insert);
		addButton("3",insert);
		addButton("-",command);
		addButton("0",insert);
		addButton(".",insert);
		addButton("=",command);
		addButton("+",command);

		add(panel,BorderLayout.CENTER);
	}
	private void addButton(String label,ActionListener listener){
		JButton button=new JButton(label);
		button.addActionListener(listener);
		panel.add(button);
	}
	//内部类
	private class InsertAction implements ActionListener{
		public void actionPerformed(ActionEvent event){
			String input=event.getActionCommand();
			if (start) {
				display.setText("");
				start=false;
			}
			display.setText(display.getText()+input);
		}
	}
	//内部类
	private class CommandAction implements ActionListener{
		public void actionPerformed(ActionEvent event){
			String command=event.getActionCommand();
			if (start) {
				if (command.equals("-")) {
					display.setText(command);
					start=false;
				}else{
					lastCommand=command;
				}
			}else{
				calculate(Double.parseDouble(display.getText()));
				lastCommand=command;
				start=true;
			}
		}
	}
	public void calculate(double x){
		if (lastCommand.equals("+")) {
			result+=x;
		}else if(lastCommand.equals("-")){
			result-=x;
		}else if(lastCommand.equals("*")){
			result*=x;
		}else if(lastCommand.equals("/")){
			result/=x;
		}else if(lastCommand.equals("=")){
			result=x;
		}
		display.setText(""+result);
	}
}

public class TestApplet2{
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame=new TestFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("计算器");  //设置框架标题
			frame.setLocation(300,300);
			frame.setVisible(true);  //使其可见性
		});
	}
}