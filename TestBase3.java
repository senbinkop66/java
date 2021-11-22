import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

class ArrayAlg{
	public static class Pair{
		private double first;
		private double second;

		public Pair(double f,double s){
			first=f;
			second=s;
		}

		public double getFirst(){
			return first;
		}
		public double getSecond(){
			return second;
		}
	}
	public static Pair minmax(double[] values){
		double min=Double.POSITIVE_INFINITY;
		double max=Double.NEGATIVE_INFINITY;
		for (double v:values) {
			if (min>v) {
				min=v;
			}
			if (max<v) {
				max=v;
			}
		}
		return new Pair(min,max);

	}
}

public class TestBase3{
	public static void main(String[] args){
		double[] d=new double[5];
		for (int i=0; i<d.length; i++) {
			d[i]=100*Math.random();
		}

		System.out.println(Arrays.toString(d));
		//[7.803257533515728, 97.0222694732156, 18.359083423368983, 62.2407079145171, 36.27014599745496]最小值：7.803257533515728
		ArrayAlg.Pair p=ArrayAlg.minmax(d);
		System.out.println("最小值："+p.getFirst());  //最小值：7.803257533515728
		System.out.println("最大值："+p.getSecond());  //最大值：97.0222694732156

	}
}