package thinkinginJava.springFactoryxml;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) throws IOException {
		
		//采用spring bean对象工厂的方式来产生对象
		BeanFactory factory=new ClassPathXmlApplicationContext("classpath:springFactoryxml/applicationContext.xml");
		Object j=factory.getBean("train");
		Movable m=(Movable)j;
		m.run();
	}
}
