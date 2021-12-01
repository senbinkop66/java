import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class TestSynchBase2{
	public static final int FILE_QUEUE_SIZE=10;
	public static final int SEARCH_THREADS=100;
	public static final File DUMMY=new File("");
	//构造一个带有指定的容量和公平性设置的阻塞队列。该队列用循环数组实现。
	public static BlockingQueue<File> queue=new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);
	//public static int totalNumber=0;
	public static void main(String[] args) {
		String directory="../javahighrank";
		String keyword="mane";

		Runnable enumerator=()->{
			try{
				enumerate(new File(directory));
				//添加元素， 在必要时阻塞
				queue.put(DUMMY);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		};
		new Thread(enumerator).start();
		for (int i=1; i<=SEARCH_THREADS; i++) {
			Runnable searcher=()->{
				try{
					boolean done=false;
					while (!done){
						File file=queue.take();
						if (file==DUMMY) {
							queue.put(file);
							done=true;
						}else{
							search(file,keyword);
						}
					}
				}catch(IOException e){
					e.printStackTrace();
				}catch (InterruptedException e){
					e.printStackTrace();
				}
			};
			new Thread(searcher).start();
		}
	}
	public static void enumerate(File directory) throws InterruptedException{
		File[] files=directory.listFiles();
		for (File file:files){
			if (file.isDirectory()) {
				enumerate(file);
			}else{
				queue.put(file);
			}
		}
	}
	public static void search(File file,String keyword) throws IOException{
		try (Scanner in=new Scanner(file,"UTF-8")){
			int lineNumber=0;
			while (in.hasNextLine()){
				lineNumber++;
				String line=in.nextLine();
				if (line.contains(keyword)) {
					System.out.printf("%s:%d:%s%n", file.getPath(),lineNumber,line);
				}
			}
		}
	}
}

