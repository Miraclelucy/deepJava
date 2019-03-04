package thinkinginJava.thinkinginoo;

import java.util.ArrayList;
import java.util.Collection;

public class Farm {
	
	private int initCattle;
	private ArrayList<Cattle> lists =new ArrayList<Cattle>();
	public void addCattle(Cattle cattle){
		lists.add(cattle);
	}
	
	public void initFarm(Collection<Cattle> c){
		lists.addAll(c);
		for(Cattle  cattle: lists){
			cattle.setFarm(this);
		}
		
	}
	
	public int getCattleNumByYear(int year){
		for (int i=1;i<year;i++){
			//	for(Cattle  cattle: (ArrayList<Cattle>)lists.clone()){
				//for(Cattle  cattle:lists){//会报错java.util.ConcurrentModificationException
			for(int j =0;j<lists.size();j++){
					Cattle  cattle=lists.get(j);
					cattle.growUp();				
			}
			System.out.println(i+"年后，农场一共有牛："+lists.size());
		}
		return lists.size();
	}
	
	public static void main(String[] args) {
		Farm farm=new Farm();
		Cattle cow = new Cattle(farm,1);
		//Collection<Cattle> c=new ArrayList<Cattle>();
		//c.add(cow);
		//farm.initFarm(c);
		farm.addCattle(cow);
		System.out.println("第20年初，农场一共有牛："+farm.getCattleNumByYear(20));
		
	}
}
