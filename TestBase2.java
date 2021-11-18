import java.util.*;

//使用enum定义枚举类
enum SeasonEnum{
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

public class TestBase2{

	public static void main(String[] args){
		System.out.println(SeasonEnum.SPRING.toString());  //SPRING
		SeasonEnum s=Enum.valueOf(SeasonEnum.class,"SUMMER");
		System.out.println(s);  //SUMMER

		SeasonEnum[] seasons=SeasonEnum.values();
		System.out.println(Arrays.toString(seasons));  //[SPRING, SUMMER, AUTUMN, WINTER]

		System.out.println(SeasonEnum.AUTUMN.ordinal());  //2
		
	}
}