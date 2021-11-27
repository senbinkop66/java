import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.font.*;

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

class TestTextFrame extends JFrame{
	public TestTextFrame(){
		add(new TestTextComponent());
		pack();  ////调整窗口大小，要考虑到其组件的首选大小。
	}
}
class TestTextComponent extends JComponent{
	public static final int MESSAGE_X=75;
	public static final int MESSAGE_Y=100;
	private static final int DEFAULT_WIDTH=300;
	private static final int DEFAULT_HEIGHT=200;
	//覆盖这个方法来描述应该如何绘制自己的组件。
	public void paintComponent(Graphics g){
		g.drawString("You will never walk alone!",MESSAGE_X,MESSAGE_Y);
	}
	//覆盖 getPreferredSize 方法， 返回一个有首选宽度和高度的 Dimension 类对象
	public Dimension getPreferredSize(){
		return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}

}

class DrawFrame extends JFrame{
	public DrawFrame(){
		DrawComponent p=new DrawComponent();
		p.setBackground(Color.GREEN);
		add(p);
		pack();
	}
	
}
class DrawComponent extends JComponent{
	private static final int DEFAULT_WIDTH=400;
	private static final int DEFAULT_HEIGHT=400;
	public void paintComponent(Graphics g){
		Graphics2D g2=(Graphics2D) g;
		double leftX=100;
		double topY=100;
		double width=200;
		double height=150;

		g2.setPaint(new Color(0,128,128));
		Rectangle2D rect=new Rectangle2D.Double(leftX,topY,width,height);
		g2.draw(rect);  //画一个矩形

		g2.setPaint(Color.RED);
		Ellipse2D ellipse=new Ellipse2D.Double();
		ellipse.setFrame(rect);
		//g2.draw(ellipse);  //画一个椭圆
		g2.fill(ellipse);  //填充

		g2.setPaint(SystemColor.desktop);
		g2.draw(new Line2D.Double(leftX,topY,leftX+width,topY+height));  //画一条线

		g2.setPaint(Color.CYAN);
		double centerX=rect.getCenterX();
		double centerY=rect.getCenterY();
		double radius=150;
		Ellipse2D circle=new Ellipse2D.Double();
		circle.setFrameFromCenter(centerX,centerY,centerX+radius,centerY+radius);
		g2.draw(circle);  //画一个圆
	}
	public Dimension getPreferredSize(){
		return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
}

class FontFrame extends JFrame{
	public FontFrame(){
		add(new FontComponent());
		pack();
	}
}
class FontComponent extends JComponent{
	private static final int DEFAULT_WIDTH=600;
	private static final int DEFAULT_HEIGHT=400;

	public void paintComponent(Graphics g){
		Graphics2D g2=(Graphics2D) g;
		String message="You will never walk alone!";

		Font f=new Font("Serif",Font.BOLD,36);
		g2.setFont(f);

		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D bounds=f.getStringBounds(message,context);

		double x=(getWidth()-bounds.getWidth())/2;
		double y=(getHeight()-bounds.getHeight())/2;

		double ascent=-bounds.getY();
		double baseY=y+ascent;
		g2.setPaint(Color.RED);
		g2.drawString(message,(int) x,(int) baseY);
		g2.setPaint(Color.LIGHT_GRAY);
		g2.draw(new Line2D.Double(x,baseY,x+bounds.getWidth(),baseY));

		Rectangle2D rect=new Rectangle2D.Double(x,y,bounds.getWidth(),bounds.getHeight());
		g2.draw(rect);
	}
	public Dimension getPreferredSize(){
		return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
}

class ImageFrame extends JFrame{
	public ImageFrame(){
		add(new ImageComponent());
		pack();
	}
}
class ImageComponent extends JComponent{
	private static final int DEFAULT_WIDTH=800;
	private static final int DEFAULT_HEIGHT=950;

	private Image image;

	public ImageComponent(){
		image=new ImageIcon("./image/img1.jpg").getImage();
	}
	public void paintComponent(Graphics g){
		if (image==null) return;
		int imageWidth=image.getWidth(this);
		int imageHeight=image.getHeight(this);
		System.out.println(imageWidth+" "+imageHeight);

		g.drawImage(image,40,20,null);  //绘制一幅非比例图像。注意： 这个调用可能会在图像还没有绘制完毕就返回。
		/*
		for (int i=0; i*imageWidth<=getWidth(); i++) {
			for (int j=0; j*imageHeight<=getHeight(); j++) {
				if (i+j>0){
					//拷贝屏幕的一块区域。
					g.copyArea(0, 0, imageWidth, imageHeight, i*imageWidth, j*imageHeight);
				}
			}
		}*/
	}
	public Dimension getPreferredSize(){
		return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
}

public class TestApplet1{
	public static void main(String[] args) {
		
		EventQueue.invokeLater(()->{
			JFrame frame=new ImageFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("显示图像");  //设置框架标题
			frame.setLocation(50,50);
			frame.setVisible(true);  //使其可见性
		});
		
	}
}

