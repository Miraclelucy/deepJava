package thinkinginJava.chapter12;

public class MyException2 extends Throwable{
	public MyException2(String str2){
		printMyException(str2);
	} 
	public void printMyException(String  str){
		System.out.println("-------my exception is --------"+str);
	}
	
	public static void whocallexception() throws MyException2{
		throw new MyException2("this is  a big error");
	}
	public static void main(String[] args) {
		 try {
			whocallexception();
		} catch (MyException2 e) {
			e.printStackTrace();
		}
	}
}
