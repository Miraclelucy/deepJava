package thinkinginJava.springTransactionProxy;

public class UserImpl  implements UserDao{
	 public void addUser(){
		 System.out.println("插入一张表");
		 System.out.println("插入另一张表");
	 }
}
