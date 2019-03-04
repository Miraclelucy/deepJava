package basicDemo;

public enum WeekDay{
	SUM(0),MON(1),TUE(),WES,THI,FRI,SAT;
	private WeekDay(){
		System.out.println("1");
	}
	private WeekDay(int day){
		System.out.println("2");
	}
} 	 	