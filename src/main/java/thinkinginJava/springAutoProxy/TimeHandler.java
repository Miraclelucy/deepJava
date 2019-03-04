package thinkinginJava.springAutoProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {
	public TimeHandler(Object target) {
		super();
		this.target = target;
	}
	private Object target;
	public Object getJ() {
		return target;
	}
	public void setJ(Object j) {
		this.target = j;
	}
	@Override
	public void invoke(Object j,Method m) {
		long startTime=System.currentTimeMillis();
		System.out.println("---开始时间---"+(startTime));
		try {
			m.invoke(target); 
		}  catch (Exception e) {
			e.printStackTrace();
		}
		long endTime=System.currentTimeMillis();
		System.out.println("--结束时间---"+(endTime));
			
	}


}
