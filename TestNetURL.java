import java.net.*;

public class TestNetURL{
	public static void main(String[] args) {
		
		try{
			URL url=new URL("http://guolab.uestc.edu.cn:80/EcoliGD/index.php?gene");

			System.out.println("协议名:"+url.getProtocol());
			System.out.println("主机名:"+url.getHost());
			System.out.println("端口号:"+url.getPort());
			System.out.println("文件路径:"+url.getPath());
			System.out.println("文件名:"+url.getFile());
			System.out.println("查询名:"+url.getQuery());
		}catch (Exception e) {
			System.out.println("错误信息:"+e.getMessage());
		}
		


	}
}