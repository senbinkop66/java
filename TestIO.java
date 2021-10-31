import java.io.*;


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
		*/
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


	}
}