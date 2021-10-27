
class MyThread extends Thread{
	public MyThread(){
		super();
	}
	public void run(){
		for (int i=0; i<100;i++) {
			System.out.println("子线程："+i);
		}
	}
}

public class TestThread{
	public static void main(String[] args){
		//创建线程
		MyThread mt=new MyThread();
		//启动线程
		mt.start();
		




	}
}