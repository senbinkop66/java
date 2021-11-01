import java.net.*;

public class TestNetProgram{
	public static void main(String[] args) {
		
		try{
			
			
			InetAddress address_2=InetAddress.getLocalHost();
			System.out.println("本机IP:"+address_2);
		}catch (Exception e) {
			System.out.println("错误信息:"+e.getMessage());
		}
		


	}
}