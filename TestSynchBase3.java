
import java.io.*;
import java.util.*;
import java.util.concurrent.*;

//寻找包含指定关键字的文件的例子相似,仅仅计算匹配的文件数目。
class MatchCounter implements Callable<Integer>{
	private File directory;
	private String keyword;

	public MatchCounter(File d,String k){
		this.directory=d;
		this.keyword=k;
	}

	public Integer call(){
		int count=0;
		try{
			File[] files=directory.listFiles();
			List<Future<Integer>> results=new ArrayList<>();

			for (File file:files){
				if (file.isDirectory()) {
					//在 call 方法内部， 使用相同的递归机制。 对于每一个子目录， 我们产生一个新的MatchCounter 并为它启动一个线程。 
					MatchCounter counter=new MatchCounter(file,keyword);
					FutureTask<Integer> task=new FutureTask<>(counter);
					results.add(task);
					Thread t=new Thread(task);
					t.start();
				}else{
					if (search(file)) count++;
				}
			}
			for (Future<Integer> result:results){
				try{
					count+=result.get();
				}catch(ExecutionException e){
					e.printStackTrace();
				}
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		return count;
	}
	public boolean search(File file){
		try (Scanner in=new Scanner(file,"UTF-8")){
			boolean found=false;
			while (!found &&in.hasNextLine()){
				String line=in.nextLine();
				if (line.contains(keyword)) {
					found=true;
				}
			}
			return found;
		}catch(IOException e){
			return false;
		}
	}
}

public class TestSynchBase3{
	public static void main(String[] args) {
		String directory="../javahighrank";
		String keyword="public";

		MatchCounter counter=new MatchCounter(new File(directory),keyword);
		FutureTask<Integer> task=new FutureTask<>(counter);
		Thread t=new Thread(task);
		t.start();
		try{
			System.out.println(task.get()+" matching files");
		}catch(ExecutionException e){
			e.printStackTrace();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
	}

}

