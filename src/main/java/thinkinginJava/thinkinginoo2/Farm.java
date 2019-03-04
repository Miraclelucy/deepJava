package thinkinginJava.thinkinginoo2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Farm {
	// 存放所有的牛
	private List<Cow> cows = new ArrayList<Cow>();

	// 农场里生出里一头母牛，当然要添加到牛群中
	public void addCow(Cow cow) {
		cows.add(cow);
	}
	
	public int getCowsNumber() {
		return cows.size();
	}
	
	//每年牛都要长一岁，并且到年龄了就产小母牛
	public void everyYear() {
		for (int i = 0; i < cows.size(); i++) {
			Cow cow = cows.get(i);
			//每年母牛都要增长一岁
			cow.growth();
			//如果年龄到了，就在该年开始产小母牛
			if (cow.getAge() >= 5) {
				cows.add(cow.giveBirth());
			}
		}
	}
	public static void main(String[] args) {
		int year = 20;
		Farm farm = new Farm();
		// 刚开始，必须有头母牛
		farm.addCow(new Cow());
		// 调用方法计算
		for(int y=1; y<year; y++) {
			farm.everyYear();
			System.out.println("第" + y + "年，共有:" + farm.getCowsNumber());
		}
	}
}


	
