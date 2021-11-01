import java.io.*;

class Person{
	private String name;
	private int age;
	private String address;
	public Person(String n,int a,String ad){
		this.name=n;
		this.age=a;
		this.address=ad;
	}
}

public class TestIO{
	
	public static void main(String[] args) {
		//System.out.println(File.separator);  //  \
		//File file1=new File("./info.txt");
		/*
		File dir1=new File("dir1");
		if (!dir1.exists()) {
			dir1.mkdir();
		}
		File dir2=new File(dir1,"dir2");
		if (!dir2.exists()) {
			dir2.mkdirs();
		}
		File dir4=new File(dir1,"dir3/dir4");
		if (!dir4.exists()) {
			dir4.mkdirs();
		}
		try{
			File file2=new File(dir2,"test.txt");
			file2.createNewFile();
		}catch (IOException e) {
			e.printStackTrace();
		}
		*/
		/*
		FileReader fr=null;
		try{
			fr=new FileReader(new File("test.txt"));
			char[] buf=new char[1024];
			int len;
			while ((len=fr.read(buf))!=-1){
				System.out.println(new String(buf,0,len));
			}
		}catch (IOException e) {
			System.out.println("read-Exception:"+e.getMessage());
		}finally{
			if (fr!=null) {
				try{
					fr.close();
				}catch (IOException e) {
					System.out.println("read-Exception:"+e.getMessage());
				}
			}
		}
		
		FileWriter fw=null;
		try{
			fw=new FileWriter(new File("test2.txt"));
			fw.write("abcdefghigklmnopqrstuvwxyz");
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (fw!=null) {
				try{
					fw.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	
	*/
		/*
		//缓冲流
		BufferedReader br=null;
		BufferedWriter bw=null;
		try{
			//创建缓冲流对象：它是处理流，是对节点流的包装
			br=new BufferedReader(new FileReader("test.txt"));
			bw=new BufferedWriter(new FileWriter("a.txt"));
			String str="";
			while((str=br.readLine())!=null){
				//一次读取字符文本文件的一行字符
				bw.write(str);  //一次写入一行字符串
				bw.newLine();  //写入行分隔符
			}
			bw.flush();  //刷新缓冲区
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			//关闭IO流对象
			try{
				if (bw!=null) {
					//// 关闭过滤流时,会自动关闭它所包装的底层节点流
					bw.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
			try{
				if (br!=null) {
					br.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		*/
		/*
		//转换流
		try{
			FileInputStream fis=new FileInputStream("test.txt");
			FileOutputStream fos=new FileOutputStream("a.txt");

			InputStreamReader isr=new InputStreamReader(fis,"GBK");
			OutputStreamWriter osw=new OutputStreamWriter(fos,"GBK");

			BufferedReader br=new BufferedReader(isr);
			BufferedWriter bw=new BufferedWriter(osw);

			String str=null;
			while((str=br.readLine())!=null){
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
			bw.close();
			br.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		*/
		/*
		//标准输入、输出流
		System.out.println("请输入信息（退出输入e或exit）：");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=null;
		try{
			while((s=br.readLine())!=null){
				if ("e".equalsIgnoreCase(s) || "exit".equalsIgnoreCase(s)) {
					System.out.println("安全退出！！");
					break;
				}
				System.out.println("-->"+s.toUpperCase());
				System.out.println("继续输入信息:");
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if (br!=null) {
					br.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		*/
		/*
		//打印流
		PrintStream ps=null;
		try{
			FileOutputStream fos=new FileOutputStream("a.txt");
			ps=new PrintStream(fos,true);
			if (ps!=null) {
				System.setOut(ps);
			}
			for (int i=0; i<=255; i++) {
				System.out.print((char) i);
				if (i%50==0) {
					System.out.println();
				}
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}finally{
			if (ps!=null) {
				ps.close();
			}
		}
		*/
		/*
		//数据流
		DataOutputStream dos=null;
		try{
			dos=new DataOutputStream(new FileOutputStream("b.txt"));
			dos.writeUTF("写入UTF字符串");
			dos.writeBoolean(false);
			dos.writeLong(1234567890L);
			System.out.println("写入文件成功");
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if (dos!=null) {
						dos.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}

		DataInputStream dis=null;
		try{
			dis=new DataInputStream(new FileInputStream("b.txt"));
			String info=dis.readUTF();
			boolean flag=dis.readBoolean();
			long time=dis.readLong();
			System.out.println(info);
			System.out.println(flag);
			System.out.println(time);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (dis!=null) {
				try{
					dis.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		*/
		/*
		//序列化
		try{
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("c.txt"));
			Person p=new Person("mane",28,"liver");
			oos.writeObject(p);
			oos.flush();
			oos.close();
		}catch(IOException e){
				e.printStackTrace();
		}
		try{
			//反序列化
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("c.txt"));
			Person p1=(Person)ois.readObject();
			System.out.println(p1.toString());
			ois.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		*/

		//随机存取文件流
		try{
			RandomAccessFile raf=new RandomAccessFile("test.txt","rw");
			raf.seek(5);
			byte []b=new byte[1024];

			int off=0;
			int len=5;
			raf.read(b,off,len);

			String str=new String(b,0,len);
			System.out.println(str);
			raf.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		try{
			RandomAccessFile raf=new RandomAccessFile("test.txt","rw");
			raf.seek(10);
			String temp=raf.readLine();
			raf.seek(5);
			raf.write("xyz".getBytes());
			raf.write(temp.getBytes());
			raf.close();
		}catch (IOException e) {
			e.printStackTrace();
		}



	}
}