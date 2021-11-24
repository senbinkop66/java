import java.util.*;
import java.io.*;
import java.time.*;

class Pair<T>{
	private T first;
	private T second;

	public Pair(){
		first=null;
		second=null;
	}
	public Pair(T first,T second){
		this.first=first;
		this.second=second;
	}
	public T getFirst(){
		return first;
	}
	public T getSecond(){
		return second;
	}
	public void setFirst(T newValue){
		first=newValue;
	}
	public void setSecond(T newValue){
		second=newValue;
	}
}

class ArrayAlg{
	public static <T extends Comparable> Pair<T> minmax(T[] a){
		if (a==null || a.length==0) return null;
		T min=a[0];
		T max=a[0];
		for (int i=1; i<a.length; i++) {
			if (min.compareTo(a[i])>0) min=a[i];
			if (max.compareTo(a[i])<0) max=a[i];
		}
		return new Pair<>(min,max);
	}
	public static <T> T getMiddle(T... a){
		return a[a.length/2];
	}
	public static <T extends Comparable> T min(T[] a){
		if (a==null || a.length==0) return null;
		T smallest=a[0];
		for (int i=1; i<a.length; i++) {
			if (smallest.compareTo(a[i])>0) smallest=a[i];
		}
		return smallest;
	}
}

public class TestBase4{
	public static void main(String[] args){
		String[] names={"mane","Alison","Arnold","salah"};
		Pair<String> mm=ArrayAlg.minmax(names);
		System.out.println("min="+mm.getFirst());
		System.out.println("max="+mm.getSecond());
		String middle=ArrayAlg.<String>getMiddle(names);
		System.out.println(middle);
		
		String min1=ArrayAlg.<String>min(names);
		System.out.println(min1);  //Alison

		LocalDate[] dates={
			LocalDate.of(1996,11,11),
			LocalDate.of(1889,7,23),
			LocalDate.of(1919,2,1),
			LocalDate.of(2021,11,24),
		};
		Pair<LocalDate> mm2=ArrayAlg.minmax(dates);
		System.out.println("min="+mm2.getFirst());  //min=1889-07-23
		System.out.println("max="+mm2.getSecond());  //max=2021-11-24

	}
}
