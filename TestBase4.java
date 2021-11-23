import java.util.*;

class FileFormatException extends IOException{
	public FileFormatException(){}
	public FileFormatException(String gripe){
		super(gripe);
	}
}

public class TestBase4{
	public String readData(BufferedReaderin) throws FileFormatException{

	}
	public void read(String filename){
		try{
			InputStream in=new FileInputStream(filename);
			int b;
			while ((b=in.read()!=-1)) {
				System.out.println("process input");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		
	}
}
