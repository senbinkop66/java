public class TestDeadLock{
	public static void main(String[] args) {
		final StringBuffer s1=new StringBuffer();
		final StringBuffer s2=new StringBuffer();
		new Thread(){
			public void run(){
				synchronized (s1){
					s1.append("A");
					synchronized (s2){
						s2.append("B");
						//System.out.println(s1);
						System.out.println(s2);
						System.out.println(s1);

					}
				}
			}
		}.start();
	}
}