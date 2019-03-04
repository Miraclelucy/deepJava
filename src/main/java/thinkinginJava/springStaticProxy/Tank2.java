package thinkinginJava.springStaticProxy;

import java.util.Random;

public class Tank2  extends Tank{
	@Override
	public void move() {
		long startTime=System.currentTimeMillis();
		System.out.println(startTime);
		super.move();
		long endTime=System.currentTimeMillis();
		System.out.println(endTime);
	}
}
