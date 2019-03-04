package basicDemo;

import java.util.Collection;
import java.util.Date;
import java.util.*;

/**
 * @author lushiqin 20171019
 * 张孝祥《J2SE高深讲解》 第38讲 泛型通配符扩展
 *
 */
public class ParameteredType {
	//只能打印装有Object对象的的集合类型
	public static void printCollection(Collection<Object>  cols){
		for (Object j:cols){
			System.out.println(j.toString());
		}
		cols.add("hello world!");
		cols=new HashSet<Object>();//这里只能是Object类型的
	}
	
	/*public static void printCollection2(Collection<?>  cols){
		for (Object j:cols){
			System.out.println(j.toString());
		}
		//cols.add("hello world!");//错误，因为它不知道自己未来是什么类型
		cols=new HashSet<Date>();
	}*/
	
	public static <T>void printCollection2(Collection<T>  cols){
		for (Object j:cols){
			System.out.println(j.toString());
		}
		//cols.add("hello world!");//错误，因为它不知道自己未来是什么类型
		cols=new HashSet<T>();
	}
	
	
	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();
		list.add("123");
		list.add("456");
		list.add("789");
		list.add("abc");
		printCollection2(list);
	}
	
}
