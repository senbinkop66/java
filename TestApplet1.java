import java.awt.*;
import javax.swing.*;

class SimpleFrame extends JFrame{
	private static final int DEFAULT_WIDTH=300;
	private static final int DEFAULT_HEIGHT=200;

	public SimpleFrame(){
		//构造器将框架大小设置为 300 x 200 像素。
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

}

class SizedFrame extends JFrame{
	public SizedFrame(){
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension ScreenSize=kit.getScreenSize();  //以 Dimension 对象的形式返回屏幕的大小
		int screenWidth=ScreenSize.width;
		int screenHeight=ScreenSize.height;
		setSize(screenWidth/2,screenHeight/2);
		setLocationByPlatform(true);
		Image img=new ImageIcon("./image/img2.jpg").getImage();
		setIconImage(img);
	}
}

public class TestApplet1{
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			SizedFrame frame=new SizedFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("自适应框架尺寸");  //设置框架标题
			frame.setVisible(true);  //使其可见性
		});
	}
}


