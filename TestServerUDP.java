import java.net.*;
import java.io.*;

public class TestServerUDP{
	public static void main(String[] args) {
		//接收端
		DatagramSocket ds=null;
		try{
			ds=new DatagramSocket(8888);

			byte[] by=new byte[1024];
			DatagramPacket dp=new DatagramPacket(by,by.length);
			ds.receive(dp);

			String str=new String(dp.getData(),0,dp.getLength());
			System.out.println(str+"--"+dp.getAddress());

		}catch (Exception e) {
			System.out.println("错误信息:"+e.getMessage());
		}finally{
			if (ds!=null) {
				ds.close();
			}
		}

	}
}