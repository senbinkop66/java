import java.net.*;
import java.io.*;

public class TestCustomeUDP{
	public static void main(String[] args) {
		//发送端
		DatagramSocket ds=null;
		try{
			ds=new DatagramSocket();
			String msg="UDP test 客户端";
			byte[] by=msg.getBytes();

			DatagramPacket dp=new DatagramPacket(by,0,by.length,InetAddress.getByName("127.0.0.1"),8888);
			ds.send(dp);

		}catch (Exception e) {
			System.out.println("错误信息:"+e.getMessage());
		}finally{
			if (ds!=null) {
				ds.close();
			}
		}
		

	}
}