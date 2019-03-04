package thinkinginJava.Strategy;

public class StrategyB implements Strategy{
	private double point;
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	@Override
	public double getAfterPrice(double initPrice) {
		return initPrice*point;
	}
 
}
