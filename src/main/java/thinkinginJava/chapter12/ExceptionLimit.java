package thinkinginJava.chapter12;

public class ExceptionLimit {
	class BaseballException  extends Exception{}
	class Foul extends BaseballException {}
	class Strike extends BaseballException {}
	abstract class Inning{
		public Inning() throws BaseballException{}
		public void event() throws BaseballException{}
		public void walk(){}
		public abstract void atBat() throws Strike,Foul ;
	}
	class StromException extends Exception{}
	class RainedOut extends StromException {}
	class PopFoul extends Foul{}
	interface Storm {
		public void event() throws RainedOut ;
		public void rainHard() throws RainedOut;
	}
	//强制派生类遵守基类方法的异常说明
	public class StormyInning extends Inning implements Storm {
		public StormyInning() throws RainedOut,BaseballException{}
		public StormyInning(String  s) throws BaseballException,StromException{}
		//重写方法不能抛出新的异常或者比被重写方法声明的检查异常更广的检查异常。但是可以抛出更少，更有限或者不抛出异常。
		//public void event() throws RainedOut{} ----compile error!!
		public void event() {}  //编译正常，父类方法中抛出异常的，子类中
		//public void walk() throws RainedOut{} ----compile error!!
		public void walk(){}
		public void atBat() throws  PopFoul {}//重写的方法可以抛出子异常
		public void rainHard() throws RainedOut{}
		/**/
	}
	
	public static void main(String[] args) {	
		try {
			ExceptionLimit ex=new ExceptionLimit();
			StormyInning st =ex.new StormyInning();
			st.atBat();
			st.rainHard();
		} catch (BaseballException e) {
			e.printStackTrace();
		} catch (RainedOut e) {
			e.printStackTrace();
		}
		
		try {
			ExceptionLimit ex=new ExceptionLimit();
			Inning st= ex.new StormyInning();
			st.atBat();
		} catch (BaseballException e) {
			e.printStackTrace();
		}
		catch (RainedOut e) {
			e.printStackTrace();
		}
		
	}
	
}
