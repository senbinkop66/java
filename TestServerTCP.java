import java.net.*;
import java.io.*;

public class TestServerTCP{
	public static void main(String[] args) {
		try{
			//准备一个ServerSocket
			ServerSocket server=new ServerSocket(5555);
			Socket s=server.accept();  //监听一个客户端的链接
			//该方法是阻塞的，如果没有客户端连接，则一直等待
			System.out.println("一个客户端连接成功！！！");

			OutputStream out=s.getOutputStream();  //获取输出流，用来发送数据给客户端
			InputStream in=s.getInputStream();  //获取输入流，用来接收该客户端发送给服务器的数据

			//接收数据
			byte[] buf=new byte[1024];
			int num=in.read(buf);
			String str=new String(buf,0,num);
			System.out.println(s.getInetAddress().toString()+":"+str);

			//发送数据
			out.write("欢迎访问".getBytes());
			out.flush();

			s.close();  //关闭socket

			server.close();  //关闭server
			
		}catch (Exception e) {
			System.out.println("错误信息:"+e.getMessage());
		}

	}
}