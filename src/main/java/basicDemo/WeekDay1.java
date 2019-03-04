package basicDemo;
/* 用普通的类模拟枚举类*/
public class WeekDay1 {
	@Override
	public String toString() {
		return this==SUN?"SUN":"MON";
	}
	private WeekDay1(){}
	public static final WeekDay1 SUN= new WeekDay1();
	public static final WeekDay1 MON= new WeekDay1();
	public static final WeekDay1 TUE= new WeekDay1();
	public static final WeekDay1 WED= new WeekDay1();
	public static final WeekDay1 THU= new WeekDay1();
	public static final WeekDay1 FRI= new WeekDay1();
	public static final WeekDay1 SAT= new WeekDay1();
	
}
