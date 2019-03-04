package thinkinginJava.chapter12;

public class LoseException {
	public static void main(String[] args) {
		try {
			throw new MyException2("-this may lose myexception--");
		}finally{
			return;
		}
	}
}
