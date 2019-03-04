package thinkinginJava.chapter12;

public class TestException {

	public static void main(String[] args) {

		/*System.out
				.println("---------1----打印基础异常对象Exception构造器中的参数--------------");
		try {
			throw new Exception("Java");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.err.println("finally");
		}*/

		System.out.println("---------2---捕获自定义的XX-007异常--------------");
		Dog d = new Dog();
		try {
			d.shout(d);
		} catch (Myexception e) {
			e.printException();
		}
		System.out.println("---------3----捕获null对象异常--------------");

		Dog t = null;
		try {
			t.call();
		} catch (Myexception e) {
			e.printException();
			//e.printStackTrace();
		}
	}

}
