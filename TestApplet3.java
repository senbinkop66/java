import java.util.*;
import java.awt.*;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.*;
import javax.swing.JComboBox;

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

class CheckBoxFrame extends JFrame{
	private JLabel label;
	private JCheckBox bold;
	private JCheckBox italic;
	private static final int FONTSIZE=24;

	public CheckBoxFrame(){
		label=new JLabel("You will never walk alone!");
		label.setFont(new Font("Serif",Font.BOLD,FONTSIZE));
		add(label,BorderLayout.CENTER);

		ActionListener listener=event->{
			int mode=0;
			if (bold.isSelected()) mode+=Font.BOLD;
			if (italic.isSelected()) mode+=Font.ITALIC;
			label.setFont(new Font("Serif",mode,FONTSIZE));
		};

		JPanel buttonPanel=new JPanel();

		bold=new JCheckBox("Bold");
		bold.addActionListener(listener);
		bold.setSelected(true);
		buttonPanel.add(bold);
		italic=new JCheckBox("Italic");
		italic.addActionListener(listener);
		buttonPanel.add(italic);

		add(buttonPanel,BorderLayout.SOUTH);
		pack();
	}
}

class RadioButtonFrame extends JFrame{
	private JLabel label;
	private JPanel buttonPanel;
	private ButtonGroup group;
	private JCheckBox italic;
	private static final int FONTSIZE=24;

	public RadioButtonFrame(){
		label=new JLabel("You will never walk alone!");
		label.setFont(new Font("Serif",Font.PLAIN,FONTSIZE));
		add(label,BorderLayout.CENTER);

		buttonPanel=new JPanel();
		group=new ButtonGroup();

		addRadioButton("Small",8);
		addRadioButton("Medium",12);
		addRadioButton("Large",18);
		addRadioButton("Extra large",36);

		add(buttonPanel,BorderLayout.SOUTH);
		pack();

		
	}
	public void addRadioButton(String name,int size){
		boolean isSelected=size==FONTSIZE;
		JRadioButton button=new JRadioButton(name,isSelected);  //用给定的标签和初始状态构造一个单选钮。
		group.add(button);  //将按钮添加到组中。
		buttonPanel.add(button);

		ActionListener listener=event->label.setFont(new Font("Serif",Font.PLAIN,size));
		button.addActionListener(listener);
	}
}

class BorderFrame extends JFrame{
	private JPanel demoPanel;
	private JPanel buttonPanel;
	private ButtonGroup group;

	public BorderFrame(){
		demoPanel=new JPanel();
		buttonPanel=new JPanel();
		group=new ButtonGroup();
		//创建一个具有凹面或凸面效果的边框。
		addRadioButton("Lowered bevel",BorderFactory.createLoweredBevelBorder());
		addRadioButton("Raised bevel",BorderFactory.createRaisedBevelBorder());
		addRadioButton("Etched",BorderFactory.createEtchedBorder());
		//创建一个简单的直线边框。
		addRadioButton("Line",BorderFactory.createLineBorder(Color.BLUE));
		//创建一个用 color 颜色或一个重复 （repeating ) 图标填充的粗的边框。
		addRadioButton("Matte",BorderFactory.createMatteBorder(10,10,10,10,Color.RED));
		//创建一个空边框。
		addRadioButton("Empty",BorderFactory.createEmptyBorder());
		//创建一个具有 3D 效果的直线边框。
		Border etched=BorderFactory.createEtchedBorder(Color.GREEN,Color.BLUE);
		//创建一个具有给定特性的带标题的边框。
		Border titled=BorderFactory.createTitledBorder(etched,"Border types");
		buttonPanel.setBorder(titled);

		setLayout(new GridLayout(2,1));
		add(buttonPanel);
		add(demoPanel);
		pack();
	}
	public void addRadioButton(String name,Border b){
		JRadioButton button=new JRadioButton(name);  //用给定的标签和初始状态构造一个单选钮。
		//设置这个组件的边框。
		button.addActionListener(event->demoPanel.setBorder(b));
		group.add(button);  //将按钮添加到组中。
		buttonPanel.add(button);
	}
}

class ComboBoxFrame extends JFrame{
	private JLabel label;
	private JComboBox<String> faceCombo;
	private static final int DEFAULT_SIZE=24;

	public ComboBoxFrame(){
		label=new JLabel("You will never walk alone!");
		label.setFont(new Font("Serif",Font.PLAIN,DEFAULT_SIZE));
		add(label,BorderLayout.CENTER);

		faceCombo=new JComboBox<>();
		//把一个选项添加到选项列表中。
		faceCombo.addItem("Serif");
		faceCombo.addItem("SansSerif");
		faceCombo.addItem("Monospaced");
		faceCombo.addItem("Dialog");
		faceCombo.addItem("DialogInput");
		faceCombo.addItem("宋体");

		//返回当前选择的选项。
		faceCombo.addActionListener(event->{
			label.setFont(new Font(faceCombo.getItemAt(faceCombo.getSelectedIndex()),Font.PLAIN,DEFAULT_SIZE));
		});

		JPanel comboPanel=new JPanel();
		comboPanel.add(faceCombo);
		add(comboPanel,BorderLayout.SOUTH);
		pack();
	}
}

class SliderFrame extends JFrame{
	private JPanel slidePanel;
	private JTextField textField;
	private ChangeListener listener;

	public SliderFrame(){
		slidePanel=new JPanel();
		slidePanel.setLayout(new GridLayout(10,1));

		listener=event->{
			JSlider source=(JSlider) event.getSource();
			textField.setText(""+source.getValue());
		};

		JSlider slider=new JSlider();
		addSlider(slider,"Plain");

		//用给定的方向、最大值、 最小值和初始化值构造一个水平滑动条。
		slider=new JSlider();
		//显示标尺
		slider.setPaintTicks(true);
		//用给定的滑动条单位的倍数设置大标尺和小标尺。
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider,"Ticks");

		slider=new JSlider();
		slider.setPaintTicks(true);
		//每一次调整后滑块都要对齐到最接近的标尺处
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider,"Snap to ticks");

		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		//如果 b 是 tme， 显示滑动条滑动的轨迹。
		slider.setPaintTrack(false);
		addSlider(slider,"No track");

		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setInverted(true);
		addSlider(slider,"Inverted");

		slider=new JSlider();
		slider.setPaintTicks(true);
		//显示标尺标签。
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider,"Labels");

		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		
		Dictionary<Integer,Component> labelTable=new Hashtable<>();
		labelTable.put(0,new JLabel("A"));
		labelTable.put(20,new JLabel("B"));
		labelTable.put(40,new JLabel("C"));
		labelTable.put(60,new JLabel("D"));
		labelTable.put(80,new JLabel("E"));
		labelTable.put(100,new JLabel("F"));
		//设置用于作为标尺标签的组件。 
		slider.setLabelTable(labelTable);
		addSlider(slider,"Custom labels");

		textField=new JTextField();
		add(slidePanel,BorderLayout.CENTER);
		add(textField,BorderLayout.SOUTH);
		pack();
	}
	public void addSlider(JSlider s,String description){
		s.addChangeListener(listener);
		JPanel panel=new JPanel();
		panel.add(s);
		panel.add(new JLabel(description));
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy=slidePanel.getComponentCount();
		gbc.anchor=GridBagConstraints.WEST;
		slidePanel.add(panel,gbc);
	}
}

public class TestApplet3{
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame=new SliderFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("组合框");  //设置框架标题
			frame.setLocation(300,300);
			frame.setVisible(true);  //使其可见性
		});
	}
}
