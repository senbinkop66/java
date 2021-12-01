import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;


class MatchCounter extends RecursiveTask<Integer>{
	public static final int THRESHOLD=1000;
	private double[] values;
	private int from;
	private int to;
	private DoublePredicate filter;

	public MatchCounter(double[] v,int f,int t,DoublePredicate ft){
		this.values=v;
		this.from=f;
		this.to=t;
		this.filter=ft;
	}

	protected Integer compute(){
		if (to-from<THRESHOLD){
			int count=0;
			for (int i=from;i<to;i++){
				if (filter.test(values[i])) count++;
			}
			return count;
		}else{
			int mid=(from+to)/2;
			MatchCounter first=new MatchCounter(values,from,mid,filter);
			MatchCounter second=new MatchCounter(values,mid,to,filter);
			//invokeAll 方法接收到很多任务并阻塞， 直到所有这些任务都已经完成。
			invokeAll(first,second);
			//join 方法将生成结果。我们对每个子任务应用了 join, 并返回其总和。
			return first.join()+second.join();
		}
	}

	
}

public class TestSynchBase4{
	public static void main(String[] args){
		final int SIZE=10000000;

		double[] numbers=new double[SIZE];
		for (int i=0;i<SIZE;i++){
			numbers[i]=Math.random();
		}

		MatchCounter counter=new MatchCounter(numbers,0,numbers.length,x->x>0.5);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(counter);  //

		System.out.println(counter.join());
		
	}
}

