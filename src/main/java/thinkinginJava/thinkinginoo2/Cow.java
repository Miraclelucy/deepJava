package thinkinginJava.thinkinginoo2;
public class Cow {
	private int age;

	public Cow() {
		this.age = 0;
	}

	//五岁后可生产一头小母牛
	public Cow giveBirth() {
		return new Cow();
	}
	//每年年龄都是要增加的
	public void growth() {
		this.age++;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}