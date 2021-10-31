
/**
 * @author senbin
 * @version 0.1
 * @see Math.java
 * 
 */
//自定义枚举类
class Season{
	private final String SEASONNAME;
	private final String SEASONDESC;
	private Season(String seasonName,String seasonDesc){
		this.SEASONNAME=seasonName;
		this.SEASONDESC=seasonDesc;
	}
	public static final Season SPRING=new Season("春天","春暖花开");
	public static final Season SUMMER=new Season("夏天","夏日炎炎");
	public static final Season AUTUMN=new Season("秋天","秋高气爽");
	public static final Season WINTER=new Season("冬天","白雪皑皑");

}

//使用enum定义枚举类
public enum SeasonEnum{
	SPRING("春天","春风又绿江南岸"),
	SUMMER("夏天","映日荷花别样红"),
	AUTUMN("秋天","秋水共长天一色"),
	WINTER("冬天","窗含西岭千秋雪");

	private final String seasonName;
	private final String seasonDesc;

	private SeasonEnum(String seasonName,String seasonDesc){
		this.seasonName=seasonName;
		this.seasonDesc=seasonDesc;
	}
	public String getSeasonName(){
		return seasonName;
	}
	public String getSeasonDesc(){
		return seasonDesc;
	}
}
public class TestEnumtype{
	/**
	 * @param args String[] 命令行参数
	 */
	public static void main(String[] args) {


		@SuppressWarnings("unused")
		int a=66;
	}
	@Deprecated
	public void print(){
		System.out.println("过时的方法");
	}
	@Override
	public String toString(){
		return "重写的toString()方法";
	}
}