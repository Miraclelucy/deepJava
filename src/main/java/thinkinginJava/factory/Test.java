package thinkinginJava.factory;

public class Test {
	public static void main(String[] args) {
		VehicleFactory vf=new CarFactory();
		Movable m =vf.create();
		m.run();
		System.out.println("-------------bibibibi--------------");
		VehicleFactory vf2=new PlaneFactory();
		Movable m2 =vf2.create();
		m2.run();
		
	}
}
