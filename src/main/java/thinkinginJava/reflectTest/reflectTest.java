package thinkinginJava.reflectTest;

import java.io.IOException;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.*;

/**  
 * @Title: reflectTest.java
 * @Package reflectTest
 * @Description: some charater about reflect 
 * @author lushiqin  
 * @date 2017年10月20日 下午11:01:50
 * @version V1.0  
 */
public class reflectTest {
	// 取构造方法
  public  static void get  ()
  {
	 Class <?> cls=String.class;
	 Constructor<?>[] cons=cls.getConstructors();
	 for(int i=0;i<cons.length;i++){ 
		 System.out.println("构造函数---"+cons[i]);
	 }
  }
  public void fun(Object obj){}
  public static void sleep(String str) throws Exception{}
  public static final String show(){
	  return null;
  }
  public HashMap haha(int a,int b)  {return null;}
  public void set(ArrayList<Map> map) throws ClassNotFoundException, IOException{}
  
  public static void main(String[] args) throws Exception {
//	get();
	Class c=Class.forName("reflectTest.reflectTest");
	Method[] m=c.getDeclaredMethods();
	for (int i=0;i<m.length;i++){
		System.out.print(Modifier.toString(m[i].getModifiers())+"  "); // get the method modifier
		System.out.print(m[i].getReturnType().getSimpleName()+"  "); // get return type
		System.out.print(m[i].getName()+"  ("); // get the method name
		Class<?>[] cla =m[i].getParameterTypes(); // get the method paramters
			if (cla.length > 0) {
				for (int j = 0; j < cla.length; j++) {
					System.out.print(cla[j].getSimpleName() + " arg_" + j);
					if (j < cla.length - 1) {
						System.out.print(",");
					}
				}

			}
			System.out.print(")");
			System.out.println("\n");
		}
	
	//取方法的修饰符
    //取方法的方法名称
	//取方法的参数列表
	//取方法的异常列表
	
  }
}
