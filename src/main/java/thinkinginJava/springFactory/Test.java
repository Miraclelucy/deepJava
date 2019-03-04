package thinkinginJava.springFactory;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Test {
	public static void main(String[] args) throws IOException {
		//传统的方式 new一个对象，然后调用它
		Movable a=new Car();
		a.run();
		//采用spring bean对象工厂的方式来产生对象
		Properties p= new Properties();
		p.load(Test.class.getClassLoader().getResourceAsStream("springFactory/application.properties"));
		String valueName=p.getProperty("Vehicle");
		System.out.println(valueName);
		try {
			Class c=Class.forName(valueName);
			Movable b=(Movable) c.newInstance();//这就是大名鼎鼎的反射机制了，好好学啊，呆萌girl
			//普通方式调用方法
			//b.run();
			//利用反射机制调用方法
			Method m= c.getMethod("run");
			System.out.println("---------反射调用方法---------");
			m.invoke(b); //运行时调用指定的方法
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
