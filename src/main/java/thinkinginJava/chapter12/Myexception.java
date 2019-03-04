package thinkinginJava.chapter12;

public class Myexception extends Exception {
	private String str;

	public Myexception() {
	}

	public Myexception(String str) {
		this.str = str;
	}

	public void printException() {
		System.out.println("Exception from Myexception:" + str);

	}
}
