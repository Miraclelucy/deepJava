package thinkinginJava.factory;

public class PlaneFactory extends VehicleFactory{

	@Override
	Movable create() {
		System.out.println("1 生产飞机双翼");
		System.out.println("2 生产飞机机身");
		System.out.println("3 生成飞机其他配件");
		System.out.println("4 组装零件，一架飞机正在诞生");
		System.out.println("5 FUCK!!你有没有常识啊，飞机是你说能造就能造的，傻逼！");
		return new Plane();
	}

}
