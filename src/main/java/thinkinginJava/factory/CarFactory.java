package thinkinginJava.factory;

public class CarFactory extends VehicleFactory{

	@Override
	Movable create() {
		System.out.println("1 生产车轮子");
		System.out.println("2 生产车身");
		System.out.println("3 组装车轮子和车身");
		return new Car();
	}

}
