import java.util.*;
import java.time.*;

public class TestBase8{
	public static void main(String[] args) {
		int n=2000000;
		long start=System.currentTimeMillis();
		BitSet b=new BitSet(n+1); //创建一个位集。
		int count=0;
		int i;
		for (i=2;i<=n;i++){
			b.set(i);  //设置一个位。
		}

		i=2;
		while (i*i<=n){
			if (b.get(i)) {  //获得一个位。
				count++;
				int k=2*i;
				while (k<=n){
					b.clear(k);  //清除一个位。
					k+=i;
				}
			}
			i++;
		}
		while (i<=n){
			if (b.get(i)) {
				count++;
			}
			i++;
		}
		long end=System.currentTimeMillis();
		System.out.println(count+" primes");
		System.out.println((end-start)+" milliseconds");
	}
}
/*
------Output------
148933 primes
27 milliseconds
*/


