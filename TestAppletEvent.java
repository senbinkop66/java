import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.event.*;

class ButtonFrame extends JFrame{
	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH=300;
	private static final int DEFAULT_HEIGHT=200;
	public ButtonFrame(){
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		//创建buttons
		JButton yellowButton=new JButton("Yellow");
		//构造一个按钮。标签可以是常规的文本， 从 Java SE 1.3 开始， 也可以是 HTML。例如，“ <html><b>Ok</b></html>”。
		JButton blueButton=new JButton("Blue");
		JButton redButton=new JButton("Red");

		buttonPanel=new JPanel();
		//将按钮添加到面板中需要调用 add 方法
		buttonPanel.add(yellowButton);
		buttonPanel.add(blueButton);
		buttonPanel.add(redButton);
		//将组件  添加到这个容器中。
		add(buttonPanel);

		//为每种颜色构造一个对象， 并将这些对象设置为按钮监听器
		ColorAction yellowAction=new ColorAction(Color.YELLOW);
		ColorAction blueAction=new ColorAction(Color.BLUE);
		ColorAction redAction=new ColorAction(Color.RED);

		//为按钮绑定事件
		yellowButton.addActionListener(yellowAction);
		blueButton.addActionListener(blueAction);
		redButton.addActionListener(redAction);
	}
	//
	private class ColorAction implements ActionListener{
		private Color backgroundColor;
		public ColorAction(Color c){
			backgroundColor=c;
		}
		public void actionPerformed(ActionEvent event){
			buttonPanel.setBackground(backgroundColor);
		}
	}
}

class PlafFrame extends JFrame{
	private static final int DEFAULT_WIDTH=300;
	private static final int DEFAULT_HEIGHT=200;

	private JPanel buttonPanel;
	public PlafFrame(){
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		buttonPanel=new JPanel();
		//获得一个用于描述已安装的观感实现的对象数组。
		UIManager.LookAndFeelInfo[] infos=UIManager.getInstalledLookAndFeels();
		for (UIManager.LookAndFeelInfo info:infos){
			//返回观感的显示名称。 返回观感实现类的名称。
			makeButton(info.getName(),info.getClassName());
		}
		add(buttonPanel);
		pack();
	}
	private void makeButton(String name, String className){
		JButton button = new JButton(name);
		buttonPanel.add(button);
		button.addActionListener(event ->{
			try{
				//利用给定的类名设置当前的观感。 
				UIManager.setLookAndFeel(className);
				SwingUtilities.updateComponentTreeUI(this);
				pack();
			}catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}

public class TestAppletEvent{
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame=new PlafFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("改变观感");  //设置框架标题
			frame.setLocation(50,50);
			frame.setVisible(true);  //使其可见性
		});
	}
}

