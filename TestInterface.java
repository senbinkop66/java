
public interface Runner{
	int ID=1;  //public static final int ID=1;
	void start();  //public abstract void start();
	public void run();  //public abstract void run();
	void stop();  //public abstract void stop();
}
interface Swimmer{
	public void swim();
}

class Person implements Runner,Swimmer{
	public void start(){
		System.out.println("准备工作:：弯腰、蹬腿、咬牙、瞪眼");
		System.out.println("开跑");
	}
	public void run(){
		System.out.println("摆动手臂");
		System.out.println("维持直线方向");
	}
	public void stop(){
		System.out.println("减速直至停止、喝水。");
	}
	public void swim(){
		System.out.println("游泳");
	}

}



public class TestAbstract{
	
	public static void main(String[] args){

	}
}