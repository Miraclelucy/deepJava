package thinkinginJava.springTransactionProxy;

import java.io.IOException;

public class TransactionTest {
	public static void main(String[] args) {
		UserDao u=new UserImpl();
		InvocationHandler  th=new  TransactionHandler(u); 
		try {
			UserDao ud=(UserDao)Proxy.newProxyInstacne(UserDao.class, th);
			ud.addUser();
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}
}
