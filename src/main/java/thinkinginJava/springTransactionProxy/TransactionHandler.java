package thinkinginJava.springTransactionProxy;

import java.lang.reflect.Method;

public class TransactionHandler implements  InvocationHandler{
	public TransactionHandler(Object target) {
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
		System.out.println("---事务启动处理---");
		try {
			m.invoke(target); 
		}  catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("--事务结束的处理---");
			
	}
}
