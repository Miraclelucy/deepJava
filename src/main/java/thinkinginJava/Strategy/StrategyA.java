package thinkinginJava.Strategy;

public class StrategyA implements Strategy{

	@Override
	public double getAfterPrice(double initPrice) {
		if(initPrice>500){
			initPrice=initPrice-100;//满500减100
		}
		return initPrice;
	}
 
}
