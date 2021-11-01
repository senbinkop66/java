import java.net.*;
import java.io.*;

public class TestCustomeTCP{
	public static void main(String[] args) {
		try{
			//准备socket,连接服务器
			Socket s=new Socket("10.130.120.104",5555);

			//获取输出流，用来发送数据给服务器
			OutputStream out=s.getOutputStream();
			//获取输入流，用来接收该客户端发送给服务器的数据
			InputStream in=s.getInputStream();

			//发送数据
			String msg="tcp test";
			out.write(msg.getBytes());
			out.flush();
			s.shutdownOutput();

			//接收数据
			byte[] data=new byte[1024];
			int len;
			while ((len=in.read(data))!=-1){
				System.out.println(new String(data,0,len));
			}

			s.close();
		}catch (Exception e) {
			System.out.println("错误信息:"+e.getMessage());
		}
		

	}
}