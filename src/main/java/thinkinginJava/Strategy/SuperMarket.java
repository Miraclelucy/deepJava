package thinkinginJava.Strategy;

public class SuperMarket {
	private ProductA a;
	public double getPriceA(Strategy b,ProductA a){
		return b.getAfterPrice(a.getPrice());
	}
	public static void main(String[] args) {
		SuperMarket s=new SuperMarket();
		ProductA a =new ProductA();
		a.setPrice(100);
		StrategyB 	b= new StrategyB();
		b.setPoint(0.8);
		s.getPriceA(b, a);
		System.out.println("a商品-----折扣促销价------------"+s.getPriceA(b, a));
	}
}
