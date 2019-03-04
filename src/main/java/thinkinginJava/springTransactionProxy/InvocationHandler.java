package thinkinginJava.springTransactionProxy;

import java.lang.reflect.Method;

public interface InvocationHandler {
	public void invoke(Object j, Method m);  //给我一个方法，我就对这个方法做特殊的处理，处理方法由子类来决定
}
