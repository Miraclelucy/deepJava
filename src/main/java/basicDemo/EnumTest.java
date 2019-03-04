package basicDemo;

public class EnumTest {
	public static void main(String[] args) {
		WeekDay w=WeekDay.WES;
		//System.out.println(w);
		//System.out.println(w.ordinal());
		//System.out.println(WeekDay.valueOf("WES"));
		//System.out.println(WeekDay.values().length);
		
		TrafficLamp t=TrafficLamp.GREEN;
		System.out.println(t.nextLamp());
	}
	
	
}
