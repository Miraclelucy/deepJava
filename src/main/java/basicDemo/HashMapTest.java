package basicDemo;

import java.util.HashMap;
import java.util.*;


/**
 * @author lushiqin 20171019
 * 张孝祥《J2SE高深讲解》 第39讲 泛型综合案例
 *
 */
public class HashMapTest {
	
	public static void main(String[] args) {
		HashMap<String ,Integer>  map=new HashMap<String, Integer>();
		map.put("a", 20);
		map.put("b", 19);
		map.put("c", 18);
		map.put("d", 17);
		Set<Map.Entry<String, Integer>> entrySet=map.entrySet();
		for(Map.Entry<String, Integer>  entry: map.entrySet()){
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}
}
