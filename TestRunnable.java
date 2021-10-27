
class Ticket implements Runnable{
	private int tick=100;
	public void run(){
		while (true){
			if (tick>0) {
				System.out.println(Thread.currentThread().getName()+"售出车票，tick号为："+tick--);
			}else{
				break;
			}
		}
	}
}

public class TestRunnable{
	public static void main(String[] args){
		Ticket t=new Ticket();

		Thread t1=new Thread(t);
		Thread t2=new Thread(t);
		Thread t3=new Thread(t);
		t1.setName("t1窗口");
		t2.setName("t2窗口");
		t3.setName("t3窗口");
		t1.start();
		t2.start();
		t3.start();

		




	}
}