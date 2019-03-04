package basicDemo;

import java.lang.reflect.*;
import java.lang.reflect.ParameterizedType;
import java.util.*;

/**  
 * @Title: Test.java
 * @Package deepJava
 * @Description: 张孝祥《J2SE高深讲解》 第42讲  泛型的综合应用
 * @author lushiqin
 * @date 2017年10月20日 下午12:45:41
 * @version V1.0  
 */
public class GenericClassCustomize<E> {

	public  void add(E e){
		
	}
	
	public E getByid(int id ){
		return null;
	}
	
	
	public Set<E> findByCollection(String name ){
		return null;
	}
	
	
	public  void delete(E e){
		
	}
	
    /*public static  void delete(E e){  //2 ERROR 当一个变量被申明为泛型时， 静态方法和静态变量不能调用；只有实例变量和实例方法才能调用
		
	}*/
	
	public static  void delete(ArrayList<Date> e,HashSet set){ //3 获取泛型中的实际参数,即Date
		
		
	}
	
	public static void main(String[] args) throws Exception {
		//1反射获取方法
		Method m=GenericClassCustomize.class.getMethod("delete", ArrayList.class,HashSet.class);
		//2 Returns an array of Type objects that represent the formal parameter types
		Type[] types= m.getGenericParameterTypes();
		System.out.println("---方法有几个参数--"+types.length);
		//3 ParameterizedType represents a parameterized type such as Collection<String>. 
		ParameterizedType t=(ParameterizedType)types[0];
		System.out.println("---泛型的原类型--"+t.getRawType());
		System.out.println("------泛型的实际类型--------"+t.getActualTypeArguments()[0]);
		
	}
	
}
	

/**
 * 总结：
 * 1 在对泛型类型进行参数化时，类型参数的实例必须是引用类型，不能是基本类型
 * 2 如何获取泛型中的实际参数
 * 
 * 
 * 
 **/
