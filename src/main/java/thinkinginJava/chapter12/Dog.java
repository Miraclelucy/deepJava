package thinkinginJava.chapter12;

public class Dog {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dog() {
	}

	public Dog(String name) {
		System.out.println("this a dog ,its name is:" + name);
	}

	public void shout(Dog dog) throws Myexception {
		throw new Myexception("XX-007指针异常");
		// System.out.println("wang,wang,wang");

	}
	
	public void call() throws Myexception {
		throw new Myexception("XX-001指针异常");
		// System.out.println("wang,wang,wang");

	}
}
