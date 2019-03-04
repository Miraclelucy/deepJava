package thinkinginJava.springStaticProxy;

public class Tank3 implements Movable{
		Tank t;
		public Tank3(Tank t){
			//super();
			this.t=t;
		}
	
	
	@Override
	public void move() {
		long startTime=System.currentTimeMillis();
		System.out.println(startTime);
		t.move();
		long endTime=System.currentTimeMillis();
		System.out.println(endTime);
	}

	@Override
	public void stop() {

	}


}

