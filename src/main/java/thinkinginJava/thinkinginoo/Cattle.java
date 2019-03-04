package thinkinginJava.thinkinginoo;
public class Cattle {
	private int age;
	private  Farm farm;
	public Farm getFarm() {
		return farm;
	}
	public void setFarm(Farm farm) {
		this.farm = farm;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Cattle(Farm farm,int age){
		this.farm=farm;
		this.age=age;
	}
	
	public void growUp(){
		if(age++>=5){
			farm.addCattle(new Cattle(farm,1));
		}
	}
}
