import java.net.*;

public class TestNetProgram{
	public static void main(String[] args) {
		
		try{
			InetAddress address_1=InetAddress.getByName("www.baidu.com");
			System.out.println(address_1);
			System.out.println("域名："+address_1.getHostName());
			System.out.println("IP:"+address_1.getHostAddress());
			
			InetAddress address_2=InetAddress.getLocalHost();
			System.out.println("本机IP:"+address_2);
		}catch (Exception e) {
			System.out.println("错误信息:"+e.getMessage());
		}
		


	}
}