import java.util.*;

public class TestBase7{
	public static void main(String[] args) {
		Set<String> words=new HashSet<>();
		long totalTime=0;

		try (Scanner in=new Scanner(System.in)){
			while (in.hasNext()){
				String word=in.next();
				long callTime=System.currentTimeMillis();
				words.add(word);
				callTime=System.currentTimeMillis()-callTime;
				totalTime+=callTime;
			}
		}
		Iterator<String> iter=words.iterator();
		for (int i=1;i<=20 && iter.hasNext(); i++) {
			if (i%5==0) {
				System.out.println();
			}
			System.out.print(iter.next()+"\t");
		}
		System.out.println("...");
		System.out.println(words.size()+" distinct words. "+totalTime+" milliseconds");
	}
}

//java TestBase7 < a.txt
/*
$ java TestBase7 < a.txt
big     explosive       data    advanced
high-speed      serve   issues  sequencing      that
appeared        problem reality,        huge    those
which   development     computing(HPC)along     in      need
impact  ...
77 distinct words. 0 milliseconds
*/
