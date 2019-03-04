package thinkinginJava.springStaticProxy;

public class Test{
	public static void main(String[] args) {
		Tank t=new Tank();
		Movable m=new Tank3(t);
		m.move();
	}
}