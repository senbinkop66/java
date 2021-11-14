import java.io.*;

class MyException extends Exception{
	static final long serialVersionUID=12349494909L;
	private int idnumber;

	public MyException(String message,int id){
		super(message);
		this.idnumber=id;
	}
	public int getId(){
		return idnumber;
	}
}

public class TestException{
	//int x;
	public void regist(int num) throws MyException{
		if (num<0){
			throw new MyException("人数不能为负值",3);
		}else{
			System.out.println("登记人数"+num);
		}
	}
	public void manager(){
		try{
			regist(-100);
		}catch (MyException e) {
			System.out.println("登记失败，出错种类"+e.getId());
		}
		System.out.println("本次登记操作结束");
	}

	public static void main(String[] args){
		TestException t=new TestException();
		t.manager();

		/*
		//java.lang.ArrayIndexOutOfBoundsException:
		String frirnds[]={"mane","salah","Alison"};
		try {
			for (int i=0; i<5; i++) {
				System.out.println(frirnds[i]);
			}
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		
		int y;
		TestException c=new TestException();
		try {
			y=3 / c.x;
		}catch (ArithmeticException e){
			System.out.println(e.getMessage());
		}finally{
			System.out.println("finally");
		}
		*/
		/*
		try{
			FileInputStream in=new FileInputStream("testexception.txt");
			int b;
			b=in.read();
			while (b!=-1){
				System.out.println((char) b);
				b=in.read();
			}
			in.close();
		}catch (IOException e) {
			System.out.println(e);
		}finally{
			System.out.println("It's ok!");
		}
		*/
		/*
		TestException t=new TestException();
		try{
			t.readFile();
		}catch (IOException e) {
			e.printStackTrace();
		}
		*/


	}
	/*
	public void readFile() throws IOException{
		FileInputStream in=new FileInputStream("testexception.txt");
		int b;
		b=in.read();
		while (b!=-1){
			System.out.println((char) b);
			b=in.read();
		}
		in.close();
	}
	*/
}