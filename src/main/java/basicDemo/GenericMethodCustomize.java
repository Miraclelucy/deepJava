package basicDemo;

import java.util.*;

/**
 * @author lushiqin 20171019
 * 张孝祥《J2SE高深讲解》 第40讲 自定义泛型方法
 *
 */
public class GenericMethodCustomize {
	
	//1.把某类型的数组全部填充为某类型的对象
	public static  <T> void getFillT (T[] a,T t ){
		for(int i=0;i<a.length;i++){
			a[i]=t;
			System.out.println("------------"+i+"------"+a[i]);
		}
	}
	
	//2.把某类型的ArrayList填充5个某类型的对象
	public static  <T> void getFillList (ArrayList<T> a,T t ){
		for(int i=0;i<5;i++){
			a.add(t) ;
			System.out.println("------------"+i+"------"+a.get(i));
		}
	}
	
	//3 把任意参数类型的集合拷贝到相应类型的数组
	public static <T> void copy(Collection<T> a,T[] b){
		for(int i=0;i<b.length;i++){
			a.add(b[i]);
		}
	}
	
	
	public static void main(String[] args) {
		//演示-1.把某类型的数组全部填充为某类型的对象
		Date t=new Date();
		Date[] dateary=new Date[4];
		getFillT(dateary,t);
		
		//演示-2.把某类型的ArrayList全部填充为某类型的对象
		/*String a="早起的虫儿被鸟吃---O(∩_∩)O哈哈~";
		ArrayList<String>  list=new ArrayList<String>();
		getFillT (list,a );*/
		
		//演示-3.把任意参数类型的集合拷贝到相应类型的数组
		ArrayList  list=new ArrayList();
		copy(list,dateary);
		System.out.println(list.toString());
		
		
		ArrayList  list2=new ArrayList();
		getFillList (list2,123 );
		
	}
}


/**
 * 总结：泛型的方法需要在返回值前面加上<T>,然后即可以使用这个类型了 
 * 
 * 
 * 
 * 
 **/