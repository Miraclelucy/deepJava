package thinkinginJava.springStaticProxy;

import java.util.Random;

public class Tank implements Movable {

	@Override
	public void move() {
		System.out.println("一辆坦克正在移动。。。。");
		try {
			Thread.sleep(new Random().nextInt(10000));//睡眠一段时间 10s以内的随机数
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void stop() {

	}

}
